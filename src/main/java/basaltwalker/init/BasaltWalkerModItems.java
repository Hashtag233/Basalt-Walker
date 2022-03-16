
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package basaltwalker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import basaltwalker.BasaltWalkerMod;

public class BasaltWalkerModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BasaltWalkerMod.MODID);
	public static final RegistryObject<Item> SOFT_BASALT = block(BasaltWalkerModBlocks.SOFT_BASALT, null);
	public static final RegistryObject<Item> MELTING_SOFT_BASALT_1 = block(BasaltWalkerModBlocks.MELTING_SOFT_BASALT_1, null);
	public static final RegistryObject<Item> MELTING_SOFT_BASALT_2 = block(BasaltWalkerModBlocks.MELTING_SOFT_BASALT_2, null);
	public static final RegistryObject<Item> MELTING_SOFT_BASALT_3 = block(BasaltWalkerModBlocks.MELTING_SOFT_BASALT_3, null);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
