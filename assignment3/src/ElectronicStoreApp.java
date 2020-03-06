/*
      Controller
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.input.*;

public class ElectronicStoreApp extends Application {
    ElectronicStore model;
    ElectronicStoreView view;

    public void start(Stage primaryStage) {
        model = ElectronicStore.createStore();
        view = new ElectronicStoreView(model);

        // Event handler for "add to cart" button
        view.getAddToCartButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleAddToCart();
            }
        });

        // Event handler for "remove from cart" button
        view.getRemoveFromCartButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleRemoveFromCart();
            }
        });

        // Event handler for "complete sale" button
        view.getCompleteSaleButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleCompleteSale();
            }
        });

        // Event handler for "reset" button
        view.getResetButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleReset(primaryStage);
            }
        });

        // Event handler for stock's ListView
        view.getStockList().setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                view.update();
            }
        });

        // Event handler for cart's ListView
        view.getCartList().setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                view.update();
            }
        });

        primaryStage.setTitle("Electronic Store Application - " + model.getName());
        primaryStage.setScene(new Scene(view, 800, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
        view.update();
    }

    public void handleAddToCart() {
        Product selection = view.getStockList().getSelectionModel().getSelectedItem();
        model.addToCart(selection);
        view.update();
    }

    public void handleRemoveFromCart() {
        Product selection = view.getCartList().getSelectionModel().getSelectedItem();
        model.removeFromCart(selection);
        view.update();
    }

    public void handleCompleteSale() {
        model.completeSale();
        view.update();
    }

    public void handleReset(Stage stage) {
        start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
