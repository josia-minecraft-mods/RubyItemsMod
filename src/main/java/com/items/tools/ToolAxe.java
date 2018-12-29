package com.items.tools;

import com.Main;
import com.init.ModItems;
import com.tabs.FunTabs;
import com.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;


public class ToolAxe extends ItemAxe implements IHasModel
{
    public ToolAxe(String name, ToolMaterial material)
    {
        super(material, 6.0F, -3.2F);
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
