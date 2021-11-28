package Calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;


/**
 * This is a stack class that has several functions to allow the user's entries to be executed
 * accordingly. to the method.
 * 
 * @author Alin Mican ID:100947751
 *
 */
public class Stack {

  /**
   * Variable "entries" of type "List", this allows to add entries to a list.
   */
  public ArrayList<Entry> entries = new ArrayList<Entry>();
  /**
   * Variable "size" of type "integer", this allows to keep track of the size of the stack.
   */
  public int size = 0;

  /**
   * This is an integer type method that returns the size of the stack, this depends on how many
   * entries are in the stack.
   * 
   * @return
   */
  public int size() {
    return size;
  }

  /**
   * This method "pushes" the Entry the user has entered, by using a parameter "i" of type "Entry"
   * this allows the user to add a entry that adds it to a LinkedList called "entries"
   * 
   * @param i This allows the user to input an element "i" of type "Entry".
   */
  public void push(Entry i) {
    if (entries.add(i)) {
      size += 1;
    }

  }

  /**
   * This method allows the user see what it is in the latest entry and removes it.
   * 
   * @return This returs the latest entry.
   * @throws Exception This exception is thrown when the size of the stack is empty, throwing an
   *         "EmptyStackException".
   */
  public Entry pop() throws Exception {
    if (size == 0) {
      throw new EmptyStackException();
    }
    size = size - 1;
    Entry retrieve = entries.remove(size);
    return retrieve;
  }

  /**
   * This method allows the user to see the top entry, without removing anything from the stack.
   * 
   * @return This returns the latest/top entry of the stack.
   * @throws Exception It throws an exception if the stack is empty, as there will be no top to
   *         return.
   */
  public Entry top() throws Exception {
    if (size == 0) {
      throw new EmptyStackException();
    }

    return entries.get(size - 1);
  }
  
 
}
