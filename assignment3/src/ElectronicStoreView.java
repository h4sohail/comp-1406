/*
      View
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class ElectronicStoreView extends Pane {
    // Labels;
    private Label sectionOne;
    private Label sectionOneSales;
    private Label sectionOneRevenue;
    private Label sectionOneSale;
    private Label sectionOneItems;
    private Label sectionTwo;
    private Label sectionThree;

    // Buttons
    private Button resetButton;
    private Button addToCartButton;
    private Button removeFromCartButton;
    private Button completeSaleButton;

    // Text Fields
    private TextField salesText;
    private TextField revenueText;
    ;
    private TextField saleText;

    // ListViews
    private ListView<Product> popularList = new ListView<Product>();
    private ListView<Product> stockList = new ListView<Product>();
    private ListView<Product> cartList = new ListView<Product>();

    // Model
    ElectronicStore model;

    public ElectronicStoreView(ElectronicStore initModel) {
        this.model = initModel;

        // Section one labels
        sectionOne = new Label("Store Summary");
        sectionOne.relocate(50, 20);
        sectionOneSales = new Label("# Sales");
        sectionOneSales.relocate(50, 60);
        sectionOneRevenue = new Label("Revenue");
        sectionOneRevenue.relocate(50, 100);
        sectionOneSale = new Label("$ / Sale");
        sectionOneSale.relocate(50, 140);
        sectionOneItems = new Label("Most Popular Items");
        sectionOneItems.relocate(50, 180);

        // Section one buttons
        resetButton = new Button("Reset Store");
        resetButton.relocate(70, 350);

        // Section one TextField
        salesText = new TextField("0");
        salesText.relocate(120, 60);
        salesText.setPrefSize(90, 20);
        salesText.setEditable(false);
        revenueText = new TextField("0.0");
        revenueText.relocate(120, 100);
        revenueText.setPrefSize(90, 20);
        revenueText.setEditable(false);
        saleText = new TextField("N/A");
        saleText.relocate(120, 140);
        saleText.setPrefSize(90, 20);
        saleText.setEditable(false);

        // Section one ListView
        popularList.relocate(50, 200);
        popularList.setPrefSize(125, 125);

        // Section two labels
        sectionTwo = new Label("Store Stock");
        sectionTwo.relocate(240, 20);

        // Section two buttons
        addToCartButton = new Button("Add to Cart");
        addToCartButton.relocate(325, 350);

        // Section two ListView

        stockList.relocate(240, 40);
        stockList.setPrefSize(250, 285);

        // Section three labels
        sectionThree = new Label(String.format("Current Cart ($ %.2f) ", model.getCartWorth()));
        sectionThree.relocate(500, 20);

        // Section three buttons
        removeFromCartButton = new Button("Remove from Cart");
        removeFromCartButton.relocate(500, 350);
        completeSaleButton = new Button("Complete Sale");
        completeSaleButton.relocate(658, 350);

        // Section three ListView
        cartList.relocate(500, 40);
        cartList.setPrefSize(250, 285);

        // Add labels to window
        getChildren().addAll(sectionOne, sectionOneSales, sectionOneRevenue, sectionOneSale, sectionOneItems, sectionTwo, sectionThree);

        // Add buttons to window
        getChildren().addAll(resetButton, addToCartButton, removeFromCartButton, completeSaleButton);

        // Add TextFields to window
        getChildren().addAll(salesText, revenueText, saleText);

        // Add ListViews to window
        getChildren().addAll(popularList, stockList, cartList);
    }

    // Getters
    public Button getResetButton() {
        return resetButton;
    }

    public Button getAddToCartButton() {
        return addToCartButton;
    }

    public Button getRemoveFromCartButton() {
        return removeFromCartButton;
    }

    public Button getCompleteSaleButton() {
        return completeSaleButton;
    }

    public ListView<Product> getStockList() {
        return stockList;
    }

    public ListView<Product> getCartList() {
        return cartList;
    }

    // To refresh and update the screen
    public void update() {
        // Update text
        sectionThree.setText(String.format("Current Cart ($ %.2f) ", model.getCartWorth()));
        salesText.setText(String.format("%d", model.getTotalSales()));
        revenueText.setText(String.format("%.2f", model.getRevenue()));

        double averageSale;
        if (model.getRevenue() == 0 && model.getTotalSales() == 0 | model.getTotalSales() == 0) {
            averageSale = 0.0;
        } else {
            averageSale = model.getRevenue() / model.getTotalSales();
        }
        saleText.setText(String.format("%.2f", averageSale));

        // Update ListViews
        ObservableList<Product> popularObservableList = FXCollections.observableArrayList(model.getPopular());
        popularList.setItems(popularObservableList);

        ObservableList<Product> stockObservableList = FXCollections.observableArrayList(model.getStockItems());
        stockList.setItems(stockObservableList);

        ObservableList<Product> stockCartObservableList = FXCollections.observableArrayList(model.getCartItems());
        cartList.setItems(stockCartObservableList);

        // Update buttons
        int addToCartSelect = stockList.getSelectionModel().getSelectedIndex();
        if (addToCartSelect == -1) {
            addToCartButton.setDisable(true);
        } else {
            addToCartButton.setDisable(false);
        }

        int removeFromCart = cartList.getSelectionModel().getSelectedIndex();
        if (removeFromCart == -1) {
            removeFromCartButton.setDisable(true);
        } else {
            removeFromCartButton.setDisable(false);
        }

        if (cartList.getItems().size() == 0) {
            completeSaleButton.setDisable(true);
        } else {
            completeSaleButton.setDisable(false);
        }
    }
}
