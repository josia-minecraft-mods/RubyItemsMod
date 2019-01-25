package com.items.tools;

import com.Main;
import com.init.ModItems;
import com.tabs.RubyTabs;
import com.util.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

public class ToolSpade extends ItemSpade implements IHasModel
{
    public ToolSpade(String name, Item.ToolMaterial material)
    {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(RubyTabs.rubytools);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
