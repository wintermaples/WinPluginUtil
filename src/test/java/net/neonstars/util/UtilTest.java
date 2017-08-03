package net.neonstars.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wintermaples
 */
public class UtilTest {

  public UtilTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of doubleEquals method, of class Util.
   */
  @Test
  public void testDoubleEquals() {
    System.out.println("doubleEquals");
    //true pattern
    for (int i = -10; i < 11; i++) {
      double num1 = 10000.0;
      double num2 = 10000.0 + (i / 10d);
      double allowable_error = 1.0;
      boolean expResult = true;
      boolean result = Util.doubleEquals(num1, num2, allowable_error);
      assertEquals(expResult, result);
    }
    
    //false pattern
    for (int i = -20; i < -10; i++) {
      double num1 = 10000.0;
      double num2 = 10000.0 + (i / 10d);
      double allowable_error = 1.0;
      boolean expResult = false;
      boolean result = Util.doubleEquals(num1, num2, allowable_error);
      assertEquals(expResult, result);
    }
    for (int i = 11; i < 21; i++) {
      double num1 = 10000.0;
      double num2 = 10000.0 + (i / 10d);
      double allowable_error = 1.0;
      boolean expResult = false;
      boolean result = Util.doubleEquals(num1, num2, allowable_error);
      assertEquals(expResult, result);
    }
  }

}
