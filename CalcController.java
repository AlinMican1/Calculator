package Calculator;

import java.util.EmptyStackException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class CalcController {
  private RevPolishCalc rpCalc = new RevPolishCalc();
  private StandardCalc StandardCalc = new StandardCalc();
  private StrStack StringStack = new StrStack();
  @FXML
  private Label answer;

  @FXML
  private RadioButton infix_button;

  @FXML
  private TextField input;

  @FXML
  private RadioButton rev_button;

  @FXML
  private ImageView viewimage;

  @FXML
  private ImageView viewimage1;

  @FXML
  private ToggleGroup FormulaType;// so that buttons are able to switch

  @FXML
  private Button P_button;

  @FXML
  void input_entered(ActionEvent event) throws Exception {

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
  @FXML
  void Button_Pressed(ActionEvent event) throws Exception {
    

      if (StringStack.isEmpty()) {
        answer.setText("No Formulas Available!");
      }else {
        input.setText(StringStack.pop());
      }

  
}
}


