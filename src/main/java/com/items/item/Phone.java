package com.items.item;

import com.Main;
import com.init.ModItems;
import com.tabs.RubyTabs;
import com.util.IHasModel;
import com.util.handlers.SoundsHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
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
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (worldIn.isRemote) {
            ItemStack stack = playerIn.getHeldItem(handIn);
            NBTTagCompound nbt = stack.getTagCompound();
            if (nbt == null) {
                nbt = new NBTTagCompound();
            }
            if (!playerIn.isSneaking()) {
                if (nbt.hasKey("use")) {
                    nbt.setInteger("use", nbt.getInteger("use") + 1);
                    if (nbt.getInteger("use") == 2) {
                        playerIn.playSound(SoundsHandler.PHONE, 1.0F, 1.0F);
                    } else {
                        if (nbt.getInteger("use") == 3) {
                            nbt.setInteger("use", 1);
                        }
                    }
                } else {
                    nbt.setInteger("use", 2);
                    playerIn.playSound(SoundsHandler.PHONE, 1.0F, 1.0F);
                }

                if (nbt.hasKey("use")) {
                    if (nbt.getInteger("use") == 1) {
                        Minecraft.getMinecraft().getSoundHandler().stopSounds();
                    }
                }
            } else {
                if (stack.getItem() == ModItems.RUBY_PHONE) {
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

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("§eWIP Phone");
        tooltip.add("§cShift + Right Click");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
