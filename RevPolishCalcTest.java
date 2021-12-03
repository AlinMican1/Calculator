package Calculator;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * These are several tests in Junit that test the RevPolishCalc class methods.
 * 
 * @author Alin Mican ID:100947751
 *
 */
class RevPolishCalcTest {

  private RevPolishCalc RevPolish_test;

  /**
   * The void setup method declares the NumStack class that is going to be used in the upcoming test
   * methods. This is done to not have repeating class declarations throughout the code.
   */
  @BeforeEach
  public void setup() {
    RevPolish_test = new RevPolishCalc();
  }

  /**
   * First Test, checking if the if + statments work.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testplus() throws Exception {
    assertEquals(RevPolish_test.evaluate("6 4 +"), 10, "should be expecting 10.");
  }

  /**
   * Second Test, checking if the if - statments work.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testminus() throws Exception {
    assertEquals(RevPolish_test.evaluate("6 4 -"), 2, "should be expecting 2.");
  }

  /**
   * Third Test, checking if the if * statments work.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testmultiply() throws Exception {
    assertEquals(RevPolish_test.evaluate("6 4 *"), 24, "should be expecting 24.");
  }

  /**
   * Foruth Test, checking if the if / statments work.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testdivision() throws Exception {
    assertEquals(RevPolish_test.evaluate("6 3 /"), 2, "should be expecting 2.");
  }

  /**
   * Fifth Test, checking if multiple operations can be done.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testmultipleoperands() throws Exception {
    assertEquals(RevPolish_test.evaluate("3 2 + 5 * 4 *"), 100, "should be expecting 100.");
  }

  /**
   * Sixth Test, checking if multiple operations can be done again.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testmultipleoperands2() throws Exception {
    assertEquals(RevPolish_test.evaluate("6 4 5 + * 5 - 2 3 + /"), 9.8f,
        "should be expecting 9.8.");
  }

  /**
   * Seventh Test, checks if there is a string passed in evaluate.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testempty() throws Exception {
    assertThrows(InvalidExpression.class, () -> RevPolish_test.evaluate(" "), "Its empty");

  }

  /**
   * Eigth Test, checking if double digits can be passed.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testdoubledigits() throws Exception {
    assertEquals(RevPolish_test.evaluate("21 7 /"), 3, "should be expecting 3.");
  }

  /**
   * Ninth Test, checking if double digits can be passed, with multiple operations.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testdoubledigits2() throws Exception {
    assertEquals(RevPolish_test.evaluate("6 4 5 + * 25 2 3 + / -"), 49, "should be expecting 49.");
  }

  /**
   * Tenth Test, checking if spaces does not affect the equation.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testNoSpace() throws Exception {
    assertEquals(RevPolish_test.evaluate("6 4 5 +* 25 2 3 +/-"), 49, "should be expecting 49.");
  }

  /**
   * eventh Test, checks if there is a infix notatio passed in evaluate, it should give an exception
   * as is not a postfix notation.
   * 
   * @throws Exception in case the formula is wrong or empty.
   */
  @Test
  void testinfix() throws Exception {
    assertThrows(EmptyStackException.class, () -> RevPolish_test.evaluate(" 6 + 4 - 2 / 6"),
        "It can't take an infix as it's empty");

  }



}


