package Calculator;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpStackTest {
  /**
   * These are several tests in Junit that test the OpStack class methods.
   * 
   * @author Alin Mican ID:100947751
   *
   */
  private OpStack OpStack_test;

  /**
   * The void setup method declares the NumStack class that is going to be used in the upcoming test
   * methods. This is done to not have repeating class declarations throughout the code.
   */
  @BeforeEach
  public void setup() {
    OpStack_test = new OpStack();
  }

  /**
   * Second test, testing the push method, by calling the isEmpty function which should return
   * false, as we have pushed something onto the stack.
   */
  @Test
  void testPush() {
    OpStack_test.push(Symbol.MINUS);
    assertEquals(OpStack_test.isEmpty(), false,
        "Should be filled as im pushing a new Symbol in the Stack");// First test, testing the push
                                                                    // method

  }

  /**
   * Third test, Testing that the pop method works by pushing a certain symbol, then popping it.
   * 
   * @throws Exception is used in case there is nothing to pop.
   */

  @Test
  void testPop() throws Exception {
    OpStack_test.push(Symbol.TIMES);
    assertEquals(OpStack_test.pop(), Symbol.TIMES, "Should pop the latest push in the stack.");
  }

  /**
   * First Test, used to check if the stack is empty, it should return true as there is nothing in
   * the stack.
   */
  @Test
  void testIsEmpty() {
    assertEquals(OpStack_test.isEmpty(), true,
        "Should return true as there is nothing in the stack.");

  }

  /**
   * Fourth Test, Testing multiple pushed symbols then popping them to check if the order is correct
   * and to check that in fact it can take multiple symbols.
   * 
   * @throws Exception is used in case there is nothing to pop.
   */
  @Test
  void testMultiplePops() throws Exception {
    OpStack_test.push(Symbol.MINUS);
    OpStack_test.push(Symbol.PLUS);
    OpStack_test.push(Symbol.LEFT_BRACKET);
    assertEquals(OpStack_test.pop(), Symbol.LEFT_BRACKET,
        "Should pop the latest push in the stack.");
    assertEquals(OpStack_test.pop(), Symbol.PLUS, "Should pop the latest push in the stack.");
    assertEquals(OpStack_test.pop(), Symbol.MINUS, "Should pop the latest push in the stack.");
  }

  /**
   * Fifth test, testing the pop exception to see that EmptyStackException is thrown if there is
   * nothing in the stack.
   * 
   * @throws Exception is used in case there is nothing to pop.
   */
  @Test
  void testPopException() throws Exception {
    assertThrows(EmptyStackException.class, () -> OpStack_test.pop(), "Stack is empty");

  }

  @Test
  void testtop() throws Exception {
    OpStack_test.push(Symbol.MINUS);
    OpStack_test.push(Symbol.PLUS);
    OpStack_test.push(Symbol.LEFT_BRACKET);
    assertEquals(OpStack_test.top(), Symbol.LEFT_BRACKET,
        "The top should be Left_Bracket as it was the last push");
    assertEquals(OpStack_test.top(), Symbol.LEFT_BRACKET,
        "The top should still be Left_Bracket as it was the last push and it does not remove it");// Last
                                                                                                  // test

  }
}
