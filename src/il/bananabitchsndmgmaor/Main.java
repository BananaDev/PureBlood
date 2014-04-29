package il.bananabitchsndmgmaor;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	public final Logger logger = Logger.getLogger("Minecraft");
	  private Metrics metrics;
	  public void onEnable() {
			  
			  
		    getServer().getPluginManager().registerEvents(this, this);
		    PluginDescriptionFile pdfFile = getDescription();
		    logger.info("[" + pdfFile.getName() + "] v" + pdfFile.getVersion() + " has been enabled!");
		    try {
		      getConfig().options().copyDefaults(true);
		      saveConfig();
		      logger.info("[" + pdfFile.getName() + "] Loaded Config!");
		    } catch (Exception e) {
		      logger.info("[" + pdfFile.getName() + "] Failed load The Config!");
		    }
		    try{
		      this.metrics = new Metrics(this);
		      this.metrics.start();
		    }
		    catch (IOException e)
		    {
		      getLogger().severe("Couldn't hook into Metrics.");
		      e.printStackTrace();
		    }
		  }

            
            public void onDisable(){
            	System.out.println("[PureBlood] plugin disable version 1.0");
            }
	
            
            @EventHandler
            public void onEntityDamage(EntityDamageEvent event)
            {
              if ((event.getEntity() instanceof Player))
              {
             Player p = (Player)event.getEntity();
				if(getConfig().getBoolean("Enable") == true) {
					Blood.sendBloodEffect(p);
			        return;
			      }
			  	if(getConfig().getBoolean("Enable") == false) {
			    return;
			  }
			}
	}
	}
