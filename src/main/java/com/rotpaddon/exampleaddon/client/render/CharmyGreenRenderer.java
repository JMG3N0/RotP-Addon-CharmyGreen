package com.rotpaddon.exampleaddon.client.render;

import com.github.standobyte.jojo.JojoMod;
import com.github.standobyte.jojo.client.render.entity.model.stand.StandEntityModel;
import com.github.standobyte.jojo.client.render.entity.model.stand.StandModelRegistry;
import com.github.standobyte.jojo.client.render.entity.renderer.stand.StandEntityRenderer;
import com.rotpaddon.exampleaddon.AddonMain;
import com.rotpaddon.exampleaddon.entity.CharmyGreenEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class CharmyGreenRenderer extends StandEntityRenderer<CharmyGreenEntity, StandEntityModel<CharmyGreenEntity>> {

    public CharmyGreenRenderer(EntityRendererManager rendererManager) {
        super(rendererManager,
                StandModelRegistry.registerModel(new ResourceLocation(AddonMain.MOD_ID, "charmy_green"), CharmyGreenModel::new),
                new ResourceLocation(AddonMain.MOD_ID, "textures/entity/stand/charmy_green.png"), 0);
    }
}
