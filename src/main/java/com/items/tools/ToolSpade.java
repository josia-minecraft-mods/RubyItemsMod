package com.items.tools;

import com.Main;
import com.init.ModItems;
import com.tabs.FunTabs;
import com.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

public class ToolSpade extends ItemSpade implements IHasModel
{
    public ToolSpade(String name, Item.ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(FunTabs.funtools);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
