package com.weeshna.EggFun;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	public ArrayList<Player> TNTplayers;
	public ArrayList<Player> TeleportPlayers;
	public ArrayList<Player> ArenaPlayers;
	
	public void onEnable(){
		
		TNTplayers = new ArrayList<Player>();
		TeleportPlayers = new ArrayList<Player>();	
		ArenaPlayers = new ArrayList<Player>();
		Bukkit.getServer().getPluginManager().registerEvents(new EggListener(this), this);
		getCommand("Egg").setExecutor(new EggHandler(this));
		getCommand("Arena").setExecutor(new ArenaHandler(this));
	}

}