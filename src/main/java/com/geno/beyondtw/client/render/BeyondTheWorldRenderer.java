package com.geno.beyondtw.client.render;

import com.github.standobyte.jojo.JojoMod;
import com.github.standobyte.jojo.client.render.entity.model.stand.StandEntityModel;
import com.github.standobyte.jojo.client.render.entity.model.stand.StandModelRegistry;
import com.github.standobyte.jojo.client.render.entity.renderer.stand.StandEntityRenderer;
import com.geno.beyondtw.AddonMain;
import com.geno.beyondtw.entity.BeyondTheWorldEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class BeyondTheWorldRenderer extends StandEntityRenderer<BeyondTheWorldEntity, StandEntityModel<BeyondTheWorldEntity>> {
    
    public BeyondTheWorldRenderer(EntityRendererManager renderManager) {
        super(renderManager, 
                StandModelRegistry.registerModel(new ResourceLocation(AddonMain.MOD_ID, "beyond_the_world"), BeyondTheWorldModel::new),
                new ResourceLocation(AddonMain.MOD_ID, "textures/entity/stand/beyond_the_world.png"), 0);
    }
}
