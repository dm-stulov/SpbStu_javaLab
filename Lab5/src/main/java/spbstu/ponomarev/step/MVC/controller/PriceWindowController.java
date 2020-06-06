package spbstu.ponomarev.step.MVC.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import spbstu.ponomarev.step.MVC.model.Model;
import spbstu.ponomarev.step.MVC.model.component.Product;
import spbstu.ponomarev.step.MVC.model.repository.specification.ProductTitleSpecification;

import java.net.URL;
import java.util.ResourceBundle;

public class PriceWindowController extends BaseController implements Initializable {
  @FXML
  private Label titleLabel;

  @FXML
  private TextField priseField;

  private Product product;

  public PriceWindowController(Model model) throws Exception {
    super(model);
    product = model.getProduct();
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    priseField.setDisable(true);

    if (product == null) {
      titleLabel.setText("PRODUCT IS NOT EXISTS");
      priseField.setText("NOT AVAILABLE");
      return;
    }

    titleLabel.setText(product.getTitle());
    priseField.setText(Double.toString(product.getCost()));
  }

  @FXML
  void okButtonAction() {
    Stage stage = (Stage) titleLabel.getScene().getWindow();

    stage.close();
  }
}
