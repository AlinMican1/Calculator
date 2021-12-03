package Calculator;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * These are several tests in Junit that test the NumStack class methods.
 * 
 * @author Alin Mican ID:100947751
 *
 */
class NumStackTest {
  private NumStack NumStack_test;

  /**
   * The void setup method declares the NumStack class that is going to be used in the upcoming test
   * methods. This is done to not have repeating class declarations throughout the code.
   */
  @BeforeEach
  public void setup() {
    NumStack_test = new NumStack();
  }

  /**
   * Second test, testing the push method, by calling the isEmpty function which should return
   * false, as we have pushed something onto the stack.
   */
  @Test
  void push() {
    NumStack_test.push(12.4f);
    assertEquals(NumStack_test.isEmpty(), false, "Should be false as i am pushing a float value");
  }

  /**
   * Third test, Testing that the pop method works by pushing a certain float, then popping it.
   * 
   * @throws Exception is used in case there is nothing to pop.
   */
  @Test
  void testPop() throws Exception {
    NumStack_test.push(12.4f);
    assertEquals(NumStack_test.pop(), 12.4f);
  }

  /**
   * Fourth Test, Testing multiple pushed floats then popping them to check if the order is correct
   * and to check that in fact it can take multiple floats.
   * 
   * @throws Exception is used in case there is nothing to pop.
   */
  @Test
  void testMultiplePops() throws Exception {
    NumStack_test.push(12.4f);
    NumStack_test.push(69.69f);
    NumStack_test.push(234.554365f);
    assertEquals(NumStack_test.pop(), 234.554365f, "First pop");
    assertEquals(NumStack_test.pop(), 69.69f, "Second pop");
    assertEquals(NumStack_test.pop(), 12.4f, "Third pop");
  }

  /**
   * First Test, used to check if the stack is empty, it should return true as there is nothing in
   * the stack.
   */
  @Test
  void isEmpty() {
    assertEquals(NumStack_test.isEmpty(), true, "The Stack is empty");
  }

  /**
   * Fifth test, testing the pop exception to see that EmptyStackException is thrown if there is
   * nothing in the stack.
   * 
   * @throws Exception is used in case there is nothing to pop.
   */
  @Test
  void testPopException() throws Exception {
    assertThrows(EmptyStackException.class, () -> NumStack_test.pop(), "Stack is empty");

  }

}
