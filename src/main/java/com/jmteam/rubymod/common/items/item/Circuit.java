package com.jmteam.rubymod.common.items.item;

import com.jmteam.rubymod.Main;
import com.jmteam.rubymod.init.ModItems;
import com.jmteam.rubymod.tabs.RubyTabs;
import com.jmteam.rubymod.util.IHasModel;
import net.minecraft.item.Item;

public class Circuit extends Item implements IHasModel {

    public Circuit(String name) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(RubyTabs.rubygadgets);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
