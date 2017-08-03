package net.neonstars.util;

/**
 * This class is an utility class.
 *
 * @author wintermaples
 */
public class Util {

  /**
   * If two number equals both allowing an specified tolerance, it returns true.
   *
   * @param num1 Number1
   * @param num2 Number2
   * @param tolerance tolerance
   * @return If two number equals both allowing an specified tolerance, it returns true.
   */
  public static boolean doubleEquals(double num1, double num2, double tolerance) {
    return num1 - tolerance <= num2 && num2 <= num1 + tolerance;
  }

}
