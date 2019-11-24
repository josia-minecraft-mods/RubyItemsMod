package com.jmteam.rubymod.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
    public void registerItemRenderer(Item item, int meta, String id) {}

    public void init(FMLInitializationEvent e) {}

    public void preInit(FMLPreInitializationEvent e) {}
}
