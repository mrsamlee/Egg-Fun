package com.weeshna.EggFun;

import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Egg;

public class EggListener implements Listener {
	
	private Main plugin;
	public EggListener(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e){
		
		Projectile p = e.getEntity();
		@SuppressWarnings("deprecation")
		Player a = (Player) e.getEntity().getShooter();
		if(!(p instanceof Egg))
			return;
		Egg myEgg = (Egg) p;		
		if(this.plugin.TNTplayers.contains(a)&& !(this.plugin.TeleportPlayers.contains(a))){
			myEgg.getWorld().createExplosion(myEgg.getLocation(), 4.0F);
		}
		else if(this.plugin.TeleportPlayers.contains(a)&& !(this.plugin.TNTplayers.contains(a))){
			a.teleport(myEgg.getLocation());
			myEgg.getWorld().playSound(myEgg.getLocation(), Sound.FIREWORK_BLAST, 3F , 1F);
		}
	}
}
