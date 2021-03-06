package com.jtrent238.hammermod.items.hammers;

import java.util.List;
import java.util.Random;

import com.jtrent238.hammermod.Achievements;
import com.jtrent238.hammermod.HammerMod;
import com.jtrent238.hammermod.ItemLoader;
import com.jtrent238.hammermod.Stats;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemToasterHammer extends ItemBaseHammer{


	private Item itemtogive = Items.bread;

	public ItemToasterHammer(ToolMaterial material) {
		super(material);
	}

	@Override
	 @SideOnly(Side.CLIENT)
	 public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld) {
	 list.add(EnumChatFormatting.LIGHT_PURPLE + StatCollector.translateToLocal("tooltip." + HammerMod.MODID + "." + "ItemToasterHammer" + "." + "createdby"));
	 list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("tooltip." + HammerMod.MODID + "." + "communityhammer"));
		
	  }
	
	/**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5, EntityPlayer player) {
    	
    	ItemStack stack = new ItemStack(itemtogive ,1);
		stack.setStackDisplayName("Toast");
    	player.inventory.addItemStackToInventory(stack);
    }
	
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
    	
    	if(HammerMod.RANDOM_TOAST == true) {
    		
    		Random rn = new Random();
    		int max = 21;
    		int min = 1;
    		int rnd = rn.nextInt(max - min + 1) + min;
    		System.out.println(rnd);
    		
			ItemStack stack = new ItemStack(itemtogive, rnd);
        	stack.setStackDisplayName("Toast");
        	if(HammerMod.SHARP_TOAST == true) {
        		stack.addEnchantment(Enchantment.sharpness, 25);
        	}
        	//stack.onFoodEaten(p_77659_2_, p_77659_3_);
        	p_77659_3_.inventory.addItemStackToInventory(stack);
        	p_77659_3_.playSound("hammermod:toasterbake", 5F, 5F);
        	p_77659_3_.addStat(Stats.thbaked, rnd);
        	p_77659_3_.triggerAchievement(Achievements.achievementtoast);
        	p_77659_1_.damageItem(100 * rnd, p_77659_3_);
    	}
    	
    	ItemStack stack = new ItemStack(itemtogive, 1);
    	stack.setStackDisplayName("Toast");
    	if(HammerMod.SHARP_TOAST == true) {
    		stack.addEnchantment(Enchantment.sharpness, 25);
    	}
    	//stack.onFoodEaten(p_77659_2_, p_77659_3_);
    	p_77659_3_.inventory.addItemStackToInventory(stack);
    	p_77659_3_.playSound("hammermod:toasterbake", 5F, 5F);
    	p_77659_3_.addStat(Stats.thbaked, 1);
    	p_77659_3_.triggerAchievement(Achievements.achievementtoast);
    	p_77659_1_.damageItem(100, p_77659_3_);
    	return p_77659_1_;
    }
    
	@Override
	public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_)
    {
        if ((double)p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_) != 0.0D)
        {
            p_150894_1_.damageItem(1, p_150894_7_);
        }
        	
        	/*
        if (Abilities.hulkSmash == true) {
        	Minecraft.getMinecraft().thePlayer.canHarvestBlock(Blocks.bedrock);
        	p_150894_7_.playSound("hammermod:hulksmash", 5F, 5F);
        	Minecraft.getMinecraft().thePlayer.getBreakSpeed(p_150894_3_, true, 0, p_150894_4_, p_150894_5_, p_150894_6_);
        	p_150894_1_.damageItem(100, p_150894_7_);
        	//Abilities.hulkSmash = false;
        }
        	*/
        
        if(HammerMod.TOASTER_BREAK_SOUND == true) {
        	p_150894_7_.playSound("hammermod:toasterbreak", 5F, 5F);
        }
        
        
        return true;
    }
}
