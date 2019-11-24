package com.jmteam.rubymod.common.init;

import com.jmteam.rubymod.RubyMod;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class RMKeybinds {

    public static KeyBinding SPECIAL;

    public static void init() {
        SPECIAL = new KeyBinding(RubyMod.MODID + ".keybinds.special", Keyboard.KEY_N, RubyMod.NAME);
        ClientRegistry.registerKeyBinding(SPECIAL);
    }
}
