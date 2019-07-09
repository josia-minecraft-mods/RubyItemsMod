package com.jmteam.rubymod.common.items.tools;

import com.jmteam.rubymod.Main;
import com.jmteam.rubymod.init.ModItems;
import com.jmteam.rubymod.tabs.RubyTabs;
import com.jmteam.rubymod.util.IHasModel;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel {

        public ToolSword(String name, ToolMaterial material)
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
