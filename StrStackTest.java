package Calculator;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * These are several tests in Junit that test the StrStack class methods.
 * 
 * @author Alin Mican ID:100947751
 *
 */
class StrStackTest {

  private StrStack StrStack_test;

  /**
   * The void setup method declares the StrStack class that is going to be used in the upcoming test
   * methods. This is done to not have repeating class declarations throughout the code.
   */
  @BeforeEach
  public void setup() {
    StrStack_test = new StrStack();
  }

  /**
   * Second test, testing the push method, by calling the isEmpty function which should return
   * false, as we have pushed something onto the stack.
   */
  @Test
  void testPush() {
    StrStack_test.push("Random");
    assertEquals(StrStack_test.isEmpty(), false,
        "Should be filled as im pushing a new Symbol in the Stack");
  }

  /**
   * Third test, Testing that the pop method works by pushing a certain string, then popping it.
   * 
   * @throws Exception is used in case there is nothing to pop.
   */
  @Test
  void testPop() throws Exception {
    StrStack_test.push("Random");
    assertEquals(StrStack_test.pop(), "Random", "Should pop the latest push in the stack.");
  }

  /**
   * First Test, used to check if the stack is empty, it should return true as there is nothing in
   * the stack.
   */
  @Test
  void testIsEmpty() {
    assertEquals(StrStack_test.isEmpty(), true, "Should be true as there is nothing in the stack");
  }

  /**
   * Fourth Test, Testing multiple pushed strings then popping them to check if the order is correct
   * and to check that in fact it can take multiple strings.
   * 
   * @throws Exception is used in case there is nothing to pop.
   */
  @Test
  void testMulitplePops() throws Exception {
    StrStack_test.push("Hey");
    StrStack_test.push("there");
    StrStack_test.push("!");
    assertEquals(StrStack_test.pop(), "!", "First pop");
    assertEquals(StrStack_test.pop(), "there", "Second pop");
    assertEquals(StrStack_test.pop(), "Hey", "Third pop");
  }

  /**
   * Fifth test, testing the pop exception to see that EmptyStackException is thrown if there is
   * nothing in the stack.
   * 
   * @throws Exception is used in case there is nothing to pop.
   */
  @Test
  void testPopException() throws Exception {
    assertThrows(EmptyStackException.class, () -> StrStack_test.pop(), "Stack is empty");

  }
}
