package mian;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import playerMoveEvent.PlayerMove;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		//注册
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new PlayerMove(this),this);
		this.getLogger().info("插件已启动");
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		this.getLogger().info("插件已关闭");
		super.onDisable();
	}
	
}
