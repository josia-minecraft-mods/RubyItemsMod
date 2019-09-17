package com.jmteam.rubymod.client.gui;

import com.jmteam.rubymod.RubyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class GuiPhone extends GuiScreen {

    final ResourceLocation texture = new ResourceLocation(RubyMod.MODID, "textures/gui/phone.png");
   int guiWidth = 175;
   int guiHeight = 228;

   GuiButton button1;

   final int BUTTON1 = 0;

@Override
    public void drawScreen(int mouseX, int MouseY, float partialTicks)
{
    drawDefaultBackground();
    Minecraft.getMinecraft().renderEngine.bindTexture(texture);
    int CenterX = (width / 2) - guiWidth / 2;
    int CenterY =  (height / 2) - guiHeight / 2;

    drawTexturedModalRect(CenterX, CenterY , 0,0, guiWidth, guiHeight);
    super.drawScreen(mouseX, MouseY, partialTicks);
}

    @Override
    public void initGui()
    {
        buttonList.clear();
        buttonList.add(button1 = new GuiButton(BUTTON1, 0, 0, 100, 20, "Button"));
        super.initGui();
    }


    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    switch (button.id)
    {
        case BUTTON1:
            Minecraft.getMinecraft().getSoundHandler().stopSounds();
            break;
    }
        super.actionPerformed(button);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
