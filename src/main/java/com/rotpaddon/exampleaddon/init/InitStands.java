package com.rotpaddon.exampleaddon.init;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.action.stand.StandEntityBlock;
import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.StandEntityLightAttack;
import com.github.standobyte.jojo.action.stand.StandEntityMeleeBarrage;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.init.power.stand.ModStandsInit;
import com.github.standobyte.jojo.power.impl.stand.StandInstance.StandPart;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.rotpaddon.exampleaddon.AddonMain;
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

    public static final RegistryObject<StandEntityHeavyAttack> EXAMPLE_STAND_FINISHER_PUNCH = ACTIONS.register("charmy_green_finisher",
            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder() // TODO finisher ability
                    .punchSound(InitSounds.EXAMPLE_STAND_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityHeavyAttack> CHARMY_GREEN_HEAVY_PUNCH = ACTIONS.register("charmy_green_heavy_punch",
            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder()
                    .shiftVariationOf(CHARMY_GREEN_PUNCH).shiftVariationOf(URYA_BARRAGE)
                    .setFinisherVariation(EXAMPLE_STAND_FINISHER_PUNCH)
                    .punchSound(InitSounds.EXAMPLE_STAND_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityAction> EXAMPLE_STAND_BLOCK = ACTIONS.register("charmy_green_block",
            () -> new StandEntityBlock());
    

    
    

    // ...then create the Stand type instance. Moves, stats, entity sizes, and a few other things are determined here.
    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<CharmyGreenEntity>> CHARMY_GREEN_STAND =
            new EntityStandRegistryObject<>("charmy_green",
                    STANDS, 
                    () -> new EntityStandType.Builder<StandStats>()
                    .color(0x00AFAF)
                    .storyPartName(ModStandsInit.PART_3_NAME)
                    .leftClickHotbar(
                            CHARMY_GREEN_PUNCH.get(),
                            URYA_BARRAGE.get()
                            )
                    .rightClickHotbar(
                            EXAMPLE_STAND_BLOCK.get()
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
                    () -> new StandEntityType<CharmyGreenEntity>(CharmyGreenEntity::new, 0.65F, 1.9F)
                    .summonSound(InitSounds.EXAMPLE_STAND_SUMMON_SOUND)
                    .unsummonSound(InitSounds.EXAMPLE_STAND_UNSUMMON_SOUND))
            .withDefaultStandAttributes();
    

    
    // ======================================== ??? ========================================
    
    
    
}
