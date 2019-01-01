package com.util.helper;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Helper {

    public static Random rand = new Random();


    public static String formatBlockPos(BlockPos pos) {
        if (pos == null || pos.equals(BlockPos.ORIGIN)) return "None";
        return pos.getX() + ", " + pos.getY() + ", " + pos.getZ();
    }

    public static Vec3d convertToPixels(Vec3d vec) {
        return new Vec3d(vec.x / 16, vec.y / 16, vec.z / 16);
    }

    public static Vec3d convertToPixels(double x, double y, double z) {
        return new Vec3d(x / 16, y / 16, z / 16);
    }

    public static BlockPos getLowestBlock(World world, BlockPos pos) {
        pos = new BlockPos(pos.getX(), 0, pos.getZ());
        for (int i = 0; i < 256; ++i) {
            if (world.getBlockState(pos).getBlock() == Blocks.AIR && world.getBlockState(pos.up()).getBlock() == Blocks.AIR) return pos;
            pos = pos.up();
        }
        return null;
    }

    public static double clamp(double f, double f1) {
        return f > f1 ? f1 : f;
    }

    public static AxisAlignedBB createBB(BlockPos pos, double i) {
        return new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1).grow(i);
    }

    public static boolean isSafe(World world, BlockPos pos, EnumFacing facing) {
        return world.getBlockState(pos).getMaterial().equals(Material.AIR) && world.getBlockState(pos.down()).isTopSolid() && world.getBlockState(pos.up()).getMaterial().equals(Material.AIR) && world.getBlockState(pos.offset(facing)).getMaterial().equals(Material.AIR) && world.getBlockState(pos.offset(facing).up()).getMaterial().equals(Material.AIR);
    }

    public static float getAngleFromFacing(EnumFacing facing) {
        float angle = 0;
        if (facing.equals(EnumFacing.EAST)) angle = 90;
        if (facing.equals(EnumFacing.SOUTH)) angle = 180;
        if (facing.equals(EnumFacing.WEST)) angle = 270;
        return angle;
    }

    public static Rotation getRotationFromFacing(EnumFacing facing) {
        switch (facing) {
            case NORTH:
                return Rotation.COUNTERCLOCKWISE_90;
            case EAST:
                return Rotation.CLOCKWISE_90;
            case SOUTH:
                return Rotation.CLOCKWISE_180;
            case WEST:
                return Rotation.COUNTERCLOCKWISE_90;
            default:
                return Rotation.NONE;
        }
    }

    public static float get360FromFacing(EnumFacing facing) {
        switch (facing) {
            case NORTH:
                return 180;
            case EAST:
                return -90;
            case SOUTH:
                return 0;
            default:
                return 90;
        }
    }

    public static boolean isIntInRange(int min, int max, int num) {
        return num < max && num > min;
    }

    public static int getSlotForItem(EntityPlayer player, Item item) {
        for(int i = 0; i < player.inventory.mainInventory.size(); ++i) {
            if(player.inventory.getStackInSlot(i).getItem() == item) {
                return i;
            }
        }
        return -1;
    }

    public static Vec3d blockPosToVec3d(Vec3i pos) {
        return new Vec3d(pos.getX(), pos.getY(), pos.getZ());
    }

    public static BlockPos getSafePosLower(BlockPos pos, World world, EnumFacing facing) {
        for(int y = pos.getY(); y > 0; --y) {
            BlockPos lPos = new BlockPos(pos.getX(), y, pos.getZ());
            if(Helper.isSafe(world, lPos, facing)) {
                return lPos;
            }
        }
        return BlockPos.ORIGIN;
    }

    public static BlockPos getSafeHigherPos(World world, BlockPos pos, EnumFacing facing) {
        for(int y = pos.getY(); y < world.getHeight(); ++y) {
            BlockPos lPos = new BlockPos(pos.getX(), y, pos.getZ());
            if(Helper.isSafe(world, lPos, facing)) {
                return lPos;
            }
        }
        return BlockPos.ORIGIN;
    }

    public static float precentToPixels(float f) {
        return f / 16.0F;
    }

    public static String formatDimensionName(String name) {
        name = name.replace("_", " ");
        char[] nameChars = name.toCharArray();
        for(int index = 0; index < nameChars.length; ++index) {
            if(nameChars[index] == ' ' && index + 1 < nameChars.length) {
                char c = nameChars[index + 1];
                nameChars[index + 1] = Character.toUpperCase(c);
            }
        }
        nameChars[0] = Character.toUpperCase(nameChars[0]);
        return new String(nameChars);
    }

    /**
     * Stops those nasty null pointers
     * **/
    public static NBTTagCompound getStackTag(ItemStack stack) {
        if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
        return stack.getTagCompound();
    }


    public static BlockPos scaleBP(BlockPos dist, double i) {
        return new BlockPos(dist.getX() * i, dist.getY() * i, dist.getZ() * i);
    }


    public static boolean isThisBlockBehindTheWorldBorder(BlockPos pos, int dim){
        return FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(dim).getWorldBorder().contains(pos);
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
