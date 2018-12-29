package com.tabs;

import com.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class FunTools extends CreativeTabs
{
    public FunTools(String label) {
        super("funtools");
        this.setBackgroundImageName("josiamod.png");}

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ModItems.RUBY_AXE);
    }
}
