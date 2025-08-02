package com.geno.beyondtw.entity;

import com.github.standobyte.jojo.capability.entity.PlayerUtilCapProvider;
import com.github.standobyte.jojo.capability.world.TimeStopHandler;
import com.github.standobyte.jojo.capability.world.WorldUtilCapProvider;
import com.github.standobyte.jojo.entity.itemprojectile.KnifeEntity;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.item.KnifeItem;
import com.github.standobyte.jojo.util.mod.JojoModUtil;

import com.zeml.rotp_zkq.entity.stand.stands.KQStandEntity;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BeyondTheWorldEntity extends StandEntity {

    private static final DataParameter<Boolean> IS_BLOCK_BOMB = EntityDataManager.defineId(KQStandEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Float> X = EntityDataManager.defineId(KQStandEntity.class,DataSerializers.FLOAT);
    private static final DataParameter<Float> Y = EntityDataManager.defineId(KQStandEntity.class,DataSerializers.FLOAT);
    private static final DataParameter<Float> Z = EntityDataManager.defineId(KQStandEntity.class, DataSerializers.FLOAT);
    public BeyondTheWorldEntity(StandEntityType<BeyondTheWorldEntity> type, World world) {
        super(type, world);
    }

    @Override
    public void onKnivesThrow(World world, PlayerEntity playerUser, ItemStack knivesStack, int knivesThrown) {
        if (world.isClientSide()) {
            return;
        }

        if (knivesThrown == 1) {
            playerUser.getCapability(PlayerUtilCapProvider.CAPABILITY).ifPresent(cap -> {
                if (cap.knivesThrewTicks > 0) {
                    JojoModUtil.sayVoiceLine(playerUser, ModSounds.DIO_ONE_MORE.get());
                    cap.knivesThrewTicks = 0;
                }
            });
        }

        if (knivesThrown > 1 && TimeStopHandler.isTimeStopped(playerUser.level, playerUser.blockPosition())) {
            playerUser.getCapability(PlayerUtilCapProvider.CAPABILITY).ifPresent(cap -> {
                cap.knivesThrewTicks = 80;
            });
        }



        if (!playerUser.isShiftKeyDown() && knivesStack.getCount() > 0) {
            int standKnives = Math.min(knivesStack.getCount(), KnifeItem.MAX_KNIVES_THROW);

            for (int i = 0; i < standKnives; i++) {
                KnifeEntity knifeEntity = new KnifeEntity(world, playerUser);
                knifeEntity.setPos(this.getX(), this.getEyeY() - 0.1, this.getZ());
                knifeEntity.setTimeStopFlightTicks(5);
                knifeEntity.shootFromRotation(playerUser, 1.5F, i == 0 ? 1.0F : 16.0F);
//                if (random.nextFloat() < 0.025F) {
//                    knifeEntity.setKnifeType(KnifeEntity.TexVariant.FISH);
//                }
                world.addFreshEntity(knifeEntity);
            }

            world.playSound(null, this.getX(), this.getY(), this.getZ(),
                    standKnives == 1 ? ModSounds.KNIFE_THROW.get() : ModSounds.KNIVES_THROW.get(),
                    SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

            if (!playerUser.abilities.instabuild) {
                knivesStack.shrink(standKnives);
            }



            world.getCapability(WorldUtilCapProvider.CAPABILITY).map(cap ->
                    cap.getTimeStopHandler().userStoppedTime(playerUser)).get().ifPresent(timeStop -> {
                if (timeStop.getStartingTicks() == 100 && timeStop.getTicksLeft() > 50 && timeStop.getTicksLeft() <= 80) {
                    JojoModUtil.sayVoiceLine(playerUser, ModSounds.DIO_5_SECONDS.get());
                }
            });
        }
    }
    @Override
    public void tick(){
        if(!level.isClientSide){
            if(this.distanceToSqr(entityData.get(X),entityData.get(Y),entityData.get(Z))>2500){
                entityData.set(IS_BLOCK_BOMB,false);
            }
            if(level.getBlockState(getBlockPos()).getBlock()== Blocks.AIR || level.getBlockState(getBlockPos()).getBlock()== Blocks.WATER
                    || level.getBlockState(getBlockPos()).getBlock()== Blocks.LAVA){
                entityData.set(IS_BLOCK_BOMB,false);
            }
        }
        super.tick();
    }


    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(IS_BLOCK_BOMB, false);
        entityData.define(X,0F);
        entityData.define(Y,0F);
        entityData.define(Z,0F);
    }

    public void setIsBlockBomb(boolean bomb){
        entityData.set(IS_BLOCK_BOMB,bomb);
    }

    public void setBlockPos(BlockPos blockPos){
        entityData.set(X, (float) blockPos.getX());
        entityData.set(Y,(float) blockPos.getY());
        entityData.set(Z,(float) blockPos.getZ());
    }

    public boolean getIsBlockBomb(){
        return entityData.get(IS_BLOCK_BOMB);
    }

    public BlockPos getBlockPos(){
        return new BlockPos(entityData.get(X),entityData.get(Y),entityData.get(Z));
    }
}
