package com.jmteam.rubymod.common.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RMRecipes {

    public static void init()
    {
        GameRegistry.addSmelting(RMBlocks.RUBY_ORE, new ItemStack(RMItems.RUBY, 1),1.5f);
    }
}
