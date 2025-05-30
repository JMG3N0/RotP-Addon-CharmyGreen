package com.rotpaddon.exampleaddon.action;

import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.damaging.projectile.ownerbound.SPStarFingerEntity;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.general.MathUtil;
import com.rotpaddon.exampleaddon.entity.CGEmeraldEntity;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.world.World;

import static com.ibm.icu.text.PluralRules.Operand.n;

public class CharmyGreenEmeraldStarFinger extends StandEntityAction {
    public static final StandPose Emerald_Star_Finger_Pose = new StandPose("emeraldStarFinger");

    public CharmyGreenEmeraldStarFinger(StandEntityAction.Builder builder) {
        super(builder);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {
            SPStarFingerEntity starFinger = new SPStarFingerEntity(world, standEntity);
            starFinger.setLifeSpan(getStandActionTicks(userPower, standEntity));
            starFinger.withStandSkin(standEntity.getStandSkin());
            standEntity.addProjectile(starFinger);

            ActionTarget target = task.getTarget();
            int resolveLevel = userPower.getResolveLevel();

            if (target.getType() == ActionTarget.TargetType.EMPTY) {
                target = standEntity.aimWithThisOrUser(64, target, false);
            }
            for (int i = 0; i < resolveLevel; i++) {
                CGEmeraldEntity emerald = new CGEmeraldEntity(standEntity, world, userPower);
                emerald.setScale((float) resolveLevel);
                Vector2f rotOffsets = i == 0 ? Vector2f.ZERO
                        : MathUtil.xRotYRotOffsets(((double) i / (double) resolveLevel) * Math.PI, 1.5);
                if (target.getType() != ActionTarget.TargetType.EMPTY) {
                    emerald.setSpecial(target.getTargetPos(true));
                }
                emerald.shootFromRotation(standEntity, standEntity.xRot + rotOffsets.x, standEntity.yRot + rotOffsets.y,
                        0, 1.0F, 0.0F);

                emerald.setScale((float) standEntity.getStandEfficiency());

                world.addFreshEntity(emerald);
            }
            standEntity.playSound(ModSounds.STAR_PLATINUM_STAR_FINGER.get(), 1.0F, 1.0F);
        }
    }
    }

