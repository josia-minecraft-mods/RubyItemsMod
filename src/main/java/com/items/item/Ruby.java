package com.items.item;

import com.Main;
import com.init.ModItems;
import com.tabs.FunTabs;
import com.util.IHasModel;
import net.minecraft.item.Item;

public class Ruby extends Item implements IHasModel {
    public Ruby(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(FunTabs.funitems);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}

