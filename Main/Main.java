package Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.PortalProtection;

public class Main extends JavaPlugin {

	public static Plugin plugin;
	private String world = "world";
	
    @Override
    public void onEnable() {
    	
		plugin = this;
		registerEvents(this);
		getCommand("portalprotection").setExecutor(new PortalProtection());
		plugin.getConfig().options().copyDefaults(true);
		
		
    	
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
    				for (int i = 1; i < (int) plugin.getConfig().getInt("portals") + 1; i++) {
    					Location loc = new Location(Bukkit.getWorld(world), plugin.getConfig().getInt("portal-list." + ("portal-" + i) + ".X"), plugin.getConfig().getInt("portal-list." + ("portal-" + i) + ".Y"), plugin.getConfig().getInt("portal-list." + ("portal-" + i) + ".Z"));
    					
    					 /* ---
    					 ** -X-
    					 ** --- */
       				Bukkit.getServer().getWorld(world).getBlockAt((int) loc.getBlockX(), (int) loc.getBlockY(), (int) loc.getBlockZ()).setType(Material.ENDER_PORTAL);
   					 /* -X-
   					 ** ---
   					 ** --- */
       				Bukkit.getServer().getWorld(world).getBlockAt(loc.getBlockX() + 1, loc.getBlockY(), loc.getBlockZ()).setType(Material.ENDER_PORTAL);
					 /* ---
					 ** ---
					 ** -X- */
       				Bukkit.getServer().getWorld(world).getBlockAt(loc.getBlockX() - 1, loc.getBlockY(), loc.getBlockZ()).setType(Material.ENDER_PORTAL);
					 /* ---
					 ** X--
					 ** --- */
       				Bukkit.getServer().getWorld(world).getBlockAt(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ() - 1).setType(Material.ENDER_PORTAL);
					 /* ---
					 ** --X
					 ** --- */
       				Bukkit.getServer().getWorld(world).getBlockAt(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ() + 1).setType(Material.ENDER_PORTAL);
					 /* X--
					 ** ---
					 ** --- */
       				Bukkit.getServer().getWorld(world).getBlockAt(loc.getBlockX() + 1, loc.getBlockY(), loc.getBlockZ() - 1).setType(Material.ENDER_PORTAL);
					 /* --X
					 ** ---
					 ** --- */
       				Bukkit.getServer().getWorld(world).getBlockAt(loc.getBlockX() + 1, loc.getBlockY(), loc.getBlockZ() + 1).setType(Material.ENDER_PORTAL);
					 /* ---
					 ** ---
					 ** X-- */
       				Bukkit.getServer().getWorld(world).getBlockAt(loc.getBlockX() - 1, loc.getBlockY(), loc.getBlockZ() - 1).setType(Material.ENDER_PORTAL);
					 /* ---
					 ** ---
					 ** --X */
       				Bukkit.getServer().getWorld(world).getBlockAt(loc.getBlockX() - 1, loc.getBlockY(), loc.getBlockZ() + 1).setType(Material.ENDER_PORTAL);
    				}
    			}
    			// first long is to determine how often it occurs
    		}, 1L, (long) 5 * 20);
    		
    }
    
    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
    		for (Listener listener : listeners) {
    			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
    		}
    	}
    
    public static Plugin getPlugin() {	
		return plugin;
	}
}
