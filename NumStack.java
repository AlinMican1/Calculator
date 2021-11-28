package Calculator;

import java.util.EmptyStackException;

/**
 * This is a number stack that is used to push floats on to a stack, returning the latest number the
 * user has written.
 * 
 * @author Alin Mican ID:100947751
 *
 */
public class NumStack {
  private Stack numStack = new Stack();// Calling in the main Stack, this is a facade so we only
  // use floats here!

  /**
   * Pushing float entries onto the stack.
   * 
   * @param i : The actual float value we are pushing onto the stack.
   */
  public void push(float i) {
    numStack.push(new Entry(i));

  }

  /**
   * This is used for returning the latest float entry in the stack.
   * 
   * @return returns the latest float that was put in the stack.
   * @throws Exception If the stack is empty and we want to see the latest float we can't since the
   *         stack is empty that is why we throw an Empty Stack Exception.
   */
  public float pop() throws Exception {
    if (numStack.size() == 0) {
      throw new EmptyStackException();
    }
    return numStack.pop().getValue();
  }

  /**
   * Checks if the stack is empty
   * 
   * @return return true if the stack is empty.
   */
  public boolean isEmpty() {
    return numStack.size() == 0;
  }

}
