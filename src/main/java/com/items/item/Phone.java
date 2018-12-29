package com.items.item;

import com.Main;
import com.init.ModItems;
import com.tabs.FunTabs;
import com.util.IHasModel;
import com.util.handlers.SoundsHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class Phone extends Item implements IHasModel {

        public Phone(String name)
        {
            setUnlocalizedName(name);
            setRegistryName(name);
            setCreativeTab(FunTabs.funitems);

            ModItems.ITEMS.add(this);
        }

        public int cooldown = 2400;
        public int stopsound = 0;
        public int run = 0;

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entity, int itemSlot, boolean isSelected)
    {
        if(cooldown == 2500) {
            cooldown = 2400;
        }

        stopsound++;
        cooldown++;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        if(!worldIn.isRemote && cooldown < 2405 && stopsound > 5) {
            Minecraft.getMinecraft().getSoundHandler().stopSounds();
            cooldown = 2400;
        }

            if (cooldown > 2400) {

                SoundEvent sound = SoundsHandler.PHONE;
                playerIn.playSound(sound, 1.0F, 1.0F);
                cooldown = 0;
                stopsound = 0;
            }
        return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

    @Override
        public void registerModels()
        {
            Main.proxy.registerItemRenderer(this, 0, "inventory");
        }
    }
