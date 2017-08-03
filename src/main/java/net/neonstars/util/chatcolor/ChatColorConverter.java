package net.neonstars.util.chatcolor;

import org.bukkit.ChatColor;

/**
 * This class helps to convert string to ChatColor or convert ChatColor to string.<br>
 * The string which is converted can be used to save on file or database or etc.
 *
 * @author wintermaples
 */
public class ChatColorConverter {

  /**
   * This method converts ChatColor to string.
   * 
   * @param color ChatColor to be used to convert
   * @return String which is converted from ChatColor. If converting is failed, it returns null.
   */
  public static String convertToString(ChatColor color) {
    switch (color) {
      case BLACK:
        return "BLACK";
      case DARK_BLUE:
        return "DARK_BLUE";
      case DARK_GREEN:
        return "DARK_GREEN";
      case DARK_AQUA:
        return "DARK_AQUA";
      case DARK_RED:
        return "DARK_RED";
      case DARK_PURPLE:
        return "DARK_PURPLE";
      case GOLD:
        return "GOLD";
      case GRAY:
        return "GRAY";
      case DARK_GRAY:
        return "DARK_GRAY";
      case BLUE:
        return "BLUE";
      case GREEN:
        return "GREEN";
      case AQUA:
        return "AQUA";
      case RED:
        return "RED";
      case LIGHT_PURPLE:
        return "LIGHT_PURPLE";
      case YELLOW:
        return "YELLOW";
      case WHITE:
        return "WHITE";
      case MAGIC:
        return "MAGIC";
      case BOLD:
        return "BOLD";
      case STRIKETHROUGH:
        return "STRIKETHROUGH";
      case UNDERLINE:
        return "UNDERLINE";
      case ITALIC:
        return "ITALIC";
      case RESET:
        return "RESET";
      default: 
        return null;
    }
  }

  /**
   * This method converts string to ChatColor.
   * 
   * @param colorStr String to be used to convert
   * @return ChatColor which is converted from string. If converting is failed, it returns null.
   */
  public static ChatColor convertToChatColor(String colorStr) {
    switch (colorStr) {
      case "BLACK":
        return ChatColor.BLACK;
      case "DARK_BLUE":
        return ChatColor.DARK_BLUE;
      case "DARK_GREEN":
        return ChatColor.DARK_GREEN;
      case "DARK_AQUA":
        return ChatColor.DARK_AQUA;
      case "DARK_RED":
        return ChatColor.DARK_RED;
      case "DARK_PURPLE":
        return ChatColor.DARK_PURPLE;
      case "GOLD":
        return ChatColor.GOLD;
      case "GRAY":
        return ChatColor.GRAY;
      case "DARK_GRAY":
        return ChatColor.DARK_GRAY;
      case "BLUE":
        return ChatColor.BLUE;
      case "GREEN":
        return ChatColor.GREEN;
      case "AQUA":
        return ChatColor.AQUA;
      case "RED":
        return ChatColor.RED;
      case "LIGHT_PURPLE":
        return ChatColor.LIGHT_PURPLE;
      case "YELLOW":
        return ChatColor.YELLOW;
      case "WHITE":
        return ChatColor.WHITE;
      case "MAGIC":
        return ChatColor.MAGIC;
      case "BOLD":
        return ChatColor.BOLD;
      case "STRIKETHROUGH":
        return ChatColor.STRIKETHROUGH;
      case "UNDERLINE":
        return ChatColor.UNDERLINE;
      case "ITALIC":
        return ChatColor.ITALIC;
      case "RESET":
        return ChatColor.RESET;
      default:
        return null;
    }
  }

}
