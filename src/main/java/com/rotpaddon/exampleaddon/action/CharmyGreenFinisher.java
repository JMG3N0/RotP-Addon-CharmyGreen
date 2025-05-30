package com.rotpaddon.exampleaddon.action;

import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.punch.StandEntityPunch;
import com.github.standobyte.jojo.entity.damaging.projectile.ownerbound.HGStringEntity;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.mc.damage.StandEntityDamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class CharmyGreenFinisher extends StandEntityHeavyAttack {
    public static final StandPose FINISHER_POSE = new StandPose("finisher");

    public CharmyGreenFinisher(StandEntityHeavyAttack.Builder builder) {
        super(builder);
    }

    @Override
    public StandEntityPunch punchEntity(StandEntity stand, Entity target, StandEntityDamageSource dmgSource, World world, IStandPower userPower) {

            StandEntityPunch kick = super.punchEntity(stand, target, dmgSource);
            double strength = stand.getAttackDamage();
            return kick
                    .addKnockback(0.5F + (float) strength / 16 * stand.getLastHeavyFinisherValue())
                    .knockbackXRot(-60F)
                    .disableBlocking(1.0F);
        addProjectile(world, userPower, stand, 0.0f, 0.0f, false);
    }

    private void addProjectile(World world, IStandPower userPower, StandEntity standEntity, float yRotDelta, float xRotDelta, boolean shift) {
        HGStringEntity string = new HGStringEntity(world, standEntity, yRotDelta, xRotDelta, shift);
        if (!shift) {
            string.addKnockback(standEntity.guardCounter());
        }
        string.setLifeSpan(getStandActionTicks(userPower, standEntity));
        string.withStandSkin(standEntity.getStandSkin());
        standEntity.addProjectile(string);
    }

    @Override
    protected boolean standKeepsTarget(ActionTarget target) {
        return true;
    }

    @Override
    public int getStandActionTicks(IStandPower standPower, StandEntity standEntity) {
        double speed = standEntity.getAttackSpeed() / 8;
        return MathHelper.ceil(super.getStandActionTicks(standPower, standEntity) / Math.max(speed, 0.125));
    }
}
