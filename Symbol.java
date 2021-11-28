package Calculator;


/**
 * This is an enum type class that creates the necessary Symbols that the calculator will use.
 * 
 * @author Alin Mican ID:100947751
 *
 */
public enum Symbol {
  /**
   * Assignes left bracket to the symbol "(".
   */
  LEFT_BRACKET("("),
  /**
   * Assignes right bracket to the symbol ")".
   */
  RIGHT_BRACKET(")"),
  /**
   * Assignes times to the symbol "*".
   */
  TIMES("*"),
  /**
   * Assignes divide to the symbol "/".
   */
  DIVIDE("/"),
  /**
   * Assignes plus to the symbol "+".
   */
  PLUS("+"),
  /**
   * Assignes minus to the symbol "-".
   */
  MINUS("-"),
  /**
   * Assignes invalid to the symbol "!".
   */
  INVALID("!");

  /**
   * A private variable that takes a String used to set the symbol to the name corresponding to that
   * enum
   */
  private final String sign;

  /**
   * Constructor that sets the parameter "sign" to the variable "sign".
   * 
   * @param sign Purpose: To override the name with the actual sign. e.g TIMES is assigned to *
   */
  Symbol(String sign) {
    this.sign = sign;
  }

  /**
   * Overriding the toString method to write the actual symbol.
   */
  @Override
  public String toString() {
    return this.sign;
  }

}

