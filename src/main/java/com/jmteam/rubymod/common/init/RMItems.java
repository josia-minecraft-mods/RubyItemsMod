package com.jmteam.rubymod.common.init;

import com.jmteam.rubymod.RubyMod;
import com.jmteam.rubymod.common.items.ItemBase;
import com.jmteam.rubymod.common.items.ItemArmorBase;
import com.jmteam.rubymod.common.items.ItemCrescentRose;
import com.jmteam.rubymod.common.tabs.RubyTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class RMItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    //Materials
    public static final Item.ToolMaterial MATERIAL_RUBY = EnumHelper.addToolMaterial("material_ruby", 3, 1200, 8.0F, 3.0F, 10);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_RUBY = EnumHelper.addArmorMaterial("armor_material_ruby", RubyMod.MODID + ":ruby", 14,
            new int[]{2, 7, 5, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);

    //Items
    public static final Item RUBY = registerItem(new ItemBase(), "ruby");

    //Tools
  /* public static final ItemSword RUBY_SWORD = new ToolSword("ruby_sword", MATERIAL_RUBY);
    public static final ItemSpade RUBY_SHOVEL = new ToolSpade("ruby_shovel", MATERIAL_RUBY);
    public static final ItemHoe RUBY_HOE = new ToolHoe("ruby_hoe", MATERIAL_RUBY);
    public static final ItemAxe RUBY_AXE = new ToolAxe("ruby_axe", MATERIAL_RUBY);
    public static final ItemPickaxe RUBY_PICKAXE = new ToolPickaxe("ruby_pickaxe", MATERIAL_RUBY);*/

    //Armor
    public static final Item RUBY_HELMET = registerItem(new ItemArmorBase(ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.HEAD), "ruby_helmet").setCreativeTab(RubyTabs.rubyitems);
    public static final Item RUBY_CHESTPLATE = registerItem(new ItemArmorBase(ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.CHEST),"ruby_chestplate").setCreativeTab(RubyTabs.rubyitems);
    public static final Item RUBY_LEGGINGS = registerItem(new ItemArmorBase(ARMOR_MATERIAL_RUBY, 2, EntityEquipmentSlot.LEGS), "ruby_leggings").setCreativeTab(RubyTabs.rubyitems);
    public static final Item RUBY_BOOTS = registerItem(new ItemArmorBase(ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.FEET), "ruby_boots").setCreativeTab(RubyTabs.rubyitems);

    //Misc
    public static final Item CIRCUIT = registerItem(new ItemBase(), "circuit").setCreativeTab(RubyTabs.rubyitems);
    public static final Item CRESCENT_ROSE = registerItem(new ItemCrescentRose(), "crescent_rose").setCreativeTab(RubyTabs.rubyitems);

    public static void registerRenders() {
        ITEMS.forEach(i -> {
            registerRender(i);
        });
    }

    private static Item registerItem(Item item, String name) {
        item.setTranslationKey(name);
        item.setRegistryName(name);
        ITEMS.add(item);
        return item;
    }

    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public static void registerRenderMeta(Item item, int meta, String name) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(RubyMod.MODID, name), "inventory"));
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(RMItems.ITEMS.toArray(new Item[0]));
    }
}

