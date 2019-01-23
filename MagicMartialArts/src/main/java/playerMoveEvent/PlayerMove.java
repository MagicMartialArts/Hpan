package playerMoveEvent;

import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import mian.Main;

public class PlayerMove implements Listener{
	
	private Main main;
	
	public PlayerMove(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		
		if(event.getTo().getY()-event.getFrom().getY()>0.0001) {
			event.setCancelled(true);
        }
		
		if(player.getLocation().getX() > player.getWorld().getSpawnLocation().getX()
				&&player.getLocation().getZ()>player.getWorld().getSpawnLocation().getZ()) {
			
			if((int)(Math.random()*100) > 90) {
				spawn(player);
				playerNotMove(player);
			}
			
			
		}
		
	}
	
	public void spawn(Player player) {
		
		Location playerLoc = player.getLocation();
		
		playerLoc.add(5, 0, 5);
		
		//生成实体
		Zombie zombie = (Zombie) player.getWorld().spawnEntity(playerLoc, EntityType.ZOMBIE);
		
		//设置最大生命值
		zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(500);
		//设置移动速度
		zombie.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
		//设置击退抗性
		zombie.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(0);
		zombie.setHealth(499);
		
		player.sendMessage("僵尸移动速度：" + zombie.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED));
		player.sendMessage("僵尸血量：" + zombie.getHealth());
		player.sendMessage("你的 X 坐标：" + playerLoc.getX());
		player.sendMessage("你的 Y 坐标：" + playerLoc.getY());
		player.sendMessage("你的 Z 坐标：" + playerLoc.getZ());
		
	}
	
	public void playerNotMove(Player player) {
		player.setWalkSpeed(0);
		
	}
	
}
