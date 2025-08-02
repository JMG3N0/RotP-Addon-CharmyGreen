package com.geno.beyondtw.init;



import com.github.standobyte.jojo.action.stand.CrazyDiamondAngeloRock;
import com.github.standobyte.jojo.JojoMod;
import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.*;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.power.impl.stand.StandInstance.StandPart;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.github.standobyte.jojo.util.mod.StoryPart;
import com.geno.beyondtw.AddonMain;
import com.geno.beyondtw.entity.BeyondTheWorldEntity;


import com.silentevermore.rotp_whitesnake.action.WhitesnakeRemovingMemoryDisk;
import com.silentevermore.rotp_whitesnake.action.WhitesnakeRemovingStandDisc;
import com.silentevermore.rotp_whitesnake.action.WhitesnakeThrowDisc;
import com.zeml.rotp_zkq.action.stand.*;
import com.zeml.rotp_zkq.action.stand.punch.PunchBomb;
import com.zeml.rotp_zkq.init.InitSounds;
import com.silentevermore.rotp_whitesnake.init.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import static com.geno.beyondtw.init.InitEntities.ENTITIES;
import static com.github.standobyte.jojo.init.power.stand.ModStandsInit.CRAZY_DIAMOND_BARRAGE;
import static com.github.standobyte.jojo.init.power.stand.ModStandsInit.STAND_TYPES;
import static com.silentevermore.rotp_whitesnake.action.WhitesnakeThrowDisc.THROW_DISC;
import static com.silentevermore.rotp_whitesnake.init.InitStands.REMOVE_DISC;

public class InitStands {
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<Action<?>> ACTIONS = DeferredRegister.create(
            (Class<Action<?>>) ((Class<?>) Action.class), AddonMain.MOD_ID);
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<StandType<?>> STANDS = DeferredRegister.create(
            (Class<StandType<?>>) ((Class<?>) StandType.class), AddonMain.MOD_ID);
    
 // ======================================== Example Stand ========================================
    
    
//    // Create all the abilities here...
//    public static final RegistryObject<StandEntityAction> EXAMPLE_STAND_PUNCH = ACTIONS.register("example_stand_punch",
//            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
//                    .punchSound(InitSounds.EXAMPLE_STAND_PUNCH_LIGHT)));
//
//    public static final RegistryObject<StandEntityAction> EXAMPLE_STAND_BARRAGE = ACTIONS.register("example_stand_barrage",
//            () -> new StandEntityMeleeBarrage(new StandEntityMeleeBarrage.Builder()
//                    .barrageHitSound(InitSounds.EXAMPLE_STAND_PUNCH_BARRAGE)));
//
//    public static final RegistryObject<StandEntityHeavyAttack> EXAMPLE_STAND_FINISHER_PUNCH = ACTIONS.register("example_stand_finisher_punch",
//            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder() // TODO finisher ability
//                    .punchSound(InitSounds.EXAMPLE_STAND_PUNCH_HEAVY)
//                    .partsRequired(StandPart.ARMS)));
//
//    public static final RegistryObject<StandEntityHeavyAttack> EXAMPLE_STAND_HEAVY_PUNCH = ACTIONS.register("example_stand_heavy_punch",
//            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder()
//                    .shiftVariationOf(EXAMPLE_STAND_PUNCH).shiftVariationOf(EXAMPLE_STAND_BARRAGE)
//                    .setFinisherVariation(EXAMPLE_STAND_FINISHER_PUNCH)
//                    .punchSound(InitSounds.EXAMPLE_STAND_PUNCH_HEAVY)
//                    .partsRequired(StandPart.ARMS)));
//
//    public static final RegistryObject<StandEntityAction> EXAMPLE_STAND_BLOCK = ACTIONS.register("example_stand_block",
//            () -> new StandEntityBlock());
//
//    public static final RegistryObject<StandEntityAction> EXAMPLE_STAND_THROW_PICKAXE = ACTIONS.register("example_stand_throw_pickaxe",
//            () -> new ExampleStandThrowPickaxe(new StandEntityAction.Builder()
//                    .standPose(ExampleStandThrowPickaxe.PICKAXE_THROW_ANIM)
//                    .holdToFire(20, true)
//                    .standRecoveryTicks(20)
//                    .standSound(InitSounds.EXAMPLE_STAND_THROW_PICKAXE)
//                    .staminaCost(75)
//                    .partsRequired(StandPart.ARMS)));
//
//
//
//    // ...then create the Stand type instance. Moves, stats, entity sizes, and a few other things are determined here.
//    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<ExampleStandEntity>> STAND_EXAMPLE_STAND =
//            new EntityStandRegistryObject<>("example_stand",
//                    STANDS,
//                    () -> new EntityStandType.Builder<StandStats>()
//                    .color(0x00AFAF)
//                    .storyPartName(ModStandsInit.PART_3_NAME)
//                    .leftClickHotbar(
//                            EXAMPLE_STAND_PUNCH.get(),
//                            EXAMPLE_STAND_BARRAGE.get()
//                            )
//                    .rightClickHotbar(
//                            EXAMPLE_STAND_BLOCK.get(),
//                            EXAMPLE_STAND_THROW_PICKAXE.get()
//                            )
//                    .defaultStats(StandStats.class, new StandStats.Builder()
//                            .tier(6)
//                            .power(20)
//                            .speed(20)
//                            .range(50, 100)
//                            .durability(20)
//                            .precision(20)
//                            .build())
//                    .addSummonShout(InitSounds.EXAMPLE_STAND_SUMMON_VOICELINE)
//                    .addOst(InitSounds.EXAMPLE_STAND_OST)
//                    .build(),
//
//                    InitEntities.ENTITIES,
//                    () -> new StandEntityType<ExampleStandEntity>(ExampleStandEntity::new, 0.7F, 2.1F)
//                    .summonSound(InitSounds.EXAMPLE_STAND_SUMMON_SOUND)
//                    .unsummonSound(InitSounds.EXAMPLE_STAND_UNSUMMON_SOUND))
//            .withDefaultStandAttributes();


    
    // ======================================== ??? ========================================


    public static final RegistryObject<StandEntityLightAttack> THE_WORLD_PUNCH = ACTIONS.register("beyond_the_world_punch",
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
                    .punchSound(ModSounds.THE_WORLD_PUNCH_LIGHT)
                    .standSound(StandEntityAction.Phase.WINDUP, false, ModSounds.DIO_MUDA)));

    public static final RegistryObject<StandEntityMeleeBarrage> THE_WORLD_BARRAGE = ACTIONS.register("beyond_the_world_barrage",
            () -> new TheWorldBarrage(new StandEntityMeleeBarrage.Builder()
                    .barrageHitSound(ModSounds.THE_WORLD_PUNCH_BARRAGE)
                    .standSound(StandEntityAction.Phase.PERFORM, false, ModSounds.THE_WORLD_MUDA_MUDA_MUDA).shout(ModSounds.DIO_MUDA_MUDA), ModSounds.DIO_WRY));

    public static final RegistryObject<StandEntityHeavyAttack> THE_WORLD_KICK = ACTIONS.register("beyond_the_world_kick",
            () -> new TheWorldKick(new StandEntityHeavyAttack.Builder()
                    .resolveLevelToUnlock(1)
                    .standPose(TheWorldKick.KICK_POSE)
                    .punchSound(ModSounds.THE_WORLD_KICK_HEAVY)
                    .shout(ModSounds.DIO_DIE)
                    .partsRequired(StandPart.LEGS)));

    public static final RegistryObject<StandEntityHeavyAttack> THE_WORLD_HEAVY_PUNCH = ACTIONS.register("beyond_the_world_heavy_punch",
            () -> new TheWorldHeavyPunch(new StandEntityHeavyAttack.Builder()
                    .punchSound(ModSounds.THE_WORLD_PUNCH_HEAVY)
                    .shout(ModSounds.DIO_DIE)
                    .partsRequired(StandPart.ARMS)
                    .setFinisherVariation(THE_WORLD_KICK)
                    .shiftVariationOf(THE_WORLD_PUNCH).shiftVariationOf(THE_WORLD_BARRAGE)));

    public static final RegistryObject<StandEntityBlock> THE_WORLD_BLOCK = ACTIONS.register("beyond_the_world_block",
            () -> new StandEntityBlock());

    public static final RegistryObject<TimeStop> THE_WORLD_TIME_STOP = ACTIONS.register("beyond_the_world_time_stop",
            () -> new TheWorldTimeStop(new TimeStop.Builder().holdToFire(0, false).staminaCost(225).staminaCostTick(0).heldWalkSpeed(0)
                    .resolveLevelToUnlock(2).isTrained()
                    .ignoresPerformerStun()
                    .shout(ModSounds.DIO_THE_WORLD)
                    .partsRequired(StandPart.MAIN_BODY)
                    .timeStopMaxTicks(999999999, 180)
                    .timeStopLearningPerTick(0.1F)
                    .timeStopDecayPerDay(0F)
                    .timeStopCooldownPerTick(0F)
                    .voiceLineWithStandSummoned(ModSounds.DIO_TIME_STOP).timeStopSound(ModSounds.THE_WORLD_TIME_STOP)
                    .addTimeResumeVoiceLine(ModSounds.DIO_TIME_RESUMES, true).addTimeResumeVoiceLine(ModSounds.DIO_TIMES_UP, false)
                    .timeResumeSound(ModSounds.THE_WORLD_TIME_RESUME)
                    .shaderEffect(new ResourceLocation(JojoMod.MOD_ID, "shaders/post/time_stop_tw.json"), true)
                    .shaderEffect(new ResourceLocation(JojoMod.MOD_ID, "shaders/post/time_stop_tw_old.json"), false)));

    public static final RegistryObject<TimeStopInstant> THE_WORLD_TIME_STOP_BLINK = ACTIONS.register("beyond_the_world_ts_blink",
            () -> new TimeStopInstant(new StandAction.Builder()
                    .resolveLevelToUnlock(2).isTrained()
                    .ignoresPerformerStun()
                    .partsRequired(StandPart.MAIN_BODY),
                    THE_WORLD_TIME_STOP, ModSounds.THE_WORLD_TIME_STOP_BLINK,
                    true));

    public static final RegistryObject<TimeResume> THE_WORLD_TIME_RESUME = ACTIONS.register("beyond_the_world_time_resume",
            () -> new TimeResume(new StandAction.Builder().shiftVariationOf(THE_WORLD_TIME_STOP)));

    public static final RegistryObject<StandEntityAction> THE_WORLD_TS_PUNCH = ACTIONS.register("beyond_the_world_ts_punch",
            () -> new TheWorldTSHeavyAttack(new StandEntityAction.Builder().staminaCost(StandEntityHeavyAttack.DEFAULT_STAMINA_COST)
                    .resolveLevelToUnlock(3).standUserWalkSpeed(1.0F)
                    .standPose(TheWorldTSHeavyAttack.TS_PUNCH_POSE).standWindupDuration(5).cooldown(50)
                    .partsRequired(StandPart.MAIN_BODY, StandPart.ARMS), THE_WORLD_TIME_STOP_BLINK));

    public static final RegistryObject<CrazyDiamondBlockBullet> CRAZY_DIAMOND_BLOCK_BULLET = ACTIONS.register("beyond_the_world_block_bullet",
            () -> new CrazyDiamondBlockBullet(new StandEntityAction.Builder().standWindupDuration(15).staminaCost(40).staminaCostTick(2F)
                    .resolveLevelToUnlock(4)
                    .standPose(CrazyDiamondBlockBullet.BLOCK_BULLET_SHOT_POSE)
                    .standSound(StandEntityAction.Phase.WINDUP, ModSounds.CRAZY_DIAMOND_FIX_STARTED).standSound(StandEntityAction.Phase.PERFORM, ModSounds.CRAZY_DIAMOND_BULLET_SHOT)
                    .standOffsetFromUser(0.25, -0.5, 0)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<CrazyDiamondRepairItem> CRAZY_DIAMOND_REPAIR = ACTIONS.register("beyond_the_world_repair",
            () -> new CrazyDiamondRepairItem(new StandEntityAction.Builder().holdType().staminaCostTick(0.2F)
                    .resolveLevelToUnlock(0).isTrained()
                    .standOffsetFromUser(0.667, 0.2, 0).standPose(CrazyDiamondRepairItem.ITEM_FIX_POSE)
                    .standSound(StandEntityAction.Phase.PERFORM, ModSounds.CRAZY_DIAMOND_FIX_STARTED)
                    .standAutoSummonMode(StandEntityAction.AutoSummonMode.OFF_ARM)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<CrazyDiamondPreviousState> CRAZY_DIAMOND_PREVIOUS_STATE = ACTIONS.register("beyond_the_world_previous_state",
            () -> new CrazyDiamondPreviousState(new StandEntityAction.Builder().holdType().staminaCostTick(0.2F)
                    .noResolveUnlock()
                    .standOffsetFromUser(0.667, 0.2, 0).standPose(CrazyDiamondRepairItem.ITEM_FIX_POSE)
                    .standSound(StandEntityAction.Phase.PERFORM, ModSounds.CRAZY_DIAMOND_FIX_STARTED).barrageVisuals(THE_WORLD_BARRAGE)
                    .standAutoSummonMode(StandEntityAction.AutoSummonMode.OFF_ARM)
                    .partsRequired(StandPart.ARMS)
                    .shiftVariationOf(CRAZY_DIAMOND_REPAIR)));

    public static final RegistryObject<CrazyDiamondHeal> CRAZY_DIAMOND_HEAL = ACTIONS.register("beyond_the_world_heal",
            () -> new CrazyDiamondHeal(new StandEntityAction.Builder().holdType().staminaCostTick(1)
                    .resolveLevelToUnlock(1)
                    .standSound(StandEntityAction.Phase.PERFORM, ModSounds.CRAZY_DIAMOND_FIX_STARTED).barrageVisuals(THE_WORLD_BARRAGE)
                    .standAutoSummonMode(StandEntityAction.AutoSummonMode.MAIN_ARM)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityActionModifier> CRAZY_DIAMOND_ANGELO_ROCK = ACTIONS.register("beyond_the_world_angelo_rock",
            () -> new CrazyDiamondAngeloRock(new StandAction.Builder().staminaCost(50).resolveLevelToUnlock(2)));

    public static final RegistryObject<CrazyDiamondRestoreTerrain> CRAZY_DIAMOND_RESTORE_TERRAIN = ACTIONS.register("beyond_the_world_restore_terrain",
            () -> new CrazyDiamondRestoreTerrain(new StandEntityAction.Builder().holdType().staminaCostTick(2) // cost per block rather than per tick
                    .attackRecoveryFollowup(CRAZY_DIAMOND_ANGELO_ROCK, THE_WORLD_KICK)
                    .resolveLevelToUnlock(2)
                    .shout(ModSounds.JOSUKE_FIX).standSound(StandEntityAction.Phase.PERFORM, ModSounds.CRAZY_DIAMOND_FIX_STARTED)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<GoldExperienceLifeDetector> GOLD_EXPERIENCE_LIFE_DETECTOR = ACTIONS.register("beyond_the_world_life_detector",
            () -> new GoldExperienceLifeDetector(new StandEntityAction.Builder()
                    .holdType().staminaCostTick(0.5F)
                    .resolveLevelToUnlock(2)
                    .standAutoSummonMode(StandEntityAction.AutoSummonMode.OFF_ARM)
                    .partsRequired(StandPart.MAIN_BODY)));

    public static final RegistryObject<GoldExperienceHeal> GOLD_EXPERIENCE_HEAL = ACTIONS.register("beyond_the_world_heal_organ",
            () -> new GoldExperienceHeal(new StandEntityAction.Builder()
                    .resolveLevelToUnlock(3)
                    .staminaCost(20)
                    .standPerformDuration(10)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<GoldExperienceHealingItem> GOLD_EXPERIENCE_HEALING_ITEM = ACTIONS.register("beyond_the_world_healing_item",
            () -> new GoldExperienceHealingItem(new StandEntityAction.Builder()
                    .resolveLevelToUnlock(3)
                    .staminaCost(40)
                    .standPerformDuration(10)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<GoldExperienceHealOther> GOLD_EXPERIENCE_HEAL_OTHER = ACTIONS.register("beyond_the_world_heal_other",
            () -> new GoldExperienceHealOther(new StandEntityAction.Builder()
                    .resolveLevelToUnlock(3)
                    .staminaCost(20)
                    .standPerformDuration(10)
                    .partsRequired(StandPart.ARMS)
                    .shiftVariationOf(GOLD_EXPERIENCE_HEAL).addExtraUnlockable(GOLD_EXPERIENCE_HEALING_ITEM)));

    public static final RegistryObject<StandEntityAction> KQ_ITEM_BOMB = ACTIONS.register("beyond_the_world_itembomb",
            ()->new ItemFBomb(new StandEntityLightAttack.Builder().punchSound(InitSounds.VOID).swingSound(InitSounds.VOID)
                    .standPose(EntityExplode.DETONATE).standOffsetFromUser(0,0,0)
                    .needsFreeMainHand().resolveLevelToUnlock(1)
                    .partsRequired(StandPart.ARMS).cooldown(5)));

    public static final RegistryObject<StandEntityAction> KQ_ENTITY_BOMB = ACTIONS.register("beyond_the_world_entitybomb",
            ()->new PunchBomb(new StandEntityLightAttack.Builder()
                    .standRecoveryTicks(40).standOffsetFront()
                    .resolveLevelToUnlock(2).staminaCost(125).cooldown(60).partsRequired(StandPart.ARMS)
                    .shout(InitSounds.USER_KQ).standPose(PunchBomb.BOMB_PUNCH)
            ));

    public static final RegistryObject<StandEntityAction> KQ_ITEM_BOMB_EX = ACTIONS.register("beyond_the_world_item_explo",
            ()->new ItemFBombExplode(new StandEntityLightAttack.Builder().standWindupDuration(20).standRecoveryTicks(10)
                    .shiftVariationOf(KQ_ITEM_BOMB).staminaCost(20).standSound(InitSounds.KQ_BOMB).standPose(StandPose.RANGED_ATTACK)
            ));


    public static final RegistryObject<StandEntityAction> KQ_ENTITY_EX = ACTIONS.register("beyond_the_world_entity_explo",
            ()->new EntityExplode(new StandEntityLightAttack.Builder().holdToFire(20,false)
                    .staminaCost(250F).standPose(EntityExplode.DETONATE).resolveLevelToUnlock(1)
                    .standSound(StandEntityAction.Phase.RECOVERY,InitSounds.KQ_BOMB))
    );

    public static final RegistryObject<StandEntityAction> KQ_ENTITY_QUIT = ACTIONS.register("beyond_the_world_entity_quit",
            ()->new EntityQuitBomb(new StandEntityAction.Builder().standWindupDuration(5)
                    .staminaCost(50F).standPose(StandPose.RANGED_ATTACK).shiftVariationOf(KQ_ENTITY_EX).shiftVariationOf(KQ_ENTITY_BOMB)
                    .standSound(InitSounds.KQ_UNBOMB)));

    public static final RegistryObject<StandEntityAction> KQ_BLOCK_BOMB = ACTIONS.register("beyond_the_world_block_bomb",
            ()->new BlockBombAction(new StandEntityAction.Builder().standWindupDuration(5)
                    .cooldown(60).standSound(InitSounds.USER_KQ)
                    .staminaCost(75F).standPose(PunchBomb.BOMB_PUNCH)
            ));


    public static final RegistryObject<StandEntityAction> KQ_BLOCK_EXPLODE = ACTIONS.register("beyond_the_world_block_explode",
            ()->new ExplodeBlockAction(new StandEntityLightAttack.Builder().standWindupDuration(10)
                    .cooldown(60)
                    .staminaCost(125F).standPose(StandPose.RANGED_ATTACK).standSound(InitSounds.KQ_BOMB)
            ));

    public static final RegistryObject<StandEntityAction> KQ_BLOCK_QUIT = ACTIONS.register("beyond_the_world_block_quit",
            ()->new BlockQuitBomb(new StandEntityLightAttack.Builder().standWindupDuration(5).shiftVariationOf(KQ_BLOCK_BOMB)
                    .shiftVariationOf(KQ_BLOCK_EXPLODE)
                    .staminaCost(5F).standPose(StandPose.RANGED_ATTACK)
                    .standSound(InitSounds.KQ_UNBOMB)));

    public static final RegistryObject<StandEntityAction> KQ_SECOND_BOMB = ACTIONS.register("beyond_the_world_sheer_heart",
            ()->new SheerHeartAttack(new StandEntityAction.Builder().staminaCost(200)
                    .resolveLevelToUnlock(3).cooldown(200).shout(InitSounds.KQ_SH_SUMMON)
            ));

    public static final RegistryObject<StandEntityAction> KQ_SB_BACK = ACTIONS.register("beyond_the_world_shear_heart_back",
            ()->new SHABack(new StandEntityAction.Builder().shiftVariationOf(KQ_SECOND_BOMB)
                    .standSound(InitSounds.KQ_UNSUMMON)
            ));

    public static final RegistryObject<StandAction> KQ_SNOW_BOMB = ACTIONS.register("beyond_the_world_snow_bomb",
            ()->new SnowBomb(new StandAction.Builder().staminaCost(100).resolveLevelToUnlock(4).cooldown(100).partsRequired(StandPart.ARMS)
            ));

    public static final RegistryObject<StandAction> KQ_BUBBLE_BOMB = ACTIONS.register("beyond_the_world_bubble_bomb",
            ()->new HBubbleBomb(new StandAction.Builder().staminaCost(100).cooldown(100).partsRequired(StandPart.ARMS)
            ));

    public static final RegistryObject<StandEntityAction> KQ_SNOW_EXPLODE = ACTIONS.register("beyond_the_world_snow_explode",
            ()-> new ExplodeSnow(new StandEntityLightAttack.Builder().staminaCost(100).shiftVariationOf(KQ_SNOW_BOMB)
                    .standSound(InitSounds.KQ_BOMB).standPose(StandPose.RANGED_ATTACK).shiftVariationOf(KQ_BUBBLE_BOMB)
                    .standPerformDuration(20)));

    public static final RegistryObject<WhitesnakeThrowDisc> WHITESNAKE_THROW_DISC = ACTIONS.register("beyond_the_world_throw_disc",
            () -> new WhitesnakeThrowDisc(new StandEntityAction.Builder()
                    .standSound(ModSounds.STAND_PUNCH_SWING)
                    .standPose(THROW_DISC)
                    .standPerformDuration(15)
                    .staminaCost(3)
                    .resolveLevelToUnlock(2)
                    .standOffsetFront()
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<WhitesnakeRemovingMemoryDisk> REMOVING_THE_MEMORY_DISK = ACTIONS.register("beyond_the_world_removing_the_memory_disk",
            () -> new WhitesnakeRemovingMemoryDisk(new WhitesnakeRemovingMemoryDisk.Builder()
                    .standPose(REMOVE_DISC)
                    .standSound(StandEntityAction.Phase.PERFORM, com.silentevermore.rotp_whitesnake.init.InitSounds.WHITESNAKE_REMOVE_DISC)
                    .standSound(StandEntityAction.Phase.WINDUP, com.silentevermore.rotp_whitesnake.init.InitSounds.PUCCI_REMOVE_DISK)
                    .staminaCost(200)
                    .resolveLevelToUnlock(0)
                    .holdToFire(30, false)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityAction> WHITESNAKE_REMOVE_STAND_DISC = ACTIONS.register("beyond_the_world_remove_stand_disc",
            () -> new WhitesnakeRemovingStandDisc(new WhitesnakeRemovingStandDisc.Builder()
                    .holdType()
                    .shout(com.silentevermore.rotp_whitesnake.init.InitSounds.PUCCI_REMOVE_DISK)
                    .standSound(StandEntityAction.Phase.PERFORM,com.silentevermore.rotp_whitesnake.init.InitSounds.WHITESNAKE_REMOVE_DISC)
                    .resolveLevelToUnlock(2)
                    .standPose(REMOVE_DISC)
                    .holdToFire(30, false)
                    .standOffsetFromUser(0.667, 0.2, 0)
                    .partsRequired(StandPart.ARMS)
            ));

    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<BeyondTheWorldEntity>> STAND_BEYOND_THE_WORLD =
            new EntityStandRegistryObject<>("beyond_the_world", STANDS,
                    () -> new EntityStandType.Builder<StandStats>()
                            .color(0xFFD800)
                            .storyPartName(StoryPart.STARDUST_CRUSADERS.getName())
                            .leftClickHotbar(
                                    THE_WORLD_PUNCH.get(),
                                    THE_WORLD_BARRAGE.get(),
                                    CRAZY_DIAMOND_BLOCK_BULLET.get(),
                                    THE_WORLD_TS_PUNCH.get(),
                                    KQ_SNOW_BOMB.get(),
                                    WHITESNAKE_THROW_DISC.get()
                            )
                            .rightClickHotbar(
                                    THE_WORLD_BLOCK.get(),
                                    CRAZY_DIAMOND_REPAIR.get(),
                                    CRAZY_DIAMOND_HEAL.get(),
                                    GOLD_EXPERIENCE_HEAL.get(),
                                    CRAZY_DIAMOND_RESTORE_TERRAIN.get(),
                                    GOLD_EXPERIENCE_LIFE_DETECTOR.get(),
                                    KQ_ENTITY_BOMB.get(),
                                    KQ_ITEM_BOMB.get(),
                                    KQ_BLOCK_BOMB.get(),
                                    KQ_SECOND_BOMB.get(),
                                    REMOVING_THE_MEMORY_DISK.get(),
                                    WHITESNAKE_REMOVE_STAND_DISC.get(),
                                    THE_WORLD_TIME_STOP.get()
                            )
                            .defaultStats(StandStats.class, new StandStats.Builder()
                                    .power(16.0, 19.0)
                                    .speed(16.0, 18.5)
                                    .range(5.0, 10.0)
                                    .durability(16.0, 20.0)
                                    .precision(12.0)
                                    .randomWeight(1)
                            )
                            .addSummonShout(ModSounds.DIO_THE_WORLD)
                            .addOst(ModSounds.THE_WORLD_OST)
                            .addAttackerResolveMultTier(1)
//                    .addItemOnResolveLevel(4, new ItemStack(ModItems.ROAD_ROLLER.get()))
                            .build(),

                    ENTITIES,
                    () -> new StandEntityType<BeyondTheWorldEntity>(BeyondTheWorldEntity::new, 0.7F, 2.1F)
                            .summonSound(ModSounds.THE_WORLD_SUMMON)
                            .unsummonSound(ModSounds.THE_WORLD_UNSUMMON))
                    .withDefaultStandAttributes();
}
