package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.FlameParticle;

import com.example.init.ModContent;

public class ExampleModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
 
        /* Registers our particle client-side. 
         * First argument is our particle's instance, created previously on ExampleMod. 
         * Second argument is the particle's factory. The factory controls how the particle behaves. 
         * In this example, we'll use FlameParticle's Factory.*/
        ParticleFactoryRegistry.getInstance().register(ModContent.AMETHYST_FLAME, FlameParticle.Factory::new);	
        ParticleFactoryRegistry.getInstance().register(ModContent.LAPIS_FLAME, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModContent.EMERALD_FLAME, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModContent.QUARTZ_FLAME, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModContent.GOLD_FLAME, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModContent.DIAMOND_FLAME, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModContent.NETHERITE_FLAME, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModContent.COPPER_FLAME, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModContent.IRON_FLAME, FlameParticle.Factory::new);	
	}
}