package com.items.item;

import com.Main;
import com.init.ModItems;
import com.tabs.RubyTabs;
import com.util.IHasModel;
import com.util.Reference;
import com.util.handlers.SoundsHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;


public class Phone extends Item implements IHasModel {


    public Phone(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setCreativeTab(RubyTabs.rubygadgets);

        ModItems.ITEMS.add(this);
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
            }
            if (nbt.hasKey("use") && nbt.getInteger("use") == 2) {
                nbt.setInteger("use", nbt.getInteger("use") + 1);
                if (nbt.getInteger("use") == 3) {
                    nbt.setInteger("use", 1);
                }
                if (nbt.hasKey("use")) {
                    if (nbt.getInteger("use") == 1) {
                        Minecraft.getMinecraft().getSoundHandler().stopSounds();
                    }
                }
            } else {
                if (stack.getItem() == ModItems.RUBY_PHONE && playerIn.isSneaking()) {
                    if (playerIn.inventory.armorInventory.get(EntityEquipmentSlot.HEAD.getIndex()).isEmpty()) {
                        playerIn.inventory.armorInventory.set(EntityEquipmentSlot.HEAD.getIndex(), PhoneOnHead());
                        Minecraft.getMinecraft().getSoundHandler().stopSounds();
                        stack.shrink(1);
                        playerIn.playSound(SoundsHandler.PHONE, 1.0F, 1.0F);
                    }
                }
            }

            System.out.println(nbt.getInteger("use"));
            stack.setTagCompound(nbt);
        }

        return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }


    private static ItemStack PhoneOnHead() {
        ItemStack stack = new ItemStack(ModItems.RUBY_PHONE);

        NBTTagCompound nbt;
        nbt = new NBTTagCompound();
        nbt.setInteger("use", 2);
        stack.setTagCompound(nbt);
        return stack.copy();
    }

    private static ItemStack PhoneBack() {
        ItemStack stack = new ItemStack(ModItems.RUBY_PHONE);

        NBTTagCompound nbt;
        nbt = new NBTTagCompound();
        nbt.setInteger("use", 3);
        stack.setTagCompound(nbt);
        return stack.copy();
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("§eWIP Phone");
        tooltip.add("§cShift + Right Click");
        tooltip.add("§cRight Click");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }


    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
      NBTTagCompound nbt = stack.getTagCompound();
        EntityPlayer player = (EntityPlayer) entityIn;
        if(worldIn.isRemote && player.inventory.armorInventory.get(EntityEquipmentSlot.HEAD.getIndex()).isEmpty() && stack.getItem() == ModItems.RUBY_PHONE && !(stack.getTagCompound().getInteger("use") == 1)) {
            nbt.setInteger("use", 3);
            stack.setTagCompound(nbt);
            Minecraft.getMinecraft().getSoundHandler().stopSounds();
        }



    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
