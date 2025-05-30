package com.rotpaddon.exampleaddon.action;

import com.github.standobyte.jojo.action.stand.StandAction;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.damaging.projectile.ownerbound.SPStarFingerEntity;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.rotpaddon.exampleaddon.AddonMain;
import com.rotpaddon.exampleaddon.init.InitStands;
import net.minecraft.world.World;

public class CharmyGreenStarFinger extends StandEntityAction {
    public static final StandPose Star_Finger_Pose = new StandPose("starFinger");

    public CharmyGreenStarFinger(StandEntityAction.Builder builder) {
        super(builder);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {
            SPStarFingerEntity starFinger = new SPStarFingerEntity(world, standEntity);
            starFinger.setLifeSpan(getStandActionTicks(userPower, standEntity));
            starFinger.withStandSkin(standEntity.getStandSkin());
            standEntity.addProjectile(starFinger);
            userPower.addLearningProgressPoints(this, 0.02f);
        }
    }
    @Override
    public void onMaxTraining(IStandPower power) {
        if (power.getResolveLevel() >= 3) {
            power.unlockAction(InitStands.CHARMY_GREEN_EMERALD_STAR_FINGER.get());

        }
    }}

