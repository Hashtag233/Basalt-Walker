
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package basaltwalker.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BasaltWalkerModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item SOFT_BASALT = register(BasaltWalkerModBlocks.SOFT_BASALT, null);
	public static final Item MELTING_SOFT_BASALT_1 = register(BasaltWalkerModBlocks.MELTING_SOFT_BASALT_1, null);
	public static final Item MELTING_SOFT_BASALT_2 = register(BasaltWalkerModBlocks.MELTING_SOFT_BASALT_2, null);
	public static final Item MELTING_SOFT_BASALT_3 = register(BasaltWalkerModBlocks.MELTING_SOFT_BASALT_3, null);

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
