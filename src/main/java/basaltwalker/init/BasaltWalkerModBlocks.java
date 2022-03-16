
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package basaltwalker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import basaltwalker.block.SoftBasaltBlock;
import basaltwalker.block.MeltingSoftBasalt3Block;
import basaltwalker.block.MeltingSoftBasalt2Block;
import basaltwalker.block.MeltingSoftBasalt1Block;

import basaltwalker.BasaltWalkerMod;

public class BasaltWalkerModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, BasaltWalkerMod.MODID);
	public static final RegistryObject<Block> SOFT_BASALT = REGISTRY.register("soft_basalt", () -> new SoftBasaltBlock());
	public static final RegistryObject<Block> MELTING_SOFT_BASALT_1 = REGISTRY.register("melting_soft_basalt_1", () -> new MeltingSoftBasalt1Block());
	public static final RegistryObject<Block> MELTING_SOFT_BASALT_2 = REGISTRY.register("melting_soft_basalt_2", () -> new MeltingSoftBasalt2Block());
	public static final RegistryObject<Block> MELTING_SOFT_BASALT_3 = REGISTRY.register("melting_soft_basalt_3", () -> new MeltingSoftBasalt3Block());
}
