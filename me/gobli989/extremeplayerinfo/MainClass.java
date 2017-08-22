package me.gobli989.extremeplayerinfo;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin{
	
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("playerinfo")) {
			if(sender instanceof Player) {
				if(getConfig().getBoolean("settings.Enable")) {
					if(player.hasPermission("extremecore.playerinfo")) {
						if(args.length == 0) {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+ChatColor.RED+getConfig().getString("messages.misc.Usage"));
						} else {
							Player target = getServer().getPlayer(args[0]);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Header")));
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Name")+": "+target.getName());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.DisplayName")+": "+target.getDisplayName());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.UUID")+": "+target.getUniqueId());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Gamemode")+": "+target.getGameMode());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.World")+": "+target.getWorld().getName());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.LocX")+": "+target.getLocation().getBlockX());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.LocY")+": "+target.getLocation().getBlockY());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.LocZ")+": "+target.getLocation().getBlockZ());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Food")+": "+target.getFoodLevel());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Health")+": "+target.getHealth());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Exp")+": "+target.getExp());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Flying")+": "+target.isFlying());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.FlySpeed")+": "+target.getFlySpeed());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.WalkSpeed")+": "+target.getWalkSpeed());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Banned")+": "+target.isBanned());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Whitelisted")+": "+target.isWhitelisted());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Online")+": "+target.isOnline());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Op")+": "+target.isOp());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Sneaking")+": "+target.isSneaking());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Sprint")+": "+target.isSprinting());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Sleeping")+": "+target.isSleeping());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Dead")+": "+target.isDead());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Blocking")+": "+target.isBlocking());
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.InsideVehicle")+": "+target.isInsideVehicle());
							if(player.hasPermission("extremeplayerinfo.info.Ip")) {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Ip")+": "+target.getAddress());
							} else {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.info.Ip")+": "+getConfig().getString("messages.info.Secret"));
							}
						}
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix")+" "+getConfig().getString("messages.misc.No-Perm")));
					}
				} else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix")+" "+getConfig().getString("messages.misc.Not-Enabled")));
				}
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix")+" "+getConfig().getString("messages.misc.Only-Player")));
			}
		}
		if(cmd.getName().equalsIgnoreCase("extremeplayerinfo")) {
			if(sender.hasPermission("extremeplayerinfo.reload")) {
				if(getConfig().getBoolean("settings.Reload-Config") == true) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.misc.Config-Reload"));
					reloadConfig();
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.misc.No-Reload"));
				}
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.Prefix"))+" "+getConfig().getString("messages.misc.No-Perm"));
			}
		}
		return false;
	}

}
