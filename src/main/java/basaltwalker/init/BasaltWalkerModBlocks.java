
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package basaltwalker.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.ArrayList;

import basaltwalker.block.SoftBasaltBlock;
import basaltwalker.block.MeltingSoftBasalt3Block;
import basaltwalker.block.MeltingSoftBasalt2Block;
import basaltwalker.block.MeltingSoftBasalt1Block;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BasaltWalkerModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block SOFT_BASALT = register(new SoftBasaltBlock());
	public static final Block MELTING_SOFT_BASALT_1 = register(new MeltingSoftBasalt1Block());
	public static final Block MELTING_SOFT_BASALT_2 = register(new MeltingSoftBasalt2Block());
	public static final Block MELTING_SOFT_BASALT_3 = register(new MeltingSoftBasalt3Block());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}
}
