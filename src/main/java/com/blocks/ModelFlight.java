package com.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFlight extends ModelBase

{
    //fields
   private ModelRenderer BasePlate;
   private ModelRenderer ButtonHold;
   private ModelRenderer ButtonHold0;
   private ModelRenderer ButtonHold1;
   private ModelRenderer ButtonPress;
   private ModelRenderer ButtonPress1;
   private ModelRenderer ButtonPress2;
   private ModelRenderer SideBox;
   private ModelRenderer SideBox1;
   private ModelRenderer SideBox2;
   private ModelRenderer SideBox3;
   private ModelRenderer Shape31;
   private ModelRenderer Shape32;
   private ModelRenderer Shape33;
   private ModelRenderer Shape34;

    public ModelFlight Panel()
    {
        textureWidth = 64;
        textureHeight = 32;

        BasePlate = new ModelRenderer(this, 0, 0);
        BasePlate.addBox(0F, 0F, 0F, 16, 1, 16);
        BasePlate.setRotationPoint(-8F, 23F, -8F);
        BasePlate.setTextureSize(64, 32);
        BasePlate.mirror = true;
        setRotation(BasePlate, 0F, 0F, 0F);
        ButtonHold = new ModelRenderer(this, 0, 19);
        ButtonHold.addBox(0F, 0F, 1F, 1, 1, 1);
        ButtonHold.setRotationPoint(4F, 22.6F, -7F);
        ButtonHold.setTextureSize(64, 32);
        ButtonHold.mirror = true;
        setRotation(ButtonHold, 0F, 0F, 0F);
        ButtonHold0 = new ModelRenderer(this, 0, 19);
        ButtonHold0.addBox(0F, 0F, 0F, 1, 1, 1);
        ButtonHold0.setRotationPoint(-5F, 22.6F, -6F);
        ButtonHold0.setTextureSize(64, 32);
        ButtonHold0.mirror = true;
        setRotation(ButtonHold0, 0F, 0F, 0F);
        ButtonHold1 = new ModelRenderer(this, 0, 19);
        ButtonHold1.addBox(0F, 0F, 0F, 4, 1, 1);
        ButtonHold1.setRotationPoint(-2F, 22.6F, -6F);
        ButtonHold1.setTextureSize(64, 32);
        ButtonHold1.mirror = true;
        setRotation(ButtonHold1, 0F, 0F, 0F);
        ButtonPress = new ModelRenderer(this, 0, 30);
        ButtonPress.addBox(0F, 0F, 0F, 1, 1, 1);
        ButtonPress.setRotationPoint(4F, 22.6F, -5.2F);
        ButtonPress.setTextureSize(64, 32);
        ButtonPress.mirror = true;
        setRotation(ButtonPress, 0.1745329F, 0F, 0F);
        ButtonPress1 = new ModelRenderer(this, 0, 30);
        ButtonPress1.addBox(0F, 0F, 0F, 4, 1, 1);
        ButtonPress1.setRotationPoint(-2F, 22.6F, -5.2F);
        ButtonPress1.setTextureSize(64, 32);
        ButtonPress1.mirror = true;
        setRotation(ButtonPress1, 0.1745329F, 0F, 0F);
        ButtonPress2 = new ModelRenderer(this, 0, 30);
        ButtonPress2.addBox(0F, 0F, 0F, 1, 1, 1);
        ButtonPress2.setRotationPoint(-5F, 22.6F, -5.2F);
        ButtonPress2.setTextureSize(64, 32);
        ButtonPress2.mirror = true;
        setRotation(ButtonPress2, 0.1745329F, 0F, 0F);
        SideBox = new ModelRenderer(this, 0, 24);
        SideBox.addBox(0F, 0F, 0F, 16, 1, 1);
        SideBox.setRotationPoint(-8F, 22.8F, 7F);
        SideBox.setTextureSize(64, 32);
        SideBox.mirror = true;
        setRotation(SideBox, 0F, 0F, 0F);
        SideBox1 = new ModelRenderer(this, 0, 24);
        SideBox1.addBox(0F, 0F, 0F, 16, 1, 1);
        SideBox1.setRotationPoint(-8F, 22.8F, -8F);
        SideBox1.setTextureSize(64, 32);
        SideBox1.mirror = true;
        setRotation(SideBox1, 0F, 0F, 0F);
        SideBox2 = new ModelRenderer(this, 0, 0);
        SideBox2.addBox(0F, 0F, 0F, 1, 1, 15);
        SideBox2.setRotationPoint(7F, 22.8F, -8F);
        SideBox2.setTextureSize(64, 32);
        SideBox2.mirror = true;
        setRotation(SideBox2, 0F, 0F, 0F);
        SideBox3 = new ModelRenderer(this, 0, 0);
        SideBox3.addBox(0F, 0F, 0F, 1, 1, 16);
        SideBox3.setRotationPoint(-8F, 22.8F, -8F);
        SideBox3.setTextureSize(64, 32);
        SideBox3.mirror = true;
        setRotation(SideBox3, 0F, 0F, 0F);
        Shape31 = new ModelRenderer(this, 43, 27);
        Shape31.addBox(0F, 0F, 0F, 9, 1, 1);
        Shape31.setRotationPoint(-4F, 22.6F, -2F);
        Shape31.setTextureSize(64, 32);
        Shape31.mirror = true;
        setRotation(Shape31, 0F, 0F, 0F);
        Shape32 = new ModelRenderer(this, 43, 27);
        Shape32.addBox(0F, 0F, 0F, 8, 1, 1);
        Shape32.setRotationPoint(4F, 22.6F, 6F);
        Shape32.setTextureSize(64, 32);
        Shape32.mirror = true;
        setRotation(Shape32, 0F, 1.570796F, 0F);
        Shape33 = new ModelRenderer(this, 43, 27);
        Shape33.addBox(0F, 0F, 0F, 9, 1, 1);
        Shape33.setRotationPoint(-5F, 22.6F, 5F);
        Shape33.setTextureSize(64, 32);
        Shape33.mirror = true;
        setRotation(Shape33, 0F, 0F, 0F);
        Shape34 = new ModelRenderer(this, 43, 27);
        Shape34.addBox(0F, 0F, 0F, 8, 1, 1);
        Shape34.setRotationPoint(-5F, 22.6F, 6F);
        Shape34.setTextureSize(64, 32);
        Shape34.mirror = true;
        setRotation(Shape34, 0F, 1.570796F, 0F);
        return null;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        BasePlate.render(f5);
        ButtonHold.render(f5);
        ButtonHold0.render(f5);
        ButtonHold1.render(f5);
        ButtonPress.render(f5);
        ButtonPress1.render(f5);
        ButtonPress2.render(f5);
        SideBox.render(f5);
        SideBox1.render(f5);
        SideBox2.render(f5);
        SideBox3.render(f5);
        Shape31.render(f5);
        Shape32.render(f5);
        Shape33.render(f5);
        Shape34.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

}
