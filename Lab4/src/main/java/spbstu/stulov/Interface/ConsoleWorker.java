package spbstu.stulov.Interface;

import spbstu.stulov.model.repository.specification.ProductEmptySpecification;
import spbstu.stulov.model.repository.specification.ProductTitleSpecification;
import spbstu.stulov.model.Model;
import spbstu.stulov.model.component.Product;
import spbstu.stulov.model.repository.specification.ProductCostSpecification;
import spbstu.stulov.model.repository.specification.ProductUpdateByCostSpecification;

public class ConsoleWorker {
    private boolean started;

    private Model model;

    private Command command;

    public ConsoleWorker(Model model) {
        this.command = new Command();
        this.model = model;
        this.started = true;
    }

    public void start() throws Exception {
        System.out.println("Лаболаторная работа 4");
        showInstructionList();

        while (this.started) {
            readCommand();
            handleCommand();
        }
    }

    private void readCommand() throws Exception {
        System.out.print("Input command: ");
        command.read();
    }

    private void handleCommand() {
        switch (command.getType()) {
            case ADD:
                handleAdd();
                break;
            case DELETE:
                handleDelete();
                break;
            case SHOW_ALL:
                handleShowAll();
                break;
            case PRICE:
                handleShowPrice();
                break;
            case CHANGE_PRICE:
                handleChangePrice();
                break;
            case FILTER_BY_PRICE:
                handleFilterByPrice();
                break;
            case EXIT:
                started = false;
                break;
            case ERROR:
                System.out.println("Invalid command.");
                break;
        }
    }

    private void handleAdd() {
        final String title = command.getComponents().get(1);
        final double cost = Double.parseDouble(command.getComponents().get(2));

        Product product = new Product(title, cost);

        model.addProduct(product);
    }

    private void handleDelete() {
        final String title = command.getComponents().get(1);

        var deleteByTitle = new ProductTitleSpecification(title);

        model.removeProduct(deleteByTitle);
    }

    private void handleShowAll() {
        var allProducts = new ProductEmptySpecification();

        model.loadProductList(allProducts);

        printProductList();
    }

    private void handleShowPrice() {
        final String title = command.getComponents().get(1);

        var getByTitle = new ProductTitleSpecification(title);

        model.loadProduct(getByTitle);

        printProduct();
    }

    private void handleChangePrice() {
        final String title = command.getComponents().get(1);
        final double newCost = Double.parseDouble(command.getComponents().get(2));

        var changeCostSpecification = new ProductUpdateByCostSpecification(title, newCost);

        model.updateProduct(changeCostSpecification);
    }

    private void handleFilterByPrice() {
        final double lowestCost = Double.parseDouble(command.getComponents().get(1));
        final double highestCost = Double.parseDouble(command.getComponents().get(2));

        if (lowestCost < highestCost || lowestCost < 0 || highestCost < 0) {
            System.err.println("Invalid values.");
            return;
        }

        var getByCost = new ProductCostSpecification(lowestCost, highestCost);

        model.loadProductList(getByCost);

        printProductList();
    }

    private void printProductList() {
        System.out.println("Product list:");

        var products = model.getProducts();

        for (var product : products) {
            System.out.println(product.toString());
        }

        System.out.println();
    }

    private void printProduct() {
        final Product product = model.getProduct();

        if (product == null) {
            System.out.println("Product doesn't exist.");
        } else {
            System.out.println(product.toString());
        }
    }

    private void showInstructionList() {
        System.out.println("\\add product cost");
        System.out.println("\\delete product");
        System.out.println("\\show_all");
        System.out.println("\\price product");
        System.out.println("\\change_price product new_cost");
        System.out.println("\\filter_by_price lowest_cost highest_cost");
        System.out.println("\\exit");
    }
}
