package com.rotpaddon.exampleaddon.client.render;

import com.github.standobyte.jojo.client.render.entity.model.stand.HumanoidStandModel;
import com.rotpaddon.exampleaddon.entity.CharmyGreenEntity;

public class CharmyGreenModel extends HumanoidStandModel<CharmyGreenEntity> {
    public CharmyGreenModel() {super();}

    @Override
    public void prepareMobModel(CharmyGreenEntity entity, float walkAnimPos, float walkAnimSpeed, float partialTick) {
        super.prepareMobModel(entity, walkAnimPos, walkAnimSpeed, partialTick);

    }
}
