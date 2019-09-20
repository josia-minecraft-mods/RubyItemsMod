package com.jmteam.rubymod.common.items;

import com.jmteam.rubymod.common.init.RMItems;
import com.jmteam.rubymod.common.tabs.RubyTabs;
import com.jmteam.rubymod.util.handlers.SoundsHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;


public class ItemPhone extends Item {


    public ItemPhone() {
        setMaxStackSize(1);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (worldIn.isRemote) {
            ItemStack stack = playerIn.getHeldItem(handIn);
            NBTTagCompound nbt = stack.getTagCompound();
            if (nbt == null) {
                nbt = new NBTTagCompound();
                nbt.setInteger("use", 1);
                stack.setTagCompound(nbt);
            }
            if (nbt.hasKey("use")) {
                int use = nbt.getInteger("use");

                if (use == 2) {
                    Minecraft.getMinecraft().getSoundHandler().stopSounds();
                    nbt.setInteger("use", 1);
                }
            }

            if (playerIn.isSneaking()) {
                if (playerIn.inventory.armorInventory.get(EntityEquipmentSlot.HEAD.getIndex()).isEmpty()) {
                    playerIn.inventory.armorInventory.set(EntityEquipmentSlot.HEAD.getIndex(), PhoneOnHead());
                    Minecraft.getMinecraft().getSoundHandler().stopSounds();
                    stack.shrink(1);
                    playerIn.playSound(SoundsHandler.PHONE, 1.0F, 1.0F);
                }
            }
        }
        return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

    private static ItemStack PhoneOnHead() {
        ItemStack stack = new ItemStack(RMItems.RUBY_PHONE);

        NBTTagCompound nbt;
        nbt = new NBTTagCompound();
        nbt.setInteger("use", 2);
        stack.setTagCompound(nbt);
        return stack.copy();
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("§eWIP ItemPhone");
        tooltip.add("§cShift + Right Click");
        tooltip.add("§cRight Click");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }


    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setInteger("use", 1);
        }
    }
}
