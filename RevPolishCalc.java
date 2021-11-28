package Calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author alinf
 *
 */
public class RevPolishCalc {

  private NumStack values = new NumStack();
  
  /**
   * 
   * @param formula
   * @return
   * @throws Exception
   */
  public float evaluate(String formula) throws Exception {

    String regex = "(\\d+\\.\\d+)|(\\d+)|([+-/*///^])|([/(/)])";
    Matcher number_operators = Pattern.compile(regex).matcher(formula);

    ArrayList<String> list = new ArrayList<String>();
    while (number_operators.find()) {
      list.add(number_operators.group());
    }
    

      float numbers = 0;
      for (String token : list) {

        try {
          numbers = Float.parseFloat(token);
          values.push(numbers);
         

        } catch (NumberFormatException e) {

        }

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
      
      if (values.isEmpty()) {
        throw new InvalidExpression("Please input a string!");
      }
      
      

    
    return values.pop();
  }
}


