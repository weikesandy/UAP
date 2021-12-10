package javafxapplication3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

 public class olshop extends Application {
     String name;
     
     public String getName() {
    return name;  
  }
     
  public void setName(String newName) {
    this.name = newName;
  }
  
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("");

        GridPane gridPane = createolshopPane();
        addUIControls(gridPane);
        Scene scene = new Scene(gridPane, 800, 500);	
        primaryStage.setScene(scene);
        scene.setFill(Color.DARKCYAN);
        primaryStage.show();
    }


    private GridPane createolshopPane() {
        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);

        gridPane.setPadding(new Insets(40, 40, 40, 40));

        gridPane.setHgap(10);

        gridPane.setVgap(10);

        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        Label headerLabel = new Label("Nexor Shop");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        Label nameLabel1 = new Label("Kategori Barang ");
        gridPane.add(nameLabel1, 0,1);

        TextField nameField1 = new TextField();
        nameField1.setPrefHeight(40);
        gridPane.add(nameField1, 1,1);
        
        Label nameLabel2 = new Label("Nama Barang ");
        gridPane.add(nameLabel2, 0,2);
        
        TextField nameField2 = new TextField();
        nameField2.setPrefHeight(40);
        gridPane.add(nameField2, 1,2);

        Label nameLabel3 = new Label("Jumlah Barang ");
        gridPane.add(nameLabel3, 0, 3);

        TextField nameField3 = new TextField();
        nameField3.setPrefHeight(40);
        gridPane.add(nameField3, 1, 3);
        
        Label nameLabel4 = new Label("Harga Barang ");
        gridPane.add(nameLabel4, 0, 4);
        
        TextField nameField4 = new TextField();
        nameField4.setPrefHeight(40);
        gridPane.add(nameField4, 1, 4);

        Label nameLabel5 = new Label("Payment Method ");
        gridPane.add(nameLabel5, 0, 5);

        TextField nameField5 = new TextField();
        nameField5.setPrefHeight(40);
        gridPane.add(nameField5, 1, 5);
        
        Label nameLabel6 = new Label("Alamat Pembeli ");
        gridPane.add(nameLabel6, 0, 6);
        
        TextField nameField6 = new TextField();
        nameField6.setPrefHeight(40);
        gridPane.add(nameField6, 1, 6);

        Button submitButton = new Button("Beli");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 7, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));
        
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameField1.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Masukkan kategori");
                    return;
                }
                if(nameField2.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Masukkan nama barang");
                    return;
                }
                if(nameField3.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Masukkan jumlah barang");
                    return;
                }
                if(nameField4.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Masukkan harga barang");
                    return;
                }
                if(nameField5.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Masukkan payment method");
                    return;
                }
                if(nameField6.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Masukkan alamat");
                    return;
                }
                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "", "Apakah anda yakin?");
            }
            
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    
    }
    
     public static void main(String[] args) {
         olshop myObj = new olshop();
    myObj.name = "Program Sedang Berjalan...";
    System.out.println(myObj.name);
        launch(args);
}
}
