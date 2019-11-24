package com.jmteam.rubymod.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable {

    private float damage;

    public EntityBullet(World worldIn) {
        super(worldIn);
    }

    public EntityBullet(World worldIn, EntityLivingBase throwerIn, float damage) {
        super(worldIn, throwerIn);
        this.damage = damage;
    }

    @Override
    protected void onImpact(RayTraceResult result) {

        if (result == null || isDead || world.isRemote)
            return;

        if (result.typeOfHit == RayTraceResult.Type.ENTITY) {
            Entity entity = result.entityHit;
            if (entity == this.thrower) return;

            if (!(entity instanceof EntityHanging)) {

                if (entity instanceof EntityLiving) {
                    if (entity.getIsInvulnerable()) return;

                    if (entity instanceof EntityEnderman || entity instanceof EntityDragon) {
                        entity.setDead();
                    }
                }

                if (entity instanceof EntityPlayer) {
                    EntityPlayer p = (EntityPlayer) entity;
                    if (p.isCreative()) return;
                }


                result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), damage);
                this.setDead();
            }


        } else if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
            this.setDead();
        }

        if (!this.world.isRemote)
            this.setDead();
    }

    @Override
    protected float getGravityVelocity() {
        return 0.00000F;
    }


    @Override
    public void onEntityUpdate() {
        if (world.isRemote) return;

        double movingspeed = new Vec3d(posX, posY, posZ).distanceTo(new Vec3d(prevPosX, prevPosY, prevPosZ));
        if (this.ticksExisted >= 400 || movingspeed < 0.01) {
            this.setDead();
        }
    }
}
