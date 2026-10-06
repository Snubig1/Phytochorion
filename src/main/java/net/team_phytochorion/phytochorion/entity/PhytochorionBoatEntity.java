package net.team_phytochorion.phytochorion.entity;


import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.team_phytochorion.phytochorion.block.PhytochorionBlocks;
import net.team_phytochorion.phytochorion.items.PhytochorionItems;

import java.util.function.IntFunction;

public class PhytochorionBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);
    public PhytochorionBoatEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    public PhytochorionBoatEntity(Level pLevel, double pX, double pY, double pZ){
        this(PhytochorionEntities.PHYTOCHORION_BOAT.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem(){
        return switch (getPhytochorionBoatVariant()){
            //case ARAUCARIA -> PhytochorionItems.ARAUCARIA_BOAT.get();
            case ARAUCARIA -> PhytochorionItems.ARAUCARIA_SIGN.get();
            //case GINKGO -> PhytochorionItems.GINKGO_BOAT.get();
            case GINKGO -> PhytochorionItems.GINKGO_SIGN.get();
        };
    }


    public void setVariant(Type pVariant){
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    public Type getPhytochorionBoatVariant(){
        return Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    protected void defineSynchedData(){
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, Type.ARAUCARIA.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound){
        pCompound.putString("Type", this.getPhytochorionBoatVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound){
        if (pCompound.contains("Type", 8)) {
            this.setVariant(Type.byName(pCompound.getString("Type")));
        }
    }


    public static enum Type implements StringRepresentable {
        ARAUCARIA(PhytochorionBlocks.ARAUCARIA_PLANKS.get(), "araucaria"),
        GINKGO(PhytochorionBlocks.GINKGO_PLANKS.get(), "ginkgo");

        private final String name;
        private final Block planks;
        public static final StringRepresentable.EnumCodec<PhytochorionBoatEntity.Type> CODEC = StringRepresentable.fromEnum(PhytochorionBoatEntity.Type::values);
        private static final IntFunction<PhytochorionBoatEntity.Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

        private Type(Block pPlanks, String pName) {
            this.name = pName;
            this.planks = pPlanks;
        }

        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        /**
         * Get a boat type by its enum ordinal
         */
        public static PhytochorionBoatEntity.Type byId(int pId) {
            return BY_ID.apply(pId);
        }

        public static PhytochorionBoatEntity.Type byName(String pName) {
            return CODEC.byName(pName, ARAUCARIA);
        }
    }
}

