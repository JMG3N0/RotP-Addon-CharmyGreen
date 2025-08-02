package com.geno.beyondtw.init;

import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.geno.beyondtw.AddonMain;
import com.geno.beyondtw.entity.BeyondTheWorldEntity;

import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
            ForgeRegistries.ENTITIES, AddonMain.MOD_ID);



    public static final EntityStandRegistryObject.EntityStandSupplier<EntityStandType<StandStats>, StandEntityType<BeyondTheWorldEntity>>
            BEYOND_THE_WORLD = new EntityStandRegistryObject.EntityStandSupplier<>(InitStands.STAND_BEYOND_THE_WORLD);
};
