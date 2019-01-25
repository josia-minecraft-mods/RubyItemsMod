package com.tabs;

import com.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import static com.util.Reference.BACKGROUND_TAB;

public class RubyArmor extends CreativeTabs
{
    public RubyArmor(String label) {
        super(label);
        this.setBackgroundImageName(BACKGROUND_TAB);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.RUBY_HELMET);
    }
}
