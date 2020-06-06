package spbstu.ponomarev.step.MVC.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import spbstu.ponomarev.step.MVC.model.Model;
import spbstu.ponomarev.step.MVC.model.repository.specification.ProductCostSpecification;

public class CostRangeWindowController extends BaseController {
  @FXML
  private TextField lowCostField;

  @FXML
  private TextField highCostField;

  public CostRangeWindowController(Model model) throws Exception {
    super(model);
  }

  @FXML
  void cancelButtonAction() {
    Stage stage = (Stage) lowCostField.getScene().getWindow();

    stage.close();
  }

  @FXML
  void executeButtonAction() {
    Stage stage = (Stage) lowCostField.getScene().getWindow();

    if (lowCostField.getText().isEmpty() || highCostField.getText().isEmpty()) {
      stage.close();
    }

    final double lowCost = Double.parseDouble(lowCostField.getText());
    final double highCost = Double.parseDouble(highCostField.getText());

    var costSpecification = new ProductCostSpecification(lowCost, highCost);

    model.loadProductList(costSpecification);

    stage.close();
  }
}
