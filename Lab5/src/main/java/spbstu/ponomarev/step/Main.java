package spbstu.ponomarev.step;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import spbstu.ponomarev.step.MVC.controller.MainWindowController;
import spbstu.ponomarev.step.MVC.model.Model;

import java.io.IOException;

/**
 * JavaFX Main
 */
public class Main extends Application {

  private static Scene scene;

  @Override
  public void start(Stage stage) throws IOException {
    try {
      Model model = new Model();

      FXMLLoader loader = new FXMLLoader(Main.class.getResource("mainWindow.fxml"));
      loader.setController(new MainWindowController(model));

      stage.setScene(new Scene(loader.load()));
      stage.setResizable(false);
      stage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch();
  }
}