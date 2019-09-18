package com.jmteam.rubymod.common.items.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemCrescentRose extends Item {

    public ItemCrescentRose() {
        addPropertyOverride(new ResourceLocation("gun"), new IItemPropertyGetter() {
            @Override
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                if (stack.getTagCompound() == null) return 0.0f;
                else return stack.getTagCompound().getBoolean("gun") ? 1.0f : 0.0f;
            }
        });
    }



}
