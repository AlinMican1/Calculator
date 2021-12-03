package Calculator;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is a Junit test class, that allows to test various method within the stack class.
 * 
 * @author Alin Mican ID:100947751
 *
 */
class StackTest {

  private Stack stack_test;
  private Entry entry_test;
  private Entry entry_test2;
  private Entry entry_test3;

  /**
   * The void setup method declares all the stack and Entry class that are going to be used in the
   * upcoming test methods. This is done to not have repeating class declarations throughout the
   * code.
   */
  @BeforeEach
  public void setup() {
    stack_test = new Stack();
    entry_test = new Entry("testing");
    entry_test2 = new Entry(234.45f);
    entry_test3 = new Entry(Symbol.MINUS);
  }

  /**
   * This tests the push method but pushing an entry and checking the size of the stack.
   */
  @Test
  void testPush() {
    stack_test.push(entry_test);
    assertEquals(stack_test.size(), 1, "Push new entry increasing the size by 1.");

  }

  /**
   * This checks the integer value of the method "size", should return zero as nothing has been
   * pushed.
   */
  @Test
  void testSize() {
    assertEquals(stack_test.size(), 0, "Check size");
  }

  /**
   * This method checks the size after multiple entries have been pushed.
   */
  @Test
  void testSizePushing() {
    stack_test.push(entry_test);
    stack_test.push(entry_test2);
    stack_test.push(entry_test3);
    assertEquals(stack_test.size(), 3, "Check size, after multiple entries have been pushed");
  }

  /**
   * Checks if an entry can be popped.
   * 
   * @throws Exception This throws an exception as the stack could be empty so there is nothing to
   *         be popped.
   */
  @Test
  void testPopException() throws Exception {
    assertThrows(EmptyStackException.class, () -> stack_test.pop(), "Stack is empty");

  }

  /**
   * This tests if the latest added entry in the stack is the same value as the pop method.
   * 
   * @throws Exception This throws an exception in case the stack is empty.
   */
  @Test
  void testPop() throws Exception {
    stack_test.push(entry_test);
    assertEquals(stack_test.pop(), entry_test);
  }

  /**
   * This tests the top method by returning the latest entry in the stack.
   * 
   * @throws Exception Throws exception in case the stack is empty.
   */
  @Test
  void testTop() throws Exception {
    stack_test.push(entry_test);
    stack_test.push(entry_test2);
    stack_test.push(entry_test3);
    assertEquals(stack_test.top().getSymbol(), Symbol.MINUS,
        "Test the top stack is the same as Symbol.MINUS.");
    assertEquals(stack_test.top().getSymbol(), Symbol.MINUS,
        "Test again that the top value is still the same.");
    assertNotSame(stack_test.top().getSymbol(), "testing",
        "Checking that the top entry is not the same as other entries in the stack");


  }

  /**
   * This is to test the exception in the top method.
   * 
   * @throws Exception Should throw an empty stack exception as there is nothing in the stack.
   */
  @Test
  void testTopException() throws Exception {
    assertThrows(EmptyStackException.class, () -> stack_test.top(), "Stack is empty");
  }

  /**
   * This tests the push and pop method, by pushing multiple entries and the pop returning the
   * latest entry and removing it by decreasing the size of it.
   * 
   * @throws Exception throws exception in case the stack is empty.
   */
  @Test
  void PushandPop() throws Exception {
    stack_test.push(entry_test);
    stack_test.push(entry_test2);
    stack_test.push(entry_test3);
    assertEquals(stack_test.pop().getSymbol(), Symbol.MINUS,
        "Test the top stack is the same as Symbol.MINUS.");
    assertEquals(stack_test.size(), 2,
        "Test that the size has gone down once pop function has been called.");
    assertEquals(stack_test.pop().getValue(), 234.45f);
    assertEquals(stack_test.size(), 1,
        "Test that the size has gone down once pop function has been called.");
    assertEquals(stack_test.pop().getString(), "testing", "Getting the last Entry in the stack");
    assertEquals(stack_test.size(), 0,
        "Test that the size has gone down once pop function has been called.");
    assertThrows(EmptyStackException.class, () -> stack_test.pop(), "Stack is empty");

  }



}
