package com.jtrent238.hammermod.items.hammers;

import java.util.List;

import com.jtrent238.hammermod.Main;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMissingTextureHammer extends ItemBaseHammer {

	public ItemMissingTextureHammer(ToolMaterial material, String unlocalizedName, String registryName) {
		super(material, unlocalizedName, registryName);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(ItemBaseHammer.ToolTipColor_SPECIAL  + "tooltip." + Main.MODID + "." + "special");
	}
}
