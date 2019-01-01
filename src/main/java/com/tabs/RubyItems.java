package com.tabs;

import com.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import static com.util.Reference.BACKGROUND_TAB;

public class RubyItems extends CreativeTabs
{
    public RubyItems(String label) {
        super(label);
        this.setBackgroundImageName(BACKGROUND_TAB);
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ModItems.RUBY);
    }
}
