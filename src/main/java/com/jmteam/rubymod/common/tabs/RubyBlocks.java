package com.jmteam.rubymod.common.tabs;

import com.jmteam.rubymod.common.init.RMBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class RubyBlocks extends CreativeTabs
{
    public RubyBlocks(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(RMBlocks.RUBY_BLOCK);
    }

}
