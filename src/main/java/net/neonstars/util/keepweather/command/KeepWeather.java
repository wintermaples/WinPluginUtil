package net.neonstars.util.keepweather.command;

import java.util.LinkedList;
import net.neonstars.util.command.AbstractCommand;
import net.neonstars.util.keepweather.EnumWeatherType;
import net.neonstars.util.keepweather.KeepWeatherLogic;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KeepWeather extends AbstractCommand {

  protected KeepWeatherLogic keepWeatherLogic;

  public KeepWeather(KeepWeatherLogic keepWeatherLogic, String pattern, String permission, String description) {
    super(pattern, permission, description);
    this.keepWeatherLogic = keepWeatherLogic;
  }

  @Override
  public boolean execute(CommandSender sender, LinkedList<String> args) {
    Player p = castToPlayer(sender);
    if (p == null) {
      sendFailedMessage(sender, "This command can be executed by player only!");
      return true;
    }
    EnumWeatherType weather;
    try {
      weather = EnumWeatherType.valueOf(args.get(0).toUpperCase());
    } catch (IllegalArgumentException ex) {
      sendFailedMessage(sender, "Please enter SUNNY or RAINY or STORMY in weather type!");
      return true;
    }
    keepWeatherLogic.getWeatherTypeMap().put(p.getWorld(), weather);
    sendSuccessMessage(sender, "Weather is keeping " + weather.name().toLowerCase());
    return true;
  }

  @Override
  public String getUsage(CommandSender sender) {
    return ChatColor.YELLOW + "/keepweather (weather type) - Keep weather.";
  }

}
