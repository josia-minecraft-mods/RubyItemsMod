package com.jmteam.rubymod.proxy;

import com.jmteam.rubymod.client.render.entity.RenderBullet;
import com.jmteam.rubymod.common.entity.EntityBullet;
import com.jmteam.rubymod.common.init.RMKeybinds;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    public void registerItemRenderer(Item item , int meta, String id)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }

    public void preInit(FMLPreInitializationEvent e) {
        RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, RenderBullet::new);
    }

    public void init(FMLInitializationEvent e) {
        RMKeybinds.init();
    }
}
