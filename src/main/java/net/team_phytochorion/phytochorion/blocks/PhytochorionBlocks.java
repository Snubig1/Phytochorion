package net.team_phytochorion.phytochorion.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.team_phytochorion.phytochorion.Phytochorion;
import net.team_phytochorion.phytochorion.items.PhytochorionItems;
import net.team_phytochorion.phytochorion.world.feature.tree.AraucariaTreeGrower;
import net.team_phytochorion.phytochorion.world.feature.tree.PineTreeGrower;

import java.util.function.Supplier;

public class PhytochorionBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Phytochorion.MOD_ID);
    public static final RegistryObject<Block> ARAUCARIA_PLANKS = registerBlock("araucaria_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_CYAN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    //try to make climbable
    public static final RegistryObject<Block> ARAUCARIA_BRANCHES = registerBlock("araucaria_branches", AraucariaBranchesBlock::new);
    public static final RegistryObject<Block> ARAUCARIA_BUTTON = registerBlock("araucaria_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));
    public static final RegistryObject<Block> ARAUCARIA_DOOR = registerBlock("araucaria_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(ARAUCARIA_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.OAK));
    public static final RegistryObject<Block> ARAUCARIA_FENCE = registerBlock("araucaria_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(ARAUCARIA_PLANKS.get())));
    public static final RegistryObject<Block> ARAUCARIA_FENCE_GATE = registerBlock("araucaria_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(ARAUCARIA_PLANKS.get()), WoodType.OAK));
    public static final RegistryObject<Block> ARAUCARIA_LEAVES = registerBlock("araucaria_leaves", AraucariaLeavesBlock::new);
    public static final RegistryObject<Block> ARAUCARIA_LOG = registerBlock("araucaria_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ARAUCARIA_NEEDLES = registerBlock("araucaria_needles", AraucariaNeedlesBlock::new);
    public static final RegistryObject<Block> ARAUCARIA_PRESSURE_PLATE = registerBlock("araucaria_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(ARAUCARIA_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.OAK));
    public static final RegistryObject<Block> ARAUCARIA_SAPLING = registerBlock("araucaria_sapling", () -> new SaplingBlock(new AraucariaTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_ARAUCARIA_SAPLING = BLOCKS.register("potted_araucaria_sapling", () -> flowerPot(ARAUCARIA_SAPLING.get()));
    public static final RegistryObject<Block> ARAUCARIA_SLAB = registerBlock("araucaria_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(ARAUCARIA_PLANKS.get())));
    public static final RegistryObject<Block> ARAUCARIA_STAIRS = registerBlock("araucaria_stairs", () -> new StairBlock(() -> ARAUCARIA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(ARAUCARIA_PLANKS.get())));
    //remember to make these obtainable
    public static final RegistryObject<Block> STRIPPED_ARAUCARIA_LOG = registerBlock("stripped_araucaria_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_CYAN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> STRIPPED_ARAUCARIA_WOOD = registerBlock("stripped_araucaria_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_CYAN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ARAUCARIA_TRAPDOOR = registerBlock("araucaria_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(ARAUCARIA_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(PhytochorionBlocks::never).ignitedByLava(), BlockSetType.OAK));
    public static final RegistryObject<Block> ARAUCARIA_WOOD = registerBlock("araucaria_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));



    public static final RegistryObject<Block> GINKGO_PLANKS = registerBlock("ginkgo_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> GINKGO_BUTTON = registerBlock("ginkgo_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));
    public static final RegistryObject<Block> GINKGO_FENCE = registerBlock("ginkgo_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(GINKGO_PLANKS.get())));
    public static final RegistryObject<Block> GINKGO_FENCE_GATE = registerBlock("ginkgo_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(GINKGO_PLANKS.get()), WoodType.OAK));
    public static final RegistryObject<Block> GINKGO_LEAVES = registerBlock("ginkgo_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(PhytochorionBlocks::ocelotOrParrot).isSuffocating(PhytochorionBlocks::never).isViewBlocking(PhytochorionBlocks::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(PhytochorionBlocks::never)));
    public static final RegistryObject<Block> GINKGO_LOG = registerBlock("ginkgo_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> GINKGO_PRESSURE_PLATE = registerBlock("ginkgo_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(GINKGO_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.OAK));
    public static final RegistryObject<Block> GINKGO_SLAB = registerBlock("ginkgo_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(GINKGO_PLANKS.get())));
    public static final RegistryObject<Block> GINKGO_STAIRS = registerBlock("ginkgo_stairs", () -> new StairBlock(() -> GINKGO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GINKGO_PLANKS.get())));
    public static final RegistryObject<Block> GINKGO_WOOD = registerBlock("ginkgo_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));



    public static final RegistryObject<Block> GHOST_PIPE = registerBlock("ghost_pipe", () -> new FlowerBlock(MobEffects.WEAKNESS, 9, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> POTTED_GHOST_PIPE = BLOCKS.register("potted_ghost_pipe", () -> flowerPot(GHOST_PIPE.get()));
    public static final RegistryObject<Block> RED_GHOST_PIPE = registerBlock("red_ghost_pipe", () -> new FlowerBlock(MobEffects.WEAKNESS, 9, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> POTTED_RED_GHOST_PIPE = BLOCKS.register("potted_red_ghost_pipe", () -> flowerPot(RED_GHOST_PIPE.get()));



    public static final RegistryObject<Block> BUTTERFLY_WEED = registerBlock("butterfly_weed", () -> new FlowerBlock(MobEffects.WEAKNESS, 9, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> POTTED_BUTTERFLY_WEED = BLOCKS.register("potted_butterfly_weed", () -> flowerPot(BUTTERFLY_WEED.get()));
    public static final RegistryObject<Block> PINE_SAPLING = registerBlock("pine_sapling", () -> new SaplingBlock(new PineTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_PINE_SAPLING = BLOCKS.register("potted_pine_sapling", () -> flowerPot(PINE_SAPLING.get()));
    public static final RegistryObject<Block> PINE_LEAVES = registerBlock("pine_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(PhytochorionBlocks::ocelotOrParrot).isSuffocating(PhytochorionBlocks::never).isViewBlocking(PhytochorionBlocks::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(PhytochorionBlocks::never)));



    private  static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return PhytochorionItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static FlowerPotBlock flowerPot(Block pContent, FeatureFlag... pRequiredFeatures) {
         BlockBehaviour.Properties blockbehaviour$properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        if (pRequiredFeatures.length > 0) {
             blockbehaviour$properties = blockbehaviour$properties.requiredFeatures(pRequiredFeatures);
        }
        final BlockBehaviour.Properties properties = blockbehaviour$properties;
        return new FlowerPotBlock(pContent, properties);
    }

    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }
    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }
    private static Boolean ocelotOrParrot(BlockState p_50822_, BlockGetter p_50823_, BlockPos p_50824_, EntityType<?> p_50825_) {
        return (p_50825_ == EntityType.OCELOT || p_50825_ == EntityType.PARROT);
    }
}
