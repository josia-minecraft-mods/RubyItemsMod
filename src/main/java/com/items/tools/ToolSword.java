package com.items.tools;

import com.Main;
import com.init.ModItems;
import com.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel {

        public ToolSword(String name, ToolMaterial material)
        {
            super(material);
            setUnlocalizedName(name);
            setRegistryName(name);
            setCreativeTab(CreativeTabs.COMBAT);

            ModItems.ITEMS.add(this);
        }

        @Override
        public void registerModels()
        {
            Main.proxy.registerItemRenderer(this, 0, "inventory");
        }
    }
