package com.items.tools;

import com.Main;
import com.init.ModItems;
import com.tabs.RubyTabs;
import com.util.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe implements IHasModel
{
    public ToolPickaxe(String name, Item.ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(name);
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
