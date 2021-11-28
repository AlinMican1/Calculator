package Calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This is the Standard Calculator class where it takes an infix string and uses shuting yard algorithm to produce a postfix notation
 * which is passed into the Reverve Polish Calculator to produce an answer. 
 * 
 * @author Alin Mican ID:100947751
 *
 */
public class StandardCalc {
/*
 * OpStack is a class called that pushes all the operators into a stack. 
 * RevPolishCalc is a class used for passing the postfix function which produces an answer.
 */
  private OpStack values = new OpStack();
  private RevPolishCalc rpCalc = new RevPolishCalc();

   
  /**
   * This class is used to turn a infix formula into a postfix notation by using shunting yard algorithm.
   * @param formula : Used to pass in a infix String.
   * @return returns the answer calling the reverse polish calculator.
   * @throws Exception There are serveral exceptions that are handled such as InvalidExpression (custom Exception) this is used 
   * for invalid expression such as if the user writes a postfix notation it should throw an exception because it's a infix calculator.
   * The second exception is a Empty Stack Exception used for the OpStack class in case the stack is empty.
   */
  public float evaluate(String formula) throws Exception {
/**
 * number_list
 */
    ArrayList<String> number_list = new ArrayList<String>();
    ArrayList<String> op_list = new ArrayList<String>();
    String regex = "(\\d+\\.\\d+)|(\\d+)|([+-/*///^])|([/(/)])";
    Matcher number_operators = Pattern.compile(regex).matcher(formula);
    ArrayList<String> list = new ArrayList<String>();
    
    while (number_operators.find()) {
      list.add(number_operators.group());

    }
    int count = 0;
    for (String token : list) {
      boolean number_is_next = false;

      if (token == " ") {
        throw new EmptyStackException();
      }

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

      if (token.equals("*") || token.equals("+") || token.equals("-") || token.equals("/")
          || token.equals("(") || token.equals(")")) {


        while (values.isEmpty() == false
            && getPrecedence(values.top().toString()) >= getPrecedence(token)) {
          number_list.add(values.pop().toString());

        }

      }
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

    for (int i = 0; i <= values.size(); i++) {

      number_list.add(values.pop().toString());
    }

    for (String token2 : op_list) {

      number_list.add(token2);
    }

    return rpCalc.evaluate(number_list.toString());
  }

  static int getPrecedence(String token) {
    if (token.equals("+") || token.equals("-")) {
      return 2;
    }
    if (token.equals("*") || token.equals("/")) {
      return 3;
    }

    return 0;

  }

  public static boolean isNumeric(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      Float number = Float.parseFloat(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

}


