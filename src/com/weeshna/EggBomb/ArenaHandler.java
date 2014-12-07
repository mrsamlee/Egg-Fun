package com.weeshna.EggBomb;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack; 

public class ArenaHandler implements CommandExecutor{
private Main plugin;
	
	public ArenaHandler(Main plugin){
		this.plugin = plugin;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		

		if(cmd.getName().equalsIgnoreCase("Arena")&&args.length==0){
			p.sendMessage(ChatColor.WHITE +"********" + ChatColor.GREEN + "Weeshna's Egg Teleporting Arena"+ChatColor.WHITE+"********");
			p.sendMessage(ChatColor.RED+"MAKE SURE YOU HAVE 8 SLOTS AVAILABLE BEFORE USING THIS COMMAND");
			p.sendMessage(ChatColor.GOLD + "/Arena go" + ChatColor.WHITE + "- go to arena and egg teleport to light up arena.");
			p.sendMessage(ChatColor.GOLD+"/Arena leave"+ChatColor.WHITE+" - leave arena and teleport to start location");
		}
		else if(cmd.getName().equalsIgnoreCase("Arena")&&args.length==1){
			if(args[0].equalsIgnoreCase("go")){
				if(plugin.TNTplayers.contains(p)){
					p.sendMessage(ChatColor.BLUE+"Egg TNT - disabled");
					p.getInventory().remove(Material.EGG);
					plugin.TNTplayers.remove(p);
					
				}
				if(plugin.TeleportPlayers.contains(p)||!plugin.TeleportPlayers.contains(p)){
					if(!plugin.TeleportPlayers.contains(p)){
						plugin.TeleportPlayers.add(p);
					}
					plugin.ArenaPlayers.add(p);
					p.teleport(new Location(p.getWorld(), 38, 102, 288));
					p.sendMessage(ChatColor.YELLOW +"Welcome to the TELEPORT TRAINING ARENA");
					p.sendMessage(ChatColor.YELLOW +"Use egg teleporting to help light up this arena!");
					p.sendMessage(ChatColor.GREEN+"Egg Teleport - enabled");
					if(p.getInventory().contains(Material.EGG))
						p.getInventory().remove(Material.EGG);
					
					p.getInventory().addItem(new ItemStack(Material.EGG,192));
					
					if(!p.getInventory().contains(Material.TORCH)){
						p.getInventory().addItem(new ItemStack(Material.TORCH,320));
					}
				}
			}
			else if(args[0].equalsIgnoreCase("leave")){
				if(plugin.TeleportPlayers.contains(p))
					plugin.TeleportPlayers.remove(p);
				plugin.ArenaPlayers.remove(p);
				p.sendMessage(ChatColor.BLUE+"Egg Teleport - disabled");
				p.sendMessage(ChatColor.WHITE+"Good luck using /egg teleport in the real world!");
				p.getInventory().remove(Material.EGG);
				p.getInventory().remove(Material.TORCH);
				p.teleport(new Location(p.getWorld(), 253,75,294));
			}
			else{
				p.sendMessage(ChatColor.RED+"Unknown command");
			}
		}
		return false;	
	}
}
