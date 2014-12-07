package com.weeshna.EggBomb;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EggHandler implements CommandExecutor{

	private Main plugin;
	
	public EggHandler(Main plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		//p.getInventory().addItem(new ItemStack(Material.EGG,5));
		if(cmd.getName().equalsIgnoreCase("Egg")&&args.length ==0){
			p.sendMessage(ChatColor.WHITE + "********" + ChatColor.GREEN + "Weeshna's Egg TNT/Teleporter"+ChatColor.WHITE+"********");
			p.sendMessage(ChatColor.GOLD + "/Egg TNT" +ChatColor.WHITE + "- turns eggs into throwable TNT");
			p.sendMessage(ChatColor.GOLD + "/Egg Teleport" +ChatColor.WHITE + "- teleports player to where thrown egg lands.");
		}
		else if(cmd.getName().equalsIgnoreCase("Egg")&&args.length ==1){
			if(args[0].equalsIgnoreCase("TNT")){
				if(this.plugin.TeleportPlayers.contains(p)){
					p.sendMessage(ChatColor.BLUE +"Egg teleport - disabled");
					p.getInventory().remove(Material.EGG);
					plugin.TeleportPlayers.remove(p);
				}
				if(!plugin.TNTplayers.contains(p)){
					if(plugin.ArenaPlayers.contains(p)){
						p.sendMessage(ChatColor.RED +"You can't use egg TNT in the practice arena!");
						p.sendMessage(ChatColor.GRAY+"Enter /arena go or /arena leave");
						p.getInventory().remove(Material.TORCH);
					}else{
					plugin.TNTplayers.add(p);
					p.sendMessage(ChatColor.GREEN +"Egg TNT - enabled");
					p.sendMessage(ChatColor.WHITE+"Have 10 exploding eggs..");
					if(p.getInventory().contains(Material.EGG))
						p.getInventory().remove(Material.EGG);
					p.getInventory().addItem(new ItemStack(Material.EGG,10));
					
					}
				}
				else if(plugin.TNTplayers.contains(p)){
					p.getInventory().remove(Material.EGG);
					plugin.TNTplayers.remove(p);
					p.sendMessage(ChatColor.BLUE +"Egg TNT - disabled");
				}
				
			}
			else if(args[0].equalsIgnoreCase("Teleport")){
				if(plugin.TNTplayers.contains(p)){
					p.sendMessage(ChatColor.BLUE+"Egg TNT - disabled");
					p.getInventory().remove(Material.EGG);
					plugin.TNTplayers.remove(p);
				}
				if(!plugin.TeleportPlayers.contains(p)||plugin.ArenaPlayers.contains(p)){
					if(plugin.ArenaPlayers.contains(p)){
						p.sendMessage(ChatColor.WHITE+"Already have egg teleport..");
					}
					else{
					plugin.TeleportPlayers.add(p);
					p.sendMessage(ChatColor.GREEN +"Egg Teleport - enabled");
					p.sendMessage(ChatColor.WHITE+"Have 30 teleporting eggs..");
					if(p.getInventory().contains(Material.TORCH))
						p.getInventory().remove(Material.TORCH);
					if(p.getInventory().contains(Material.EGG))
						p.getInventory().remove(Material.EGG);
					p.getInventory().addItem(new ItemStack(Material.EGG,30));
					}
			
				}
				else if(plugin.TeleportPlayers.contains(p)){
					plugin.TeleportPlayers.remove(p);
					p.getInventory().remove(Material.EGG);
					p.sendMessage(ChatColor.BLUE+"Egg Teleport - disabled");
				}
			}
			else{
				p.sendMessage(ChatColor.RED+ "Unknown command");
			}
			}
		return false;	
	}

}
