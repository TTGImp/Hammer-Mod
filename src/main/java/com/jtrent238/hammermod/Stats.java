package com.jtrent238.hammermod;

import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.util.ChatComponentTranslation;

public class Stats {

	public static StatBase chexplosions;

	public static void RegisterStats() {
		
		chexplosions = new StatBasic("stat.chexplosions", new ChatComponentTranslation("stat.chexplosions", new Object[0])).initIndependentStat().registerStat();
		
	}
}