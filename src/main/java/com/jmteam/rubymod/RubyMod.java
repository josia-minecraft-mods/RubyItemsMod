package com.jmteam.rubymod;

import com.jmteam.rubymod.common.init.RMItems;
import com.jmteam.rubymod.common.init.RubyKeybinds;
import com.jmteam.rubymod.common.init.RubyRecipes;
import com.jmteam.rubymod.network.NetworkManager;
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

@Mod(modid = RubyMod.MODID, name = RubyMod.NAME, version = RubyMod.VERSION)

public class RubyMod
{
    @Mod.Instance
    public static RubyMod instance;

    public static final String NAME = "RMItems Mod";
    public static final String VERSION = "0.0.5";
    public static final String MODID = "rubymod";

    @SidedProxy(clientSide = "com.jmteam.rubymod.proxy.ClientProxy", serverSide = "com.jmteam.rubymod.proxy.CommonProxy")
    public static CommonProxy proxy;
    public static Logger logger;

    @Mod.EventHandler
    public static void PreInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
        OreDictionary.registerOre("ruby", RMItems.RUBY);
        NetworkManager.init();
    }

    @Mod.EventHandler
    public static void Init(FMLInitializationEvent event)
    {
        RubyRecipes.init();
        RegistryHandler.initRegistries();
        proxy.init(event);
    }

    @Mod.EventHandler
    public static void PostInit(FMLPostInitializationEvent event)
    {

    }
}

