package spbstu.ponomarev.step.MVC.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import spbstu.ponomarev.step.MVC.model.Model;
import spbstu.ponomarev.step.MVC.model.component.Product;
import spbstu.ponomarev.step.MVC.model.repository.specification.ProductEmptySpecification;
import spbstu.ponomarev.step.MVC.model.repository.specification.ProductTitleSpecification;
import spbstu.ponomarev.step.MVC.model.repository.specification.ProductUpdateByCostSpecification;
import spbstu.ponomarev.step.MVC.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {
  @FXML
  private TextField titleField;

  @FXML
  private TextField costField;

  @FXML
  private SplitMenuButton executeButton;

  @FXML
  private SplitMenuButton showButton;

  @FXML
  private MenuItem showAllButtonAction;

  @FXML
  private MenuItem showByCostButtonAction;

  @FXML
  private ListView<Product> productList;

  public MainWindowController(Model model) throws Exception {
    super(model);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    addButtonAction();
    showAllButtonAction();
    productList.setEditable(false);
  }

  @FXML
  void addButtonAction() {
    executeButton.setText("Add");

    costField.setDisable(false);
    costField.clear();

    executeButton.setOnAction(e -> {
      if (titleField.getText().isEmpty() || costField.getText().isEmpty()) {
       return;
      }

      final String title = titleField.getText();
      final double cost = Double.parseDouble(costField.getText());

      Product product = new Product(title, cost);
      model.addProduct(product);
    });
  }

  @FXML
  void changeCostButtonAction() {
    executeButton.setText("Change Cost");

    costField.setDisable(false);
    costField.clear();

    executeButton.setOnAction(e -> {
      if (titleField.getText().isEmpty() || costField.getText().isEmpty()) {
        return;
      }

      final String title = titleField.getText();
      final double cost = Double.parseDouble(costField.getText());

      var updateSpecification = new ProductUpdateByCostSpecification(title, cost);

      model.updateProduct(updateSpecification);
    });
  }

  @FXML
  void removeButtonAction() {
    executeButton.setText("Remove");

    costField.setDisable(true);
    costField.setText("UNAVAILABLE");

    executeButton.setOnAction(e -> {
      if (titleField.getText().isEmpty()) {
        return;
      }

      final String title = titleField.getText();

      var deleteSpecification = new ProductTitleSpecification(title);

      model.removeProduct(deleteSpecification);
    });
  }

  @FXML
  void showPriceButtonAction() {
    executeButton.setText("Show Price");

    costField.setDisable(true);
    costField.setText("UNAVAILABLE");

    var specification = new ProductTitleSpecification(titleField.getText());
    model.loadProduct(specification);

    executeButton.setOnAction(e -> {
      try {
        if (titleField.getText().isEmpty()) {
          return;
        }

        Stage stage = (Stage) showButton.getScene().getWindow();
        ViewFactory.showPriceWindow(stage, model);
      } catch (Exception exception) {
        exception.printStackTrace();
      }
    });

  }

  @FXML
  void showAllButtonAction() {
    showButton.setText("Show All");

    showButton.setOnAction(e -> {
      var allProductsSpecification = new ProductEmptySpecification();

      model.loadProductList(allProductsSpecification);

      setProductList();
    });
  }

  @FXML
  void showByCostButtonAction() {
    showButton.setText("Show By Cost");

    try {
      Stage stage = (Stage) showButton.getScene().getWindow();
      ViewFactory.showCostRangeWindow(stage, model);
    } catch (Exception exception) {
      exception.printStackTrace();
    }

    showButton.setOnAction(e -> {
      setProductList();
    });
  }

  private void setProductList() {
    ObservableList observableList = productList.getItems();

    observableList.clear();
    observableList.addAll(model.getProducts());

    productList.setItems(observableList);
  }
}
