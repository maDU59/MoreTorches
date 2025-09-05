package com.example.init;

import com.example.ExampleMod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TorchBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemGroups;

public class ModContent implements ModInitializer {

    public static Block AMETHYST_TORCH;

    public static Item AMETHYST_TORCH_ITEM;

    @Override
    public void onInitialize() {
        AMETHYST_TORCH = new TorchBlock(
            ParticleTypes.FLAME,
            AbstractBlock.Settings.copy(Blocks.TORCH)
        );

        AMETHYST_TORCH_ITEM = new BlockItem(
            AMETHYST_TORCH,
            new Item.Settings()
        );

        Registry.register(Registries.BLOCK, Identifier.of(ExampleMod.MOD_ID, "amethyst_torch"), AMETHYST_TORCH);


        Registry.register(Registries.ITEM, Identifier.of(ExampleMod.MOD_ID, "amethyst_torch"), AMETHYST_TORCH_ITEM);

        ItemGroupEvents.modifyEntriesEvent(
            ItemGroups.FUNCTIONAL
        ).register(entries -> {
            entries.add(AMETHYST_TORCH_ITEM);
        });
    }
}
