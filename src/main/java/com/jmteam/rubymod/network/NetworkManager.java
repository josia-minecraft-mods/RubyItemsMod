package com.jmteam.rubymod.network;

import com.jmteam.rubymod.RubyMod;
import com.jmteam.rubymod.network.packets.PacketSwitchScythe;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkManager {
    public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(RubyMod.MODID);
    private static int id = -1;

    public static void init() {
        NETWORK.registerMessage(PacketSwitchScythe.Handler.class, PacketSwitchScythe.class, id++, Side.SERVER);
    }
}
