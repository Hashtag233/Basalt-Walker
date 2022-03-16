
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package basaltwalker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import basaltwalker.enchantment.BasaltWalkerEnchantment;

import basaltwalker.BasaltWalkerMod;

public class BasaltWalkerModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, BasaltWalkerMod.MODID);
	public static final RegistryObject<Enchantment> BASALT_WALKER = REGISTRY.register("basalt_walker", () -> new BasaltWalkerEnchantment());
}
