package spbstu.ponomarev.step.MVC.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import spbstu.ponomarev.step.MVC.controller.CostRangeWindowController;
import spbstu.ponomarev.step.MVC.controller.PriceWindowController;
import spbstu.ponomarev.step.MVC.model.Model;
import spbstu.ponomarev.step.Main;

public class ViewFactory {
  private ViewFactory() {}

  public static void showCostRangeWindow(Stage parent, Model model) throws Exception {
    FXMLLoader loader = new FXMLLoader(Main.class.getResource("costRangeWindow.fxml"));

    loader.setController(new CostRangeWindowController(model));

    var stage = createStage(loader);

    stage.setResizable(false);
    stage.setAlwaysOnTop(true);
    stage.initOwner(parent);
    stage.initStyle(StageStyle.UNDECORATED);
    stage.initModality(Modality.WINDOW_MODAL);

    stage.show();
  }

  public static void showPriceWindow(Stage parent, Model model) throws Exception {
    FXMLLoader loader = new FXMLLoader(Main.class.getResource("priceWindow.fxml"));

    loader.setController(new PriceWindowController(model));

    var stage = createStage(loader);

    stage.setResizable(false);
    stage.setAlwaysOnTop(true);
    stage.initOwner(parent);
    stage.initStyle(StageStyle.UNDECORATED);
    stage.initModality(Modality.WINDOW_MODAL);

    stage.show();
  }

  private static Stage createStage(FXMLLoader loader) throws Exception {
    var stage = new Stage();

    Scene scene = new Scene((Parent) loader.load());

    stage.setScene(scene);

    return stage;
  }
}
