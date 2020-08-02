package com.jmteam.rubymod.client.render.entity;

import com.jmteam.rubymod.client.models.ModelPowerShoot;
import com.jmteam.rubymod.common.entity.EntityBullet;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderBullet extends Render<EntityBullet> {

    public ModelPowerShoot model = new ModelPowerShoot();

    public RenderBullet(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public void doRender(EntityBullet entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.rotate(entityYaw,0,1,0);
        model.render(entity,0,0,0,0,0, 0.0625f);
        GlStateManager.popMatrix();
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBullet entity) {
        return null;
    }

}
