package com.jmteam.rubymod.common.events;

import com.jmteam.rubymod.common.init.RMKeybinds;
import com.jmteam.rubymod.network.NetworkManager;
import com.jmteam.rubymod.network.packets.PacketSwitchScythe;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientEventHandler {

    @SubscribeEvent
    public static void onKeyPressed(InputUpdateEvent e) {

        if(RMKeybinds.SPECIAL.isPressed()) {
            NetworkManager.NETWORK.sendToServer(new PacketSwitchScythe());
        }
    }
}
