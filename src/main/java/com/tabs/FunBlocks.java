package com.tabs;

import com.init.ModBlocks;
import com.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class FunBlocks extends CreativeTabs
{
    public FunBlocks(String label) {
        super("funblocks");
        this.setBackgroundImageName("josiamod.png");}

        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModBlocks.RUBY_BLOCK);
        }
    }



