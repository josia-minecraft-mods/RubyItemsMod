package com.jmteam.rubymod.common.items;

import com.jmteam.rubymod.Main;
import com.jmteam.rubymod.init.ModItems;
import com.jmteam.rubymod.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name)
    {
        setTranslationKey(name);
        setRegistryName(name);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
