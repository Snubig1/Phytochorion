package net.team_phytochorion.phytochorion.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.team_phytochorion.phytochorion.items.PhytochorionItems;

public class PhytochorionChestBoatEntity extends ChestBoat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);

    public PhytochorionChestBoatEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public PhytochorionChestBoatEntity(Level pLevel, double pX, double pY, double pZ){
        this(PhytochorionEntities.PHYTOCHORION_CHEST_BOAT.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem(){
        return switch (getPhytochorionBoatVariant()){
            //case ARAUCARIA -> PhytochorionItems.ARAUCARIA_CHEST_BOAT.get();
            case ARAUCARIA -> PhytochorionItems.ARAUCARIA_HANGING_SIGN.get();
            //case GINKGO -> PhytochorionItems.GINKGO_CHEST_BOAT.get();
            case GINKGO -> PhytochorionItems.GINKGO_HANGING_SIGN.get();
        };
    }

    public void setVariant(PhytochorionBoatEntity.Type pVariant){
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    public PhytochorionBoatEntity.Type getPhytochorionBoatVariant(){
        return PhytochorionBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    protected void defineSynchedData(){
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, PhytochorionBoatEntity.Type.ARAUCARIA.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound){
        pCompound.putString("Type", this.getPhytochorionBoatVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound){
        if (pCompound.contains("Type", 8)) {
            this.setVariant(PhytochorionBoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }
}
