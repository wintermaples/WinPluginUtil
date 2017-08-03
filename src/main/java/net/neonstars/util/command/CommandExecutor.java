package net.neonstars.util.command;

import lombok.Getter;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * This class helps regisering and executing command.
 *
 * @author wintermaples
 */
public class CommandExecutor {

  @Getter
  protected HashMap<String, HashSet<AbstractCommand>> commandMap = new HashMap<>();

  protected String[] labelSelector;

  /**
   * Change a label selector.
   *
   * @param selector Label selector.
   */
  public void changeLabelSelector(String... selector) {
    labelSelector = Arrays.stream(selector).map(String::toLowerCase).collect(Collectors.toSet()).toArray(new String[0]);
  }

  /**
   * Register a specified command.
   *
   * @param command Command.
   * @return If registering a specified command was succeed, this returns true.
   */
  public boolean registerCommand(AbstractCommand command) {
    boolean success = true;
    for (String selector : labelSelector) {
      commandMap.computeIfAbsent(selector, k -> new HashSet<>());
      success = commandMap.get(selector).add(command);
    }
    if (!success) {
      for (String selector : labelSelector) {
        commandMap.computeIfAbsent(selector, k -> new HashSet<>());
        commandMap.get(selector).remove(command);
      }
    }
    return success;
  }

  public boolean onCommand(String label, CommandSender sender, String[] args) {
    HashSet<AbstractCommand> commandSet = commandMap.get(label.toLowerCase());
    if (commandSet == null)
      throw new IllegalArgumentException("This command label is not registered(typo?). : " + label);
    for (AbstractCommand command : commandSet) {
      if (command.getPattern().match(args)) {
        if (command.getPermission() != null) {
          if (sender.hasPermission(command.getPermission())) {
            command.execute(sender, new LinkedList<>(Arrays.asList(args)));
            return true;
          } else {
            sender.sendMessage("§4You don't have permission. (" + command.getPermission() + ")");
            return true;
          }
        } else {
          command.execute(sender, new LinkedList<>(Arrays.asList(args)));
          return true;
        }
      } else if (command.getPattern().firstMatch(args)) {
        sender.sendMessage(command.getUsage(sender));
        return true;
      }
    }

    commandSet.forEach((command) -> sender.sendMessage(command.getUsage(sender)));
    return true;
  }

}
