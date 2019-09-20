package com.jmteam.rubymod.proxy;

import com.jmteam.rubymod.common.init.RubyKeybinds;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy
{
    public void registerItemRenderer(Item item , int meta, String id)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }

    public void init(FMLInitializationEvent e) {
        RubyKeybinds.init();
    }
}
