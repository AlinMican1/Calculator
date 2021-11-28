package Calculator;

/**
 * This class gets the user's entries and returns it.
 * 
 * @author Alin Mican ID:100947751
 *
 */
public class Entry {

  /**
   * Variable Type: Float || Purpose: To allow the user to input a decimal number.
   */
  float value;
  /**
   * Variable Type: Symbol || Purpose: To allow the user to input a Symbol.
   */
  Symbol other;

  /**
   * Variable Type: String || Purpose: To allow the user to input a String.
   */
  String str;
  /**
   * Variable Type: Type || Purpose: To allow the user to input a type.
   */
  Type type;


  /**
   * A contructor that takes an object of type "float", sets the constructor's parameter "value" the
   * same as the variable "value".
   * 
   * @param value Purpose: To allow the user to input a decimal number.
   */
  public Entry(float value) {
    type = Type.NUMBER;
    this.value = value;
    
  }

  /**
   * A constructor that takes an object of type "Symbol", sets the constructor's parameter "other"
   * the same as the variable "other".
   * 
   * @param other Purpose: This allows the user to enter a mathematical symbol to choose
   *        mathematical operation shall be performed, the Symbol type has been constructed as a
   *        enum.
   */
  public Entry(Symbol other) {
    type = Type.SYMBOL;
    this.other = other;
  }

  /**
   * A constructor that takes an object of type "String", sets the constructor's parameter "str" the
   * same as the variable "str".
   * 
   * @param str Purpose: This allows the use to input a string.
   */
  public Entry(String str) {
    type = Type.STRING;
    this.str = str;
  }

  /**
   * A method of type "Type" that returns the type.
   * 
   * @return returns a type enum.
   */
  public Type getType() {
    return type;
  }

  /**
   * A method of type "String" that throws a custom exception. The if statement checks if the str
   * variable is not of type String, which throws the BadType custom exception if is true.
   * 
   * 
   * @return Returns the "str" variable if it is of type String.
   * @throws BadType This is a custom Exception as mentioned before.
   */
  public String getString() throws BadType {
    if (type != Type.STRING) {
      throw new BadType("Wrong input");
    }
    return this.str;
  }

  /**
   * A method of type "Symbol" that throws a custom exception. The if statement checks if the other
   * variable is not of type Symbol, which throws the BadType custom exception if is true.
   * 
   * 
   * @return Returns the "other" variable if it is of type Symbol.
   * @throws BadType This is a custom Exception as mentioned before.
   */
  public Symbol getSymbol() throws BadType {
    if (type != Type.SYMBOL) {
      throw new BadType("Wrong input");
    }
    return this.other;
  }

  /**
   * A method if type "float" that throws a custom exception. The if statement checks if the value
   * variable is not of type float, which throws the BadType custom exception if is true.
   * 
   * 
   * @return Returns the "value" variable if it is of type float.
   * @throws BadType This is a custom Exception as mentioned before.
   */
  public float getValue() throws BadType {
    if (type != Type.NUMBER) {
      throw new BadType("Wrong input");
    }
    return this.value;
  }

  /**
   * This method overrides the equals method to allow the entries to know when value and type are
   * the same, they are equal.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Entry)) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    try {
      return this.getValue() == ((Entry) obj).getValue();
    } catch (BadType e) {
      e.printStackTrace();
    }
    return this.getType() == ((Entry) obj).getType();
  }

}


