package com.jmteam.rubymod.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class PlayerUtil {
    public static boolean hasItemInHands(EntityPlayer player, ItemStack stack) {
        return player.getHeldItem(EnumHand.MAIN_HAND).getItem() == stack.getItem() || player.getHeldItem(EnumHand.OFF_HAND).getItem() == stack.getItem();
    }

    public static EnumHand getHandForItem(EntityPlayer player, ItemStack stack) {
        if(hasItemInHands(player, stack)) {
            return  player.getHeldItem(EnumHand.MAIN_HAND).getItem() == stack.getItem() ? EnumHand.MAIN_HAND : EnumHand.OFF_HAND;
        }

        return EnumHand.MAIN_HAND;
    }
}
