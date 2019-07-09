package com.jmteam.rubymod.common.items.tools;

import com.jmteam.rubymod.Main;
import com.jmteam.rubymod.init.ModItems;
import com.jmteam.rubymod.tabs.RubyTabs;
import com.jmteam.rubymod.util.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe implements IHasModel
{
    public ToolPickaxe(String name, Item.ToolMaterial material)
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
