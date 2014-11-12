package com.weeshna.EggParticalExplosion;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(new EggListener(), this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("EggTNT")){
			p.sendMessage("Eggs are now bombs!");
			p.sendMessage("Test Video for CS185C project - Samson Lee");
			
			return true;
		}
		return false;	
	}
}
