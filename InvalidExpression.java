package Calculator;

/**
 * This is class is made to allow the calculator classes to use the Invalid Expression custom Exception.
 * 
 * @author Alin Mican ID:100947751
 *
 */
@SuppressWarnings("serial")
public class InvalidExpression extends Exception{
  
  public InvalidExpression(String error_message) {
    super(error_message);
  }
  
 

}
