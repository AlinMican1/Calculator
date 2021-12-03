package Calculator;

import java.util.EmptyStackException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * This is the controller using javafx with scenebuilder to make a GUI with buttons and input text.
 * 
 * @author Alin Mican ID:100947751
 * 
 */
public class CalcController {
  /**
   * Calling the classes that will be used to calculate the string the user will input.
   */
  private RevPolishCalc rpCalc = new RevPolishCalc();
  private StandardCalc StandardCalc = new StandardCalc();
  private StrStack StringStack = new StrStack();
  /**
   * These are the controlls imported from scenebuilder into javafx so we can manipulate the
   * buttons.
   */
  @FXML
  private Label answer;

  @FXML
  private RadioButton infix_button;

  @FXML
  private TextField input;

  @FXML
  private RadioButton rev_button;

  @FXML
  private ToggleGroup FormulaType;

  @FXML
  private Button P_button;

  /**
   * This method checks if there has been something inputted into the input box.
   * 
   * @param event : Checks if a string is in the input box.
   * @throws Exception : If no input is in the box.
   */
  @FXML
  void input_entered(ActionEvent event) throws Exception, InvalidExpression {
    /**
     * Checks what type of button is selected. if rev_button is selected perform reverse polish
     * calculation otherwise perform Standard calculation.
     */
    if (rev_button.isSelected()) {
      try {
        answer.setText(String.valueOf(rpCalc.evaluate(input.getText().toString())));
        StringStack.push(input.getText().toString());

      } catch (InvalidExpression e) {
        answer.setText("Please input a formula");
      } catch (EmptyStackException e) {
        answer.setText("Invalid Expression");
      }

      input.setText(null);
    }

    if (infix_button.isSelected()) {

      try {
        answer.setText(String.valueOf(StandardCalc.evaluate(input.getText().toString())));
        StringStack.push(input.getText().toString());

      } catch (InvalidExpression e) {
        answer.setText("Invalid Expression");
      } catch (EmptyStackException e) {
        answer.setText("Please input a formula");
      }

      input.setText(null);
    }

  }

  /**
   * This method is a button that checks if the button has been pressed if it has pop the string
   * from StrStack into the input box otherwise if it's empty output into the result no formula
   * available.
   * 
   * @param event : checks if the button is pressed.
   * @throws Exception checks for empty stack exception.
   */
  @FXML
  void Button_Pressed(ActionEvent event) throws Exception {


    if (StringStack.isEmpty()) {
      answer.setText("No Formulas Available!");
    } else {
      input.setText(StringStack.pop());
    }


  }
}


