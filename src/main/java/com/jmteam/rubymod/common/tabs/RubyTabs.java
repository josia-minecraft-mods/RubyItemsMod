package com.jmteam.rubymod.common.tabs;


import com.jmteam.rubymod.common.init.RMItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class RubyTabs {

    public static CreativeTabs rubyitems = new CreativeTabs("rubyitems") {

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(RMItems.RUBY);
        }
    };

}
