package com.init;

import com.items.ItemBase;
import com.items.tools.*;
import javafx.scene.paint.Material;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems
{
    public static final List<Item> ITEMS = new ArrayList<Item>();

    //Materials
    public static final Item.ToolMaterial MATERIAL_RUBY = EnumHelper.addToolMaterial("material_ruby", 3, 1200,8.0F, 3.0F, 10);

    //Items
    public static final Item RUBY = new ItemBase("ruby");

    //Tools
    public static final ItemSword RUBY_SWORD = new ToolSword("ruby_sword", MATERIAL_RUBY);
    public static final ItemSpade RUBY_SHOVEL = new ToolSpade("ruby_shovel", MATERIAL_RUBY);
    public static final ItemHoe RUBY_HOE = new ToolHoe("ruby_hoe", MATERIAL_RUBY);
    public static final ItemAxe RUBY_AXE = new ToolAxe("ruby_axe", MATERIAL_RUBY);
    public static final ItemPickaxe RUBY_PICKAXE = new ToolPickaxe("ruby_pickaxe", MATERIAL_RUBY);

}

