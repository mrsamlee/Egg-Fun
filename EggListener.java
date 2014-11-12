package com.weeshna.EggParticalExplosion;

import org.bukkit.TreeType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.entity.*;

public class EggListener implements Listener {
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e){
		Projectile p = e.getEntity();
		if(!(p instanceof Egg))
			return;
		Egg myEgg = (Egg) p;		
		myEgg.getWorld().createExplosion(myEgg.getLocation(), 4.0F);
	}
}
