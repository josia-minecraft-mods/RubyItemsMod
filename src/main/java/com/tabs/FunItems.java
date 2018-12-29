package com.tabs;

import com.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class FunItems extends CreativeTabs
{
    public FunItems(String label) {
        super("funitems");
        this.setBackgroundImageName("josiamod.png");}

        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModItems.RUBY);
        }
    }



