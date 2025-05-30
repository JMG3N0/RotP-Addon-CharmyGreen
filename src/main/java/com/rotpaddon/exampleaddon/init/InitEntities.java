package com.rotpaddon.exampleaddon.init;

import com.rotpaddon.exampleaddon.AddonMain;

import com.rotpaddon.exampleaddon.entity.CGEmeraldEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
            ForgeRegistries.ENTITIES, AddonMain.MOD_ID);

    public static final RegistryObject<EntityType<CGEmeraldEntity>> CGEMERALD = ENTITIES.register("cgemerald",
            () -> EntityType.Builder.<CGEmeraldEntity>of(CGEmeraldEntity::new, EntityClassification.MISC)
                    .sized(1.0f,1.0f)
                    .build(AddonMain.MOD_ID + ":cgemerald"));


};
