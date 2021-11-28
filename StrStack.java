package Calculator;

import java.util.EmptyStackException;

/**
 * This is a string stack that is used for pushing strings onto a stack that will be used for
 * returning latest string that the user has written in the calculator.
 * 
 * @author Alin Mican ID:100947751
 *
 */
public class StrStack {

  private Stack StrStack = new Stack(); // Calling in the main Stack, this is a facade so we only
                                        // use strings here!

  /**
   * Pushing String entries onto a stack.
   * 
   * @param str : This is the string we are actually pushing.
   */
  public void push(String str) {
    StrStack.push(new Entry(str));

  }

  /**
   * This is used for returning the latest string entry in the stack.
   * 
   * @return returns the latest string that was put in the stack.
   * @throws Exception If the stack is empty and we want to see the latest string we can't since the
   *         stack is empty that is why we throw an Empty Stack Exception.
   */
  public String pop() throws Exception {
    if (StrStack.size() == 0) {
      throw new EmptyStackException();
    }
    return StrStack.pop().getString();
  }

  /**
   * Checks if the stack is empty.
   * 
   * @return return true if the stack is empty.
   */
  public boolean isEmpty() {
    return StrStack.size() == 0;
  }



}
