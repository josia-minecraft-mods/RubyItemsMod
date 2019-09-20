package com.jmteam.rubymod.common.items;

import com.jmteam.rubymod.common.tabs.RubyTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;


public class ItemArmorBase extends ItemArmor
{
    public ItemArmorBase(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlot)
    {
        super(material, renderIndex, equipmentSlot);
        setCreativeTab(RubyTabs.rubyitems);

    }

}
