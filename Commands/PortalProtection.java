package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

public class PortalProtection implements CommandExecutor{
	
	public static Plugin plugin = Main.Main.getPlugin();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		if (command.getName().equalsIgnoreCase("portalprotection")) {
			if (player.isOp() == false) {
				return true;
			}
			if (args[0] == null) {
				player.sendMessage(ChatColor.DARK_RED + "Invalid amount of arguments.");
				return true;
			} else {
				if (args[0].equalsIgnoreCase("add")) {
					if (args.length != 4) {
						player.sendMessage(ChatColor.RED + "Invalid amount of arguments.");
						return true;
					} else {
						int i = Main.Main.getPlugin().getConfig().getInt("portals") + 1;
						plugin.getConfig().set("portals", i);
						
						int x = Integer.parseInt(args[1]);
						int y = Integer.parseInt(args[2]);
						int z = Integer.parseInt(args[3]);
						
						plugin.getConfig().set("portal-list.portal-" + i + ".X", x);
						plugin.getConfig().set("portal-list.portal-" + i + ".Y", y);
						plugin.getConfig().set("portal-list.portal-" + i + ".Z", z);
						plugin.saveConfig();
						
						player.sendMessage(ChatColor.GRAY + "Created a portal at " + ChatColor.RED + x + ChatColor.GRAY + "/" + ChatColor.RED + y + ChatColor.GRAY + "/" + ChatColor.RED + z + ChatColor.GRAY + ".");
					}
				} else if (args[0].equalsIgnoreCase("remove")) {
					if (args.length != 2) {
						player.sendMessage(ChatColor.RED + "Invalid amount of arguments.");
						return true;
					} else {
						player.sendMessage(ChatColor.RED + "Buggy, will be added in the future.");
					}
				}
			}
		}
		return false;
	}

}
