package com.jmteam.rubymod.network.packets;

import com.jmteam.rubymod.common.init.RMItems;
import com.jmteam.rubymod.util.PlayerUtil;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;


public class PacketSwitchScythe implements IMessage {


    public PacketSwitchScythe() {
    }

    public void fromBytes(ByteBuf buf) {
    }

    public void toBytes(ByteBuf buf) {
    }

    public static class Handler implements IMessageHandler<PacketSwitchScythe, IMessage> {

        @Override
        public IMessage onMessage(PacketSwitchScythe message, MessageContext ctx) {
            ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> {
                EntityPlayerMP player = ctx.getServerHandler().player;
                ItemStack stack = player.getHeldItem(PlayerUtil.getHandForItem(player, new ItemStack(RMItems.CRESCENT_ROSE)));

                System.out.println(stack.getItem());
                if (stack.getItem() == RMItems.CRESCENT_ROSE) {
                    if (stack.getTagCompound() == null) {
                        NBTTagCompound nbt = new NBTTagCompound();
                        nbt.setBoolean("gun", true);
                        stack.setTagCompound(nbt);
                    } else {
                        stack.getTagCompound().setBoolean("gun", !stack.getTagCompound().getBoolean("gun"));
                    }
                }
            });
            return null;
        }
    }
}
