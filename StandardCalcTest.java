package Calculator;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * These are several tests in Junit that test the StandardCalc class methods.
 * 
 * @author Alin Mican ID:100947751
 *
 */
class StandardCalcTest {
  private StandardCalc StandardC_Test;

  /**
   * The void setup method declares the NumStack class that is going to be used in the upcoming test
   * methods. This is done to not have repeating class declarations throughout the code.
   */
  @BeforeEach
  public void setup() {
    StandardC_Test = new StandardCalc();
  }

  /**
   * First Test, checking if the if + statments work.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testaddition() throws Exception {
    assertEquals(StandardC_Test.evaluate("2 + 2"), 4, "should be expecting 4.");
  }

  /**
   * Second Test, checking if the if / statments work.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testdivision() throws Exception {
    assertEquals(StandardC_Test.evaluate("54 / 9"), 6, "should be expecting 6.");
  }

  /**
   * Third Test, checking if the if * statments work.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testmultiply() throws Exception {
    assertEquals(StandardC_Test.evaluate("11 * 9"), 99, "should be expecting 99.");
  }

  /**
   * Fourth Test, checking if the if - statments work.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testsubtraction() throws Exception {
    assertEquals(StandardC_Test.evaluate("10 - 9"), 1, "should be expecting 1.");
  }

  /**
   * Fifth Test, checking if multiple operations can be done.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testmutipleoperands() throws Exception {
    assertEquals(StandardC_Test.evaluate("1 * 3 + 2 - 3 / 6"), 4.5, "should be expecting 4.5.");
  }

  /**
   * Sixth Test, checking if multiple operations can be done again.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testmutipleoperands2() throws Exception {
    assertEquals(StandardC_Test.evaluate("30 + 5 * 10 / 8 - 1"), 35.25,
        "should be expecting 35.25.");
  }

  /**
   * Seventh Test, checking if multiple operations can be done again.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testmutipleoperands3() throws Exception {
    assertEquals(StandardC_Test.evaluate("30 + 5 * 10 / 8 - 1 * 6"), 30.25,
        "should be expecting 30.25.");
  }

  /**
   * Eight Test, checking if multiple operations can be done again.
   * 
   * @throws Exception in case the formula is wrong or empty
   */
  @Test
  void testmutipleoperands4() throws Exception {
    assertEquals(StandardC_Test.evaluate("10 * 10 * 10 + 10000 + 1000000"), 1011000,
        "should be expecting 1011000.");
  }

  /**
   * Ninth Test, checks if there is a string passed in evaluate.
   * 
   * @throws Exception in case the formula is wrong or empty
   */
  @Test
  void testEmpty() throws Exception {
    assertThrows(EmptyStackException.class, () -> StandardC_Test.evaluate(" "),
        "It can't take an empty Stack");

  }

  /**
   * Tenth Test, check if the calculator can take a postfix notation, in this case the calculator
   * should only be able to take infix notations.
   * 
   * @throws Exception in case the formula is wrong or empty
   */
  @Test
  void testRevPolish() throws Exception {
    assertThrows(InvalidExpression.class, () -> StandardC_Test.evaluate(" 6 4 +"),
        "It can't take an revPolish as it's infix calculator");

  }

  /**
   * Eleventh test, check if it throws a invalid expression, even though at the begining of the
   * formula is infix but then is postfix notation, should still throw exception.
   * 
   * @throws Exception in case the formula is wrong or empty
   */
  @Test
  void testRevPolish2() throws Exception {
    assertThrows(InvalidExpression.class, () -> StandardC_Test.evaluate(" 6 + 4 3 /"),
        "It can't take an revPolish as it's infix calculator");

  }



}
