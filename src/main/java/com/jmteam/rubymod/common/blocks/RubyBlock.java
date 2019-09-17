package com.jmteam.rubymod.common.blocks;

import com.jmteam.rubymod.common.tabs.RubyTabs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class RubyBlock extends BlockBase {

    public RubyBlock(Material material) {
        super(material);

        setSoundType(SoundType.METAL);
        setHardness(5.0F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 2);
    }
}
