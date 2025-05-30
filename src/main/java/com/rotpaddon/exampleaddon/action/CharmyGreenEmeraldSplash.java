package com.rotpaddon.exampleaddon.action;

import com.github.standobyte.jojo.action.stand.StandAction;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
//import com.github.standobyte.jojo.entity.damaging.projectile.HGEmeraldEntity;
import com.github.standobyte.jojo.entity.stand.*;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.general.GeneralUtil;
import com.rotpaddon.exampleaddon.entity.CGEmeraldEntity;
import com.rotpaddon.exampleaddon.entity.CharmyGreenEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class CharmyGreenEmeraldSplash extends StandEntityAction {
    public static final StandPose Emerald_Splash_Pose = new StandPose("emeraldSplash");
    public CharmyGreenEmeraldSplash(StandEntityAction.Builder builder) {
        super(builder);
    }

    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {
           // boolean shift = isShiftVariation();
            double fireRate = StandStatFormulas.projectileFireRateScaling(standEntity, userPower) / 4;
           // if (shift) fireRate *= 2.5;
            GeneralUtil.doFractionTimes(() -> {
                CGEmeraldEntity emerald = new CGEmeraldEntity(standEntity, world, userPower);
                standEntity.shootProjectile(emerald,  3.0F , 10.0F);
            }, fireRate);
//            userPower.addLearningProgressPoints(this, 5);

        }
    }

    @Override
    public void onMaxTraining(IStandPower power) {
        power.unlockAction((StandAction) getShiftVariationIfPresent());
    }

    @Override
    public int getStandWindupTicks(IStandPower standPower, StandEntity standEntity) {
        return noPhases(standPower, standEntity) || (standEntity.getCurrentTaskAction() != null
                && standEntity.getCurrentTaskAction().getShiftVariationIfPresent() == this.getShiftVariationIfPresent()) ?
                0 : StandStatFormulas.getHeavyAttackWindup(standEntity.getAttackSpeed(), 0);
    }

    @Override
    public int getStandRecoveryTicks(IStandPower standPower, StandEntity standEntity) {
        return noPhases(standPower, standEntity) ?
                0 : super.getStandRecoveryTicks(standPower, standEntity) * 2;
    }

    private boolean noPhases(IStandPower standPower, StandEntity standEntity) {
        return standPower.getResolveLevel() > 2
                || standPower.getUser() != null && standPower.getUser().hasEffect(ModStatusEffects.RESOLVE.get());
    }

    @Override
    protected boolean isChainable(IStandPower standPower, StandEntity standEntity) {
        return true;
    }

    @Override
    public boolean isFreeRecovery(IStandPower standPower, StandEntity standEntity) {
        return true;
    }

    @Override
    protected boolean isCancelable(IStandPower standPower, StandEntity standEntity, @Nullable StandEntityAction newAction, Phase phase) {
        return phase == Phase.RECOVERY || super.isCancelable(standPower, standEntity, newAction, phase);
    }

    @Override
    public StandRelativeOffset getOffsetFromUser(IStandPower standPower, StandEntity standEntity, StandEntityTask task) {
        return !standEntity.isArmsOnlyMode() && task.getPhase() != Phase.PERFORM ? null : super.getOffsetFromUser(standPower, standEntity, task);
    }
}
