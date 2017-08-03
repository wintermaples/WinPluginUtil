package net.neonstars.util.command;

/**
 * This class contains a pattern of command.
 *
 * @author wintermaples
 */
public class CmdPattern {

  /**
   * Command pattern.
   */
  protected String[] pattern;

  public CmdPattern(String pattern) {
    if (pattern.equals(""))
      this.pattern = new String[0];
    else
      this.pattern = pattern.split(" ");
  }

  public boolean match(String[] args) {
    if (pattern.length > args.length)
      return false;

    for (int i = 0; i < pattern.length; i++) {
      if (pattern[i].equals("any"))
        continue;
      if (!pattern[i].equals(args[i]))
        return false;
    }
    return true;
  }

  public boolean firstMatch(String[] args) {
    return args.length != 0 && args[0].equals(pattern[0]);
  }

}
