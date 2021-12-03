package Calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the Reverse Polish Calculator class where it takes an postfix string and uses reverse
 * polish algorithm to calculate the postfix notation which returns the answer.
 * 
 * @author Alin Mican ID:100947751
 *
 */
public class RevPolishCalc {

  private NumStack values = new NumStack();

  /**
   * This class is used to take a postfix notation and use the reverse polish algorithm to calculate
   * it.
   * 
   * @param formula : Used to pass a potfix notation.
   * @return returns the numbers that are popped from the stack.
   * @throws Exception There are serveral exceptions that are handled such as InvalidExpression
   *         (custom Exception) this is used for invalid expression such as if the user writes a
   *         inifx notation it should throw an exception because it's a infix calculator. The second
   *         exception is a Empty Stack Exception used for the NumStack class in case the stack is
   *         empty. Also NumberFormatException is used if what we are trying to push into the
   *         NumStack is not a number.
   */
  public float evaluate(String formula) throws Exception, InvalidExpression {
    /*
     * Removing everything thats not a number or operator from the string formula
     */
    String regex = "(\\d+\\.\\d+)|(\\d+)|([+-/*///^])|([/(/)])";
    Matcher number_operators = Pattern.compile(regex).matcher(formula);

    /*
     * Turning the formula into a String array called list so that we can look at each index one by
     * one.
     */
    ArrayList<String> list = new ArrayList<String>();
    while (number_operators.find()) {
      list.add(number_operators.group());
    }

    /*
     * iterating through each index of the string array, and checking what type of string it is at
     * that index.
     */
    float numbers = 0;
    for (String token : list) {
      /*
       * try to turn the string into a number at push it into the stack, otherwise if is not a
       * number we catch the exception and move on to the next index.
       */
      try {
        numbers = Float.parseFloat(token);
        values.push(numbers);


      } catch (NumberFormatException e) {


      }
      /*
       * This is where we do the operations, e.g if the current index string is "+" we push the
       * answer to popping to values into the stack.
       */
      switch (token) {
        case "+":
          values.push((values.pop() + values.pop()));


          break;

        case "-":
          values.push(-values.pop() + values.pop());
          break;

        case "*":
          values.push(values.pop() * values.pop());

          break;

        case "/":
          float divisor = values.pop();
          values.push(values.pop() / divisor);
          break;

      }

    }
    /*
     * if the stack is empty throw exception.
     */
    if (values.isEmpty()) {
      throw new InvalidExpression("Please input a string!");
    }



    return values.pop();
  }
}


