package uap;

import javafx.application.Application;
import static javafx.application.Application.launch;
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

 public class UAP extends Application {
     String name;
     public String getName() {
    return name;
  }
  // Setter
  public void setName(String newName) {
    this.name = newName;
  }
  
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registration Form JavaFX Application");

        GridPane gridPane = createRegistrationFormPane();
        addUIControls(gridPane);
        Scene scene = new Scene(gridPane, 800, 500);	
        primaryStage.setScene(scene);
        scene.setFill(Color.DARKCYAN);
        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
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
        headerLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
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

        Label emailLabel = new Label("Jumlah Barang ");
        gridPane.add(emailLabel, 0, 3);

        TextField emailField = new TextField();
        emailField.setPrefHeight(40);
        gridPane.add(emailField, 1, 3);
        
        Label noLabel = new Label("Harga Barang ");
        gridPane.add(noLabel, 0, 4);
        
        TextField noField = new TextField();
        noField.setPrefHeight(40);
        gridPane.add(noField, 1, 4);

        Label passwordLabel = new Label("Metode Pembayaran ");
        gridPane.add(passwordLabel, 0, 5);
        
        TextField HDD = new TextField();
        noField.setPrefHeight(40);
        gridPane.add(HDD, 1, 4);

//        PasswordField passwordField = new PasswordField();
//        passwordField.setPrefHeight(40);
//        gridPane.add(passwordField, 1, 5);
        
        Label confirmLabel = new Label("Alamat Pembeli ");
        gridPane.add(confirmLabel, 0, 6);
        
        PasswordField confirmField = new PasswordField();
        confirmField.setPrefHeight(40);
        gridPane.add(confirmField, 1, 6);

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
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your processor");
                    return;
                }
                if(nameField2.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your motherboard");
                    return;
                }
                if(emailField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your RAM");
                    return;
                }
                if(noField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your VGA");
                    return;
                }
                if(HDD.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a hard disk");
                    return;
                }
                if(confirmField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a confirm Casing");
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
         UAP myObj = new UAP();
    myObj.name = "Program Sedang Berjalan...";
    System.out.println(myObj.name);
        launch(args);
}
}
