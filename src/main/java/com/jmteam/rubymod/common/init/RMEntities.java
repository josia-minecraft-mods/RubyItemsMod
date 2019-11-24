package com.jmteam.rubymod.common.init;

import com.jmteam.rubymod.RubyMod;
import com.jmteam.rubymod.common.entity.EntityBullet;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class RMEntities {

    @SubscribeEvent
    public static void addEntities(RegistryEvent.Register<EntityEntry> e) {
        IForgeRegistry<EntityEntry> reg = e.getRegistry();
        reg.registerAll(EntityEntries.BULLET);
    }

    @GameRegistry.ObjectHolder(RubyMod.MODID)
    public static class EntityEntries {
        public static final EntityEntry BULLET = EntityEntryBuilder.create().entity(EntityBullet.class).id(new ResourceLocation(RubyMod.MODID, "bullet"), 0).name("bullet").tracker(80, 3, true).build();
    }
}
