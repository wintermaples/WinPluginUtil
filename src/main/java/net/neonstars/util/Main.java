package net.neonstars.util;

import lombok.Getter;
import net.neonstars.util.command.CommandExecutor;
import net.neonstars.util.data.DeserializableClassRegisterer;
import net.neonstars.util.keepweather.KeepWeatherLogic;
import net.neonstars.util.keepweather.command.KeepWeather;
import net.neonstars.util.location.Area;
import net.neonstars.util.location.SimpleLocation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.serialization.ConfigurationSerialization;

public class Main extends BukkitPlugin implements DeserializableClassRegisterer {

  protected CommandExecutor cmdExecutor = new CommandExecutor();

  protected KeepWeatherLogic keepWeatherLogic;

  @Getter
  private static Main plugin;

  @Override
  public void onEnable() {
    plugin = this;

    executeSchedulers();

    registerCommands();

    registerDeserializableClasses();
  }

  @Override
  public void onDisable() {
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    return cmdExecutor.onCommand(label, sender, args);
  }

  private void executeSchedulers() {
    keepWeatherLogic = new KeepWeatherLogic();
    keepWeatherLogic.runTaskTimer(this, 0, 20);
  }

  private void registerCommands() {
    cmdExecutor.changeLabelSelector("keepweather");
    cmdExecutor.registerCommand(new KeepWeather(keepWeatherLogic, "any", "keepweather", null));
  }

  @Override
  public void registerDeserializableClasses() {
    ConfigurationSerialization.registerClass(SimpleLocation.class);
    ConfigurationSerialization.registerClass(Area.class);
  }

}
