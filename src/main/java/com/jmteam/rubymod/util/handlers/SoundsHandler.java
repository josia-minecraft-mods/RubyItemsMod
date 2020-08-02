package com.jmteam.rubymod.util.handlers;

import com.jmteam.rubymod.RubyMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler
{


    public static void registerSounds()
    {
    }

    private  static SoundEvent registerSound(String name)
    {
        ResourceLocation location = new ResourceLocation(RubyMod.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}

