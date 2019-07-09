package com.jmteam.rubymod;

import com.jmteam.rubymod.init.ModItems;
import com.jmteam.rubymod.init.ModRecipes;
import com.jmteam.rubymod.util.Reference;
import com.jmteam.rubymod.proxy.CommonProxy;
import com.jmteam.rubymod.util.handlers.RegistryHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Logger;
import com.jmteam.rubymod.world.ModWorldGen;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)

public class Main
{
    @Mod.Instance
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
    public static CommonProxy proxy;
    public static Logger logger;

    @Mod.EventHandler
    public static void PreInit(FMLPreInitializationEvent event)
    {
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
        OreDictionary.registerOre("ruby", ModItems.RUBY);
    }

    @Mod.EventHandler
    public static void Init(FMLInitializationEvent event)
    {
        ModRecipes.init();
        RegistryHandler.initRegistries();
    }

    @Mod.EventHandler
    public static void PostInit(FMLPostInitializationEvent event)
    {

    }
}

