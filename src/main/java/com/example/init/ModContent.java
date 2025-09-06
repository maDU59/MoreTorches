package com.example.init;

import com.example.ExampleMod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.item.VerticallyAttachableBlockItem;

public class ModContent{

    public static SimpleParticleType AMETHYST_FLAME = FabricParticleTypes.simple();
    public static Block AMETHYST_TORCH = CreateTorch("amethyst", AMETHYST_FLAME);
    public static Block AMETHYST_TORCH_WALL = CreateTorchWall("amethyst", AMETHYST_FLAME);
    public static Item AMETHYST_TORCH_ITEM = CreateTorchItem("amethyst", AMETHYST_TORCH, AMETHYST_TORCH_WALL);
    public static SimpleParticleType LAPIS_FLAME = FabricParticleTypes.simple();
    public static Block LAPIS_TORCH = CreateTorch("lapis", LAPIS_FLAME);
    public static Block LAPIS_TORCH_WALL = CreateTorchWall("lapis", LAPIS_FLAME);
    public static Item LAPIS_TORCH_ITEM = CreateTorchItem("lapis", LAPIS_TORCH, LAPIS_TORCH_WALL);
    public static SimpleParticleType EMERALD_FLAME = FabricParticleTypes.simple();
    public static Block EMERALD_TORCH = CreateTorch("emerald", EMERALD_FLAME);
    public static Block EMERALD_TORCH_WALL = CreateTorchWall("emerald", EMERALD_FLAME);
    public static Item EMERALD_TORCH_ITEM = CreateTorchItem("emerald", EMERALD_TORCH, EMERALD_TORCH_WALL);
    public static SimpleParticleType QUARTZ_FLAME = FabricParticleTypes.simple();
    public static Block QUARTZ_TORCH = CreateTorch("quartz", QUARTZ_FLAME);
    public static Block QUARTZ_TORCH_WALL = CreateTorchWall("quartz", QUARTZ_FLAME);
    public static Item QUARTZ_TORCH_ITEM = CreateTorchItem("quartz", QUARTZ_TORCH, QUARTZ_TORCH_WALL); 
    public static SimpleParticleType GOLD_FLAME = FabricParticleTypes.simple();
    public static Block GOLD_TORCH = CreateTorch("gold", GOLD_FLAME);
    public static Block GOLD_TORCH_WALL = CreateTorchWall("gold", GOLD_FLAME);
    public static Item GOLD_TORCH_ITEM = CreateTorchItem("gold", GOLD_TORCH, GOLD_TORCH_WALL);
    public static SimpleParticleType DIAMOND_FLAME = FabricParticleTypes.simple();
    public static Block DIAMOND_TORCH = CreateTorch("diamond", DIAMOND_FLAME);
    public static Block DIAMOND_TORCH_WALL = CreateTorchWall("diamond", DIAMOND_FLAME);
    public static Item DIAMOND_TORCH_ITEM = CreateTorchItem("diamond", DIAMOND_TORCH, DIAMOND_TORCH_WALL);
    public static SimpleParticleType NETHERITE_FLAME = FabricParticleTypes.simple();
    public static Block NETHERITE_TORCH = CreateTorch("netherite", NETHERITE_FLAME);
    public static Block NETHERITE_TORCH_WALL = CreateTorchWall("netherite", NETHERITE_FLAME);
    public static Item NETHERITE_TORCH_ITEM = CreateTorchItem("netherite", NETHERITE_TORCH, NETHERITE_TORCH_WALL);
    public static SimpleParticleType COPPER_FLAME = FabricParticleTypes.simple();
    public static Block COPPER_TORCH = CreateTorch("copper", COPPER_FLAME);
    public static Block COPPER_TORCH_WALL = CreateTorchWall("copper", COPPER_FLAME);
    public static Item COPPER_TORCH_ITEM = CreateTorchItem("copper", COPPER_TORCH, COPPER_TORCH_WALL);
    public static SimpleParticleType IRON_FLAME = FabricParticleTypes.simple();
    public static Block IRON_TORCH = CreateTorch("iron", IRON_FLAME);
    public static Block IRON_TORCH_WALL = CreateTorchWall("iron", IRON_FLAME);
    public static Item IRON_TORCH_ITEM = CreateTorchItem("iron", IRON_TORCH, IRON_TORCH_WALL);

    private static Block CreateTorch(String name, SimpleParticleType torchFlame){
        Identifier torchId = Identifier.of(ExampleMod.MOD_ID, name + "_torch");
        return new TorchBlock(
            torchFlame,
            AbstractBlock.Settings.copy(Blocks.TORCH).registryKey(RegistryKey.of(RegistryKeys.BLOCK, torchId))
        );
    }

    private static Block CreateTorchWall(String name, SimpleParticleType torchFlame){
        Identifier wallTorchId = Identifier.of(ExampleMod.MOD_ID, name + "_torch" + "_wall");
        return new WallTorchBlock(
            torchFlame,
            AbstractBlock.Settings.copy(Blocks.WALL_TORCH).registryKey(RegistryKey.of(RegistryKeys.BLOCK, wallTorchId))
        );
    }

    private static Item CreateTorchItem(String name, Block torch, Block torchWall){
        Identifier torchId = Identifier.of(ExampleMod.MOD_ID, name + "_torch");
        return new VerticallyAttachableBlockItem(
            torch,
            torchWall,
            Direction.DOWN,
            new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, torchId))
        );
    }

    private static void RegisterTorch(String name, Block torch, Block torchWall, Item torchItem, SimpleParticleType torchFlame){
        Identifier torchId = Identifier.of(ExampleMod.MOD_ID, name + "_torch");
        Identifier wallTorchId = Identifier.of(ExampleMod.MOD_ID, name + "_torch" + "_wall");
        Registry.register(Registries.PARTICLE_TYPE,  Identifier.of(ExampleMod.MOD_ID, name + "_flame"), torchFlame);
        Registry.register(Registries.BLOCK, torchId, torch);
        Registry.register(Registries.BLOCK, wallTorchId, torchWall);
        Registry.register(Registries.ITEM, torchId, torchItem);
        ItemGroupEvents.modifyEntriesEvent(
            ItemGroups.FUNCTIONAL
        ).register(entries -> {
            entries.add(torchItem);
        });
    }


    public static void Initialize() {

        RegisterTorch("amethyst", AMETHYST_TORCH, AMETHYST_TORCH_WALL, AMETHYST_TORCH_ITEM, AMETHYST_FLAME);
        RegisterTorch("lapis", LAPIS_TORCH, LAPIS_TORCH_WALL, LAPIS_TORCH_ITEM, LAPIS_FLAME);
        RegisterTorch("emerald", EMERALD_TORCH, EMERALD_TORCH_WALL, EMERALD_TORCH_ITEM, EMERALD_FLAME);
        RegisterTorch("quartz", QUARTZ_TORCH, QUARTZ_TORCH_WALL, QUARTZ_TORCH_ITEM, QUARTZ_FLAME);
        RegisterTorch("gold", GOLD_TORCH, GOLD_TORCH_WALL, GOLD_TORCH_ITEM, GOLD_FLAME);
        RegisterTorch("diamond", DIAMOND_TORCH, DIAMOND_TORCH_WALL, DIAMOND_TORCH_ITEM, DIAMOND_FLAME);
        RegisterTorch("netherite", NETHERITE_TORCH, NETHERITE_TORCH_WALL, NETHERITE_TORCH_ITEM, NETHERITE_FLAME);
        RegisterTorch("copper", COPPER_TORCH, COPPER_TORCH_WALL, COPPER_TORCH_ITEM, COPPER_FLAME);
        RegisterTorch("iron", IRON_TORCH, IRON_TORCH_WALL, IRON_TORCH_ITEM, IRON_FLAME);
    }
}
