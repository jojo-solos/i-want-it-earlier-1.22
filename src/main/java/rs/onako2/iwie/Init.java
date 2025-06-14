package rs.onako2.iwie;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.ShortPlantBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs.onako2.iwie.block.ClosedEyeBlossomBlock;
import rs.onako2.iwie.block.CreakingHeartBlock;
import rs.onako2.iwie.block.OpenEyeBlossomBlock;
import rs.onako2.iwie.block.PaleHangingMossBlock;
import rs.onako2.iwie.block.PaleHangingMossPlantBlock;
import rs.onako2.iwie.block.PaleMossBlock;
import rs.onako2.iwie.compat.WilderWildCompat;
import rs.onako2.iwie.decorator.CreakingHeartDecorator;
import rs.onako2.iwie.entity.CreakingBlockEntityTypes;
import rs.onako2.iwie.entity.CreakingEntity;
import rs.onako2.iwie.feature.pale_moss_ceiling_feature.PaleMossPatchCeilingConfig;
import rs.onako2.iwie.feature.pale_moss_ceiling_feature.PaleMossPatchCeilingFeature;
import rs.onako2.iwie.feature.pale_moss_feature.PaleMossPatchConfig;
import rs.onako2.iwie.feature.pale_moss_feature.PaleMossPatchFeature;
import rs.onako2.iwie.feature.pale_moss_patch_bonemeal.PaleMossPatchBonemealConfig;
import rs.onako2.iwie.feature.pale_moss_patch_bonemeal.PaleMossPatchBonemealFeature;
import rs.onako2.iwie.feature.pale_oak_tree.PaleOakSapling;
import rs.onako2.iwie.feature.pale_oak_tree.PaleOakTreeFeature;
import rs.onako2.iwie.feature.pale_oak_tree.PaleOakTreeFeatureConfig;
import rs.onako2.iwie.feature.pale_short_grass_feature.PaleShortGrassFeature;
import rs.onako2.iwie.feature.pale_short_grass_feature.PaleShortGrassPatchConfig;
import rs.onako2.iwie.sound.ModSounds;

public class Init implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.

    public static final EntityType<CreakingEntity> CREAKING = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of("iwie", "creaking"),
            EntityType.Builder.create(CreakingEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1.0f, 2.9f)
                    .build(null)
    );

    public static final Logger LOGGER = LoggerFactory.getLogger("iwie");
    public static final String MOD_ID = "iwie";

    //public static final Block TEST = new Block(AbstractBlock.Settings.create().strength(4.0f));

    public static final Block PALE_OAK_LOG = Util.createLogBlock(MapColor.PALE_YELLOW, MapColor.GRAY);

    public static final Block STRIPPED_PALE_OAK_LOG = Util.createLogBlock(MapColor.PALE_YELLOW, MapColor.GRAY);

    public static final Block PALE_OAK_WOOD = new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable());

    public static final Block STRIPPED_PALE_OAK_WOOD = new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable());

    public static final Block PALE_SHORT_GRASS = new ShortPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ).burnable().pistonBehavior(PistonBehavior.DESTROY));

    public static final Block PALE_MOSS_BLOCK = new PaleMossBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(0.1F).sounds(BlockSoundGroup.MOSS_BLOCK).pistonBehavior(PistonBehavior.DESTROY));

    public static final Block PALE_MOSS_CARPET = new CarpetBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(0.1F).sounds(BlockSoundGroup.MOSS_BLOCK).pistonBehavior(PistonBehavior.DESTROY));

    public static final Block PALE_OAK_PLANKS = new Block(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable());

    public static final Block PALE_OAK_STRAIRS = new StairsBlock(PALE_OAK_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(PALE_OAK_PLANKS));

    public static final Block PALE_OAK_SLAB = new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable());

    public static final Block PALE_OAK_FENCE = new FenceBlock(AbstractBlock.Settings.create().mapColor(PALE_OAK_PLANKS.getDefaultMapColor()).solid().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable());

    public static final Block PALE_OAK_FENCE_GATE = new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.create().mapColor(PALE_OAK_PLANKS.getDefaultMapColor()).solid().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).burnable());

    public static final Block PALE_OAK_SAPLING = new SaplingBlock(PaleOakSapling.PALE, AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ).burnable().pistonBehavior(PistonBehavior.DESTROY));

    public static final Block PALE_OAK_LEAVES = new LeavesBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never));

    public static final Block PALE_OAK_BUTTON = new ButtonBlock(ModBlockSetType.PALE, 30, AbstractBlock.Settings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY));

    public static final Block PALE_OAK_PRESSURE_PLATE = new PressurePlateBlock(ModBlockSetType.PALE, AbstractBlock.Settings.create().mapColor(PALE_OAK_PLANKS.getDefaultMapColor()).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY));

    public static final Block CREAKING_HEART = new CreakingHeartBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(2.1F).sounds(ModSounds.CREAKING_SOUNDS));

    public static final Item CREAKING_SPAWN_EGG = new SpawnEggItem(CREAKING, 0xc4c4c4, 0xadadad, new Item.Settings());

    public static final Block CLOSED_EYE_BLOSSOM_BLOCK = new ClosedEyeBlossomBlock(StatusEffects.NAUSEA, 7.0f, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).ticksRandomly());
    
    public static final Block OPEN_EYE_BLOSSOM_BLOCK = new OpenEyeBlossomBlock(StatusEffects.BLINDNESS, 11.0f, AbstractBlock.Settings.create().mapColor(MapColor.DARK_AQUA).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).ticksRandomly());
    
    public static final Block PALE_OAK_DOOR = new DoorBlock(ModBlockSetType.PALE, AbstractBlock.Settings.create().mapColor(PALE_OAK_PLANKS.getDefaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static final Block PALE_OAK_TRAPDOOR = new TrapdoorBlock(ModBlockSetType.PALE, AbstractBlock.Settings.create().mapColor(PALE_OAK_PLANKS.getDefaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable());
    
    public static final Block RESIN_BLOCK = new Block(AbstractBlock.Settings.create().hardness(0));
    public static final Block RESIN_BRICKS = new Block(AbstractBlock.Settings.create().hardness(1.5f));
    public static final Block CHISELED_RESIN_BRICK = new Block(AbstractBlock.Settings.create().hardness(1.5f));
    public static final Block RESIN_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(RESIN_BRICKS).hardness(1.5f));
    public static final Block RESIN_BRICK_STAIRS = new StairsBlock(RESIN_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(RESIN_BRICKS).hardness(1.5f));
    public static final Block RESIN_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(RESIN_BRICKS).solid().hardness(1.5f));
    public static final Block POTTED_PALE_OAK_SAPLING = Blocks.createFlowerPotBlock(PALE_OAK_SAPLING);
    public static final Block POTTED_CLOSED_EYE_BLOSSOM = Blocks.createFlowerPotBlock(CLOSED_EYE_BLOSSOM_BLOCK);
    public static final Block POTTED_OPEN_EYE_BLOSSOM = Blocks.createFlowerPotBlock(OPEN_EYE_BLOSSOM_BLOCK);
    public static final Item RESIN_CLUMP = new Item(new Item.Settings());
    public static final Item RESIN_BRICK = new Item(new Item.Settings());
    public static final Block PALE_HANGING_MOSS = new PaleHangingMossBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(0.1F).sounds(BlockSoundGroup.MOSS_BLOCK).pistonBehavior(PistonBehavior.DESTROY));
    public static final Block PALE_HANGING_MOSS_PLANT = new PaleHangingMossPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(0.1F).sounds(BlockSoundGroup.MOSS_BLOCK).pistonBehavior(PistonBehavior.DESTROY));
    public static final Identifier PALE_OAK_TREE_FEATURE_ID = Identifier.of("iwie", "pale_oak_tree");
    public static final PaleOakTreeFeature PALE_FEATURE = new PaleOakTreeFeature(PaleOakTreeFeatureConfig.CODEC);
    public static final Identifier PALE_MOSS_PATCH_FEATURE_ID = Identifier.of("iwie", "pale_moss_patch");
    public static final PaleMossPatchFeature PALE_MOSS_PATCH_FEATURE = new PaleMossPatchFeature(PaleMossPatchConfig.CODEC);
    public static final Identifier PALE_MOSS_PATCH_CEILING_FEATURE_ID = Identifier.of("iwie", "pale_moss_patch_ceiling");
    public static final PaleMossPatchCeilingFeature PALE_MOSS_PATCH_CEILING_FEATURE = new PaleMossPatchCeilingFeature(PaleMossPatchCeilingConfig.CODEC);
    public static final Identifier PALE_SHORT_GRASS_PATCH_FEATURE_ID = Identifier.of("iwie", "pale_short_grass_patch");
    public static final PaleShortGrassFeature PALE_SHORT_GRASS_FEATURE = new PaleShortGrassFeature(PaleShortGrassPatchConfig.CODEC);
    public static final Identifier PALE_MOSS_PATCH_BONEMEAL_FEATURE_ID = Identifier.of("iwie", "pale_moss_patch_bonemeal");
    public static final PaleMossPatchBonemealFeature PALE_MOSS_PATCH_BONEMEAL_FEATURE = new PaleMossPatchBonemealFeature(PaleMossPatchBonemealConfig.CODEC);
    public static final TreeDecoratorType<CreakingHeartDecorator> CREAKING_HEART_DECORATOR_TREE_DECORATOR_TYPE = new TreeDecoratorType<>(CreakingHeartDecorator.CODEC);
    private static final ItemGroup IWIE = FabricItemGroup.builder()
            .icon(() -> new ItemStack(PALE_OAK_LOG))
            .displayName(Text.translatable("itemGroup.iwie.main"))
            .entries((context, entries) -> {
                //entries.add(TEST);
                entries.add(PALE_OAK_LOG);
                entries.add(PALE_SHORT_GRASS);
                entries.add(PALE_MOSS_BLOCK);
                entries.add(PALE_MOSS_CARPET);
                entries.add(PALE_OAK_PLANKS);
                entries.add(PALE_OAK_STRAIRS);
                entries.add(PALE_OAK_SLAB);
                entries.add(PALE_OAK_FENCE);
                entries.add(PALE_OAK_FENCE_GATE);
                entries.add(PALE_OAK_SAPLING);
                entries.add(CLOSED_EYE_BLOSSOM_BLOCK);
                entries.add(OPEN_EYE_BLOSSOM_BLOCK);
                entries.add(PALE_OAK_DOOR);
                entries.add(PALE_OAK_TRAPDOOR);
                entries.add(PALE_OAK_LEAVES);
                entries.add(PALE_OAK_BUTTON);
                entries.add(PALE_OAK_PRESSURE_PLATE);
                entries.add(PALE_HANGING_MOSS);
                entries.add(STRIPPED_PALE_OAK_LOG);
                entries.add(PALE_OAK_WOOD);
                entries.add(STRIPPED_PALE_OAK_WOOD);
                entries.add(CREAKING_SPAWN_EGG);
                entries.add(CREAKING_HEART);
                entries.add(RESIN_BLOCK);
                entries.add(RESIN_BRICKS);
                entries.add(RESIN_BRICK_SLAB);
                entries.add(RESIN_BRICK_STAIRS);
                entries.add(RESIN_BRICK_WALL);
                entries.add(RESIN_CLUMP);
                entries.add(RESIN_BRICK);
            })
            .build();

    @Override
    public void onInitialize() {

        LOGGER.info("Initializing items and blocks from 1.22 update!");

        //sounds
        ModSounds.registerSounds();
        //

        Registry.register(Registries.FEATURE, PALE_OAK_TREE_FEATURE_ID, PALE_FEATURE);

        Registry.register(Registries.FEATURE, PALE_MOSS_PATCH_FEATURE_ID, PALE_MOSS_PATCH_FEATURE);

        Registry.register(Registries.FEATURE, PALE_MOSS_PATCH_CEILING_FEATURE_ID, PALE_MOSS_PATCH_CEILING_FEATURE);

        Registry.register(Registries.FEATURE, PALE_SHORT_GRASS_PATCH_FEATURE_ID, PALE_SHORT_GRASS_FEATURE);

        Registry.register(Registries.FEATURE, PALE_MOSS_PATCH_BONEMEAL_FEATURE_ID, PALE_MOSS_PATCH_BONEMEAL_FEATURE);

        Registry.register(Registries.TREE_DECORATOR_TYPE, Identifier.of("iwie", "creaking_heart"), CREAKING_HEART_DECORATOR_TREE_DECORATOR_TYPE);
        CreakingBlockEntityTypes.initialize();

        ModRegistry.registerBlocks();
        ModRegistry.registerItems();
        ModRegistry.registerFuel();
        
        Registry.register(Registries.ITEM_GROUP, Identifier.of("iwie", "main"), IWIE);
        
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PALE_MOSS_BLOCK.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(OPEN_EYE_BLOSSOM_BLOCK.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(CLOSED_EYE_BLOSSOM_BLOCK.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PALE_MOSS_CARPET.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PALE_OAK_LEAVES.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PALE_OAK_SAPLING.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PALE_SHORT_GRASS.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PALE_HANGING_MOSS.asItem(), 0.3f);

        FabricDefaultAttributeRegistry.register(CREAKING, CreakingEntity.createMobAttributes());

        // check if Wilder Wild is present
        if (FabricLoader.getInstance().isModLoaded("wilderwild")) {
            LOGGER.info("Wilder Wild mod is present, initializing compatibility features!");
            WilderWildCompat.init();
        }

        StrippableBlockRegistry.register(PALE_OAK_LOG, STRIPPED_PALE_OAK_LOG);
        StrippableBlockRegistry.register(PALE_OAK_WOOD, STRIPPED_PALE_OAK_WOOD);
    }
}
