package net.neonstars.util;

import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This class extends JavaPlugin class.<br>
 * This provides following functions.
 * <h2>・Call registerEvents(Listener,JavaPlugin) method easily</h2>
 * This class has registerListener(Listener) method.<br>
 * This method equals getServer().getPluginManager().registerEvents(Listener,this).
 * <br>
 * <h2>・stopEnabling and stopDisabling</h2>
 * This class has stopEnabling() and stopDisabling() method.<br>
 * <div style="margin-left: 20px;">
 * <h3>- stopEnabling method</h3>
 * Calling this method call getPluginLoader().disablePlugin(this) and set failedToEnable variable at true.<br>
 * <br>
 * <h3>- stopDisabling method</h3>
 * Calling this method set failedToDisable at true.
 * </div>
 *
 * @author wintermaples
 */
public class BukkitPlugin extends JavaPlugin {

  @Getter
  protected boolean failedToEnable;

  @Getter
  protected boolean failedToDisable;

  /**
   * This method equals getServer().getPluginManager().registerEvents(Listener,this).
   *
   * @param listener listener
   */
  public void registerEvents(Listener listener) {
    getServer().getPluginManager().registerEvents(listener, this);
  }

  /**
   * This method stop enabling.
   */
  protected void stopEnabling() {
    getPluginLoader().disablePlugin(this);
    failedToEnable = true;
  }

  /**
   * This method stop disabling.
   */
  protected void stopDisabling() {
    failedToDisable = true;
  }

}
