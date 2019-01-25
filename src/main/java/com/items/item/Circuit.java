package com.items.item;

import com.Main;
import com.init.ModItems;
import com.tabs.RubyTabs;
import com.util.IHasModel;
import net.minecraft.item.Item;

public class Circuit extends Item implements IHasModel {

    public Circuit(String name)
    {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(RubyTabs.rubygadgets);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
