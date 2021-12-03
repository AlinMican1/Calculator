package Calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the Standard Calculator class where it takes an infix string and uses shuting yard
 * algorithm to produce a postfix notation which is passed into the Reverve Polish Calculator to
 * produce an answer.
 * 
 * @author Alin Mican ID:100947751
 *
 */
public class StandardCalc {
  /*
   * OpStack is a class called that pushes all the operators into a stack. RevPolishCalc is a class
   * used for passing the postfix function which produces an answer.
   */
  private OpStack values = new OpStack();
  private RevPolishCalc rpCalc = new RevPolishCalc();


  /**
   * This class is used to turn a infix formula into a postfix notation by using shunting yard
   * algorithm.
   * 
   * @param formula : Used to pass in a infix String.
   * @return returns the answer calling the reverse polish calculator.
   * @throws Exception There are serveral exceptions that are handled such as InvalidExpression
   *         (custom Exception) this is used for invalid expression such as if the user writes a
   *         postfix notation it should throw an exception because it's a infix calculator. The
   *         second exception is a Empty Stack Exception used for the OpStack class in case the
   *         stack is empty.
   */
  public float evaluate(String formula) throws Exception {
    /**
     * Removing everything thats not a number or operator from the string formula
     */
    String regex = "(\\d+\\.\\d+)|(\\d+)|([+-/*///^])|([/(/)])";
    Matcher number_operators = Pattern.compile(regex).matcher(formula);

    ArrayList<String> number_list = new ArrayList<String>();
    ArrayList<String> op_list = new ArrayList<String>();
    ArrayList<String> list = new ArrayList<String>();
    /**
     * Convert the formula string into an array string called list, this is done so we can iterate
     * thorugh each index.
     */
    while (number_operators.find()) {
      list.add(number_operators.group());

    }
    /**
     * Added a int count so we know when we reach the end of the iteration.
     */
    int count = 0;
    /**
     * For loop goes thorough the list array checking if is a number or an operator.
     */
    for (String token : list) {
      /**
       * this boolean checks if the next index is a numeber, checking if is a postfix notation.
       */
      boolean number_is_next = false;

      if (token == " ") {
        throw new EmptyStackException();
      }
      /**
       * We check if the current index is a number and the next is also a number, if it is a number
       * we throw a invalid expression otherwise we carry on through the iteration.
       */
      if (count == 1) {
        if (isNumeric(token) == false) {
          number_is_next = false;
          count--;

        } else if (isNumeric(token) == true) {
          number_is_next = true;
          count = 0;
        }
      }

      if (number_is_next == true) {
        throw new InvalidExpression("Invalid Expression");
      }
      /**
       * checking if the current index is a operator, if it is we check the precedence of the
       * current operator, if the current operator has a higher precedence we add the operator to
       * the number_list otherwise carry on.
       */
      if (token.equals("*") || token.equals("+") || token.equals("-") || token.equals("/")
          || token.equals("(") || token.equals(")")) {


        while (values.isEmpty() == false
            && getPrecedence(values.top().toString()) >= getPrecedence(token)) {
          number_list.add(values.pop().toString());

        }

      }
      /**
       * We push into the OpStack only the operators.
       */
      switch (token) {

        case "+":
          values.push(Symbol.PLUS);
          break;

        case "-":
          values.push(Symbol.MINUS);
          break;

        case "*":
          values.push(Symbol.TIMES);
          break;

        case "/":
          values.push(Symbol.DIVIDE);
          break;

        default:
          number_list.add(token);

      }
      if (isNumeric(token) == true) {
        count += 1;
      }


    }
    /**
     * if there was no precedense swap made throughout the first iteration we just pop all the
     * values from the OpStack at the end of the first for loop, adding them into the number_list.
     */
    for (int i = 0; i <= values.size(); i++) {

      number_list.add(values.pop().toString());
    }
    /**
     * the values we added to the op_list we want to add them aswell into the number_list.
     */
    for (String token2 : op_list) {

      number_list.add(token2);
    }

    return rpCalc.evaluate(number_list.toString());
  }

  /**
   * This method is used to check the precedence of the symbol
   * 
   * @param token : we pass the operator.
   * @return : returns a integer that shows the precedence of the current symbol.
   */
  static int getPrecedence(String token) {
    if (token.equals("+") || token.equals("-")) {
      return 2;
    }
    if (token.equals("*") || token.equals("/")) {
      return 3;
    }

    return 0;

  }

  /**
   * Used to check if the current index is a number.
   * 
   * @param strNum : We pass a string so that we can check if it can be turned into a float.
   * @return : returns true or false if the string can be turned into a float.-
   */
  public static boolean isNumeric(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      Float.parseFloat(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

}


