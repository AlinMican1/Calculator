package Calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is used to intiate/ start the GUI for the calculator
 * 
 * @author Alin Mican ID:100947751
 *
 */
public class Calculator extends Application {
  /**
   * This is the main class where it links everything toghether to run.
   * 
   * @param args : it is used to launch the GUI.
   */
  public static void main(String[] args) {
    launch(args);
  }


  @Override
  /**
   * This is used to start the CalcController class and sets a windows size.
   */
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/CalcController.fxml"));
    Scene scene = new Scene(root, 600, 400);
    primaryStage.setScene(scene);
    primaryStage.show();



  }

}
