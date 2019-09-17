package com.jmteam.rubymod.common.init;

import com.jmteam.rubymod.common.blocks.RubyBlock;
import com.jmteam.rubymod.common.blocks.RubyOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class RMBlocks
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block RUBY_BLOCK = registerBlock(new RubyBlock(Material.IRON),"ruby_block");
    public static final Block RUBY_ORE = registerBlock(new RubyOre(Material.ROCK), "ruby_ore");


    private static Block registerBlock(Block block, String name) {
       return registerBlock(block, name, true);
    }

    private static Block registerBlock(Block block, String name, boolean item) {
        block.setTranslationKey(name);
        block.setRegistryName(name);
        BLOCKS.add(block);

        if(item) {
            ItemBlock block1 = (ItemBlock) new ItemBlock(block).setRegistryName(name);
            RMItems.ITEMS.add(block1);
        }

        return block;
    }


    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(RMBlocks.BLOCKS.toArray(new Block[0]));
    }
}
