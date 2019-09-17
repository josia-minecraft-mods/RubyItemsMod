package com.jmteam.rubymod.common.tabs;

import com.jmteam.rubymod.common.init.RMItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class RubyArmor extends CreativeTabs
{
    public RubyArmor(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(RMItems.RUBY_HELMET);
    }
}
