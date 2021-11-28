package Calculator;

import java.util.EmptyStackException;

/**
 * This is a operator stack that is used to push symbols on to a stack, returning the latest symbol
 * the user has written.
 * 
 * @author Alin Mican ID:100947751
 *
 */
public class OpStack {

  private Stack numStack = new Stack(); // Calling in the main Stack, this is a facade so we only
                                        // use symbols here!
  public int size = 0;// Size to keep track of the stack size.

  /**
   * Keeping track of the size of the stack.
   * 
   * @return returns a float value.
   */
  public int size() {
    return size;
  }

  /**
   * Pushing Symbol entries onto the stack increasing the size by one everytime we push something.
   * 
   * @param i : The actual Symbol value we are pushing onto the stack.
   */
  public void push(Symbol i) {

    numStack.push(new Entry(i));
    size += 1;

  }

  /**
   * This is used for returning the latest Symbol entry in the stack and decreases the size by 1
   * every "pop" call we make.
   * 
   * @return returns the latest Symbol that was put in the stack.
   * @throws Exception If the stack is empty and we want to see the latest symbol we can't since the
   *         stack is empty that is why we throw an Empty Stack Exception.
   */
  public Symbol pop() throws Exception {
    if (numStack.size() == 0) {
      throw new EmptyStackException();
    }
    size--;
    return numStack.pop().getSymbol();
  }

  /**
   * Checking the latest Symbol in the stack without decreasing the size.
   * 
   * @return returns the latest Symbol in the stack.
   * @throws Exception If the stack is empty and we want to see the latest symbol we can't since the
   *         stack is empty that is why we throw an Empty Stack Exception.
   */
  public Symbol top() throws Exception {
    if (numStack.size() == 0) {
      throw new EmptyStackException();
    }

    return numStack.top().getSymbol();
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
