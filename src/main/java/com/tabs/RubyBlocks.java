package com.tabs;

import com.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import static com.util.Reference.BACKGROUND_TAB;

public class RubyBlocks extends CreativeTabs
{
    public RubyBlocks(String label) {
        super(label);
        this.setBackgroundImageName(BACKGROUND_TAB);
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ModBlocks.RUBY_BLOCK);
    }
}
