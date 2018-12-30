package com.blocks;

import com.Main;
import com.init.ModBlocks;
import com.init.ModItems;
import com.tabs.FunTabs;
import com.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{
    public BlockBase(String name)
    {
        super(Material.GROUND);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(FunTabs.funblocks);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
