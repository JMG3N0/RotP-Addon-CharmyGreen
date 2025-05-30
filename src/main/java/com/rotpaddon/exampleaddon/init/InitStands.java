package com.rotpaddon.exampleaddon.init;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.action.stand.StandEntityBlock;
import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.StandEntityLightAttack;
import com.github.standobyte.jojo.action.stand.StandEntityMeleeBarrage;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.init.power.stand.ModStandsInit;
import com.github.standobyte.jojo.power.impl.stand.StandInstance.StandPart;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.rotpaddon.exampleaddon.AddonMain;
import com.rotpaddon.exampleaddon.action.CharmyGreenEmeraldSplash;
import com.rotpaddon.exampleaddon.action.CharmyGreenEmeraldStarFinger;
import com.rotpaddon.exampleaddon.action.CharmyGreenFinisher;
import com.rotpaddon.exampleaddon.action.CharmyGreenStarFinger;
import com.rotpaddon.exampleaddon.entity.CharmyGreenEntity;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class InitStands {
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<Action<?>> ACTIONS = DeferredRegister.create(
            (Class<Action<?>>) ((Class<?>) Action.class), AddonMain.MOD_ID);
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<StandType<?>> STANDS = DeferredRegister.create(
            (Class<StandType<?>>) ((Class<?>) StandType.class), AddonMain.MOD_ID);
    
 // ======================================== Example Stand ========================================





    
    // Create all the abilities here...
    public static final RegistryObject<StandEntityAction> CHARMY_GREEN_PUNCH = ACTIONS.register("charmy_green_punch",
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
                    .punchSound(InitSounds.EXAMPLE_STAND_PUNCH_LIGHT)));
    
    public static final RegistryObject<StandEntityAction> URYA_BARRAGE = ACTIONS.register("urya_barrage",
            () -> new StandEntityMeleeBarrage(new StandEntityMeleeBarrage.Builder()
                    .barrageHitSound(InitSounds.EXAMPLE_STAND_PUNCH_BARRAGE)));

    public static final RegistryObject<StandEntityHeavyAttack> CHARMY_GREEN_FINISHER = ACTIONS.register("charmy_green_finisher",
            () -> new CharmyGreenFinisher(new StandEntityHeavyAttack.Builder()
                    .resolveLevelToUnlock(1)
                    .standPose(CharmyGreenFinisher.FINISHER_POSE)
                    .punchSound(ModSounds.STAR_PLATINUM_PUNCH_HEAVY)
                    .standSound(StandEntityAction.Phase.WINDUP, false, ModSounds.STAR_PLATINUM_ORA_LONG)
                    .partsRequired(StandPart.LEGS)));

    public static final RegistryObject<StandEntityHeavyAttack> CHARMY_GREEN_HEAVY_PUNCH = ACTIONS.register("charmy_green_heavy_punch",
            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder()
                    .shiftVariationOf(CHARMY_GREEN_PUNCH).shiftVariationOf(URYA_BARRAGE)
                    .setFinisherVariation(CHARMY_GREEN_FINISHER)
                    .punchSound(InitSounds.EXAMPLE_STAND_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityAction> CHARMY_GREEN_BLOCK = ACTIONS.register("charmy_green_block",
            () -> new StandEntityBlock());

    public static final RegistryObject<StandEntityAction> CHARMY_GREEN_EMERALD_SPLASH = ACTIONS.register("charmy_green_emerald_splash",
            () -> new CharmyGreenEmeraldSplash(new StandEntityAction.Builder().standPerformDuration(20).standRecoveryTicks(40).staminaCostTick(8).standRecoveryTicks(20)
                    .standPose(CharmyGreenEmeraldSplash.Emerald_Splash_Pose).resolveLevelToUnlock(1).isTrained().standOffsetFront().shout(ModSounds.KAKYOIN_EMERALD_SPLASH).standSound(ModSounds.HIEROPHANT_GREEN_EMERALD_SPLASH)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<CharmyGreenStarFinger> CHARMY_GREEN_STAR_FINGER = ACTIONS.register("charmy_green_star_finger",
            () -> new CharmyGreenStarFinger(new StandEntityAction.Builder().staminaCost(375).standPerformDuration(20).cooldown(20, 60)
                    .ignoresPerformerStun().noResolveUnlock().isTrained()
                    .standOffsetFront().standPose(CharmyGreenStarFinger.Star_Finger_Pose)
                    .shout(ModSounds.JOTARO_STAR_FINGER).standSound(StandEntityAction.Phase.PERFORM, ModSounds.STAR_PLATINUM_STAR_FINGER)
                    .partsRequired(StandPart.ARMS).shiftVariationOf(CHARMY_GREEN_EMERALD_SPLASH)));

    public static final RegistryObject<CharmyGreenEmeraldStarFinger> CHARMY_GREEN_EMERALD_STAR_FINGER = ACTIONS.register("charmy_green_emerald_star_finger",
            () -> new CharmyGreenEmeraldStarFinger(new StandEntityAction.Builder().staminaCostTick(25).standPerformDuration(15).cooldown(20,40)
                    .ignoresPerformerStun().noResolveUnlock()
                    .standOffsetFront().standPose(CharmyGreenStarFinger.Star_Finger_Pose)
                    .shout(ModSounds.JOTARO_STAR_FINGER).standSound(StandEntityAction.Phase.PERFORM, ModSounds.STAR_PLATINUM_STAR_FINGER)
                    .partsRequired(StandPart.ARMS)));


    
    

    // ...then create the Stand type instance. Moves, stats, entity sizes, and a few other things are determined here.
    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<CharmyGreenEntity>> CHARMY_GREEN_STAND =
            new EntityStandRegistryObject<>("charmy_green",
                    STANDS, 
                    () -> new EntityStandType.Builder<>()
                    .color(0x00AFAF)
                    .storyPartName(ModStandsInit.PART_3_NAME)
                    .leftClickHotbar(
                            CHARMY_GREEN_PUNCH.get(),
                            URYA_BARRAGE.get(),
                            CHARMY_GREEN_EMERALD_STAR_FINGER.get()
                            )
                    .rightClickHotbar(
                            CHARMY_GREEN_BLOCK.get(),
                            CHARMY_GREEN_EMERALD_SPLASH.get()
                            )
                    .defaultStats(StandStats.class, new StandStats.Builder()
                            .tier(6)
                            .power(9.0, 17.0)
                            .speed(12.0, 18.0)
                            .range(25, 50)
                            .durability(10.0,18.0)
                            .precision(10.0, 20.0)
                            .build())
                    .addSummonShout(InitSounds.EXAMPLE_STAND_SUMMON_VOICELINE)
                    .addOst(InitSounds.EXAMPLE_STAND_OST)
                    .build(),
                    
                    InitEntities.ENTITIES,
                    () -> new StandEntityType<>(CharmyGreenEntity::new, 0.7F, 1.9F)
                    .summonSound(InitSounds.EXAMPLE_STAND_SUMMON_SOUND)
                    .unsummonSound(InitSounds.EXAMPLE_STAND_UNSUMMON_SOUND))
            .withDefaultStandAttributes();
    

    
    // ======================================== ??? ========================================
    
    
    
}
