package com.jmteam.rubymod.tabs;

import com.jmteam.rubymod.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import static com.jmteam.rubymod.util.Reference.BACKGROUND_TAB;

public class RubyBlocks extends CreativeTabs
{
    public RubyBlocks(String label) {
        super(label);
        this.setBackgroundImageName(BACKGROUND_TAB);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModBlocks.RUBY_BLOCK);
    }

}
