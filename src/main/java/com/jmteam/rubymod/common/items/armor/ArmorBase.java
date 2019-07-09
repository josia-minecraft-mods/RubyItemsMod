package com.jmteam.rubymod.common.items.armor;

import com.jmteam.rubymod.Main;
import com.jmteam.rubymod.init.ModItems;
import com.jmteam.rubymod.tabs.RubyTabs;
import com.jmteam.rubymod.util.IHasModel;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;


public class ArmorBase extends ItemArmor implements IHasModel
{
    public ArmorBase(String name , ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlot)
    {
        super(material, renderIndex, equipmentSlot);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(RubyTabs.rubyarmor);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
