package com.items.armor;

import com.Main;
import com.init.ModItems;
import com.tabs.RubyTabs;
import com.util.IHasModel;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;


public class ArmorBase extends ItemArmor implements IHasModel
{
    public ArmorBase(String name , ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlot)
    {
        super(material, renderIndex, equipmentSlot);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(RubyTabs.rubyarmor);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
