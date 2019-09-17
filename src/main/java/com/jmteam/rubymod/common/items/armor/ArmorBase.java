package com.jmteam.rubymod.common.items.armor;

import com.jmteam.rubymod.common.tabs.RubyTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;


public class ArmorBase extends ItemArmor
{
    public ArmorBase(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlot)
    {
        super(material, renderIndex, equipmentSlot);
        setCreativeTab(RubyTabs.rubyarmor);

    }

}
