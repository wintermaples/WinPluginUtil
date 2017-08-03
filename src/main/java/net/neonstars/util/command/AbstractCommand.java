package net.neonstars.util.command;

import lombok.Getter;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * This class is an abstract class to create a command easily.
 * <h2>How to create a command.</h2>
 * First, create a class which extends AbstractCommand class.<br>
 * Next, on main class, define instance variable which type is CommandExecutor.<br>
 * Next, call CommandExecutor(variable).changeLabelSelector(String) method. The argument is a command label.<br>
 * Next, call CommandExecutor(variable).registerCommand(AbstractCommand).<br>
 * And, call CommandExecutor.onCommand(String,CommandSender,String[]) on JavaPlugin.onCommand.
 *
 * @author wintermaples
 */
public abstract class AbstractCommand {

  /**
   * A pattern of command.
   */
  @Getter
  protected CmdPattern pattern;

  /**
   * A permission of command.
   */
  @Getter
  protected String permission;

  /**
   * A description of command.
   */
  @Getter
  protected String description;

  public static ChatColor SUCCESS_COLOR = ChatColor.GREEN;

  public static ChatColor FAILED_COLOR = ChatColor.RED;

  public static ChatColor INFO_COLOR = ChatColor.GOLD;

  public AbstractCommand(String pattern, String permission, String description) {
    this.pattern = new CmdPattern(pattern);
    this.permission = permission;
    this.description = description;
  }

  /**
   * It executes this command.
   *
   * @param sender CommandSender
   * @param args Arguments.
   * @return If executing this command successfully, this returns true.
   */
  public abstract boolean execute(CommandSender sender, LinkedList<String> args);

  /**
   * It returns usage of this command.
   *
   * @param sender CommandSender
   * @return Usage of this command.
   */
  public abstract String getUsage(CommandSender sender);

  /**
   * Cast the command sender to the player.
   *
   * @param sender CommandSender
   * @return A casted player from a command sender.
   */
  public Player castToPlayer(CommandSender sender) {
    return Bukkit.getPlayerExact(sender.getName());
  }

  /**
   * Cast a command sender to a location of player.
   *
   * @param sender CommandSender
   * @return A casted location of player from a command sender.
   */
  public Location castToLocation(CommandSender sender) {
    if (sender instanceof Player)
      return castToPlayer(sender).getLocation();
    else if (sender instanceof CommandBlock)
      return ((CommandBlock) sender).getBlock().getLocation();
    else
      return null;
  }

  /**
   * Cast a command sender to the world.
   *
   * @param sender CommandSender
   * @return A casted world from a command sender.
   */
  public World castToWorld(CommandSender sender) {
    return castToLocation(sender).getWorld();
  }

  /**
   * Combine a specified argument with SUCCESS_COLOR.
   *
   * @param str string
   * @return A combined string.
   */
  public String combineSuccessColor(String str) {
    return SUCCESS_COLOR + str;
  }

  /**
   * Combine a specified argument with FAILED_COLOR.
   *
   * @param str string
   * @return A combined string.
   */
  public String combineFailedColor(String str) {
    return FAILED_COLOR + str;
  }

  /**
   * Combine a specified argument with INFO_COLOR.
   *
   * @param str string
   * @return A combined string.
   */
  public String combineInfoColor(String str) {
    return INFO_COLOR + str;
  }

  /**
   * Send a success message to the command sender.
   *
   * @param cs CommandSender
   * @param message Message
   */
  public void sendSuccessMessage(CommandSender cs, String message) {
    cs.sendMessage(combineSuccessColor(message));
  }

  /**
   * Send a failed message to the command sender.
   *
   * @param cs CommandSender
   * @param message Message
   */
  public void sendFailedMessage(CommandSender cs, String message) {
    cs.sendMessage(combineFailedColor(message));
  }

  /**
   * Send a info message to the command sender.
   *
   * @param cs CommandSender
   * @param message Message
   */
  public void sendInfoMessage(CommandSender cs, String message) {
    cs.sendMessage(combineInfoColor(message));
  }

  public static boolean isNumber(List<String> args, int index) {
    return NumberUtils.isNumber(args.get(index));
  }

  public static boolean isNumber(List<String> args, int min, int max) {
    for (int i = 0; i <= max - min; i++)
      if (!isNumber(args, min + i))
        return false;
    return true;
  }

  public static boolean isInt(List<String> args, int index) {
    String numStr = args.get(index);
    if (args.get(index).startsWith("-"))
      numStr = numStr.substring(1, numStr.length() - 1);
    return NumberUtils.isDigits(numStr);
  }

  public static boolean isInt(List<String> args, int min, int max) {
    for (int i = 0; i <= max - min; i++)
      if (!isInt(args, min + i))
        return false;
    return true;
  }

  public static boolean isPositiveInt(List<String> args, int index) {
    return isPositiveInt(args.get(index));
  }

  public static boolean isPositiveInt(List<String> args, int min, int max) {
    for (int i = 0; i <= max - min; i++)
      if (!isPositiveInt(args.get(min + i)))
        return false;
    return true;
  }

  public static boolean isPositiveInt(String str) {
    return NumberUtils.isDigits(str) && Integer.parseInt(str) >= 0;
  }

  public static boolean isNegativeInt(List<String> args, int index) {
    return isNegativeInt(args.get(index));
  }

  public static boolean isNegativeInt(List<String> args, int min, int max) {
    for (int i = 0; i <= max - min; i++)
      if (!isNegativeInt(args.get(min + i)))
        return false;
    return true;
  }

  public static boolean isNegativeInt(String str) {
    return NumberUtils.isDigits(str) && Integer.parseInt(str) < 0;
  }

  public static boolean hasOption(List<String> args, int index) {
    return args.size() > index;
  }

  public static boolean hasOptions(List<String> args, int min, int max) {
    return args.size() > min && args.size() > max;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 97 * hash + Objects.hashCode(this.pattern);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final AbstractCommand other = (AbstractCommand) obj;
    if (!Objects.equals(this.pattern, other.pattern))
      return false;
    return true;
  }

}
