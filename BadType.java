package Calculator;

/**
 * This is class is made to allow the Entry class to use the BadType custom Exception.
 * 
 * @author Alin Mican ID:100947751
 *
 */
@SuppressWarnings("serial")
public class BadType extends Exception {

  /**
   * A constructor that takes a String to be able to display a custom message.
   * 
   * @param error_message This allows a custom message to be written.
   */
  public BadType(String error_message) {
    super(error_message);
  }

}
