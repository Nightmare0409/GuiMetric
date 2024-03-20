import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiMetric extends Application {

    //Assigning variables.
    final private double kgToLb = 2.20462;
    final private double gToOz = 0.03527396;
    final private double kmToMile = 0.621371;
    final private double mmToIn = 0.0393701;

    // Overriding the start method from Application class.
    @Override
    public void start(Stage primaryStage) {
        // Creating UI components and setting up the layout.
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        // Creating input label and text field.
        Label inputLabel = new Label("Input:");
        gridPane.add(inputLabel, 0, 0);
        TextField inputTextField = new TextField();
        gridPane.add(inputTextField, 1, 0);

        // Creating output label and text field.
        Label outputLabel = new Label("Output:");
        gridPane.add(outputLabel, 0, 1);
        TextField outputTextField = new TextField();
        outputTextField.setEditable(false);
        gridPane.add(outputTextField, 1, 1);

        // Creating combo box for unit selection.
        ComboBox<String> unitComboBox = new ComboBox<>();
        unitComboBox.getItems().addAll("Kilograms to Pounds", "Grams to Ounces", "Kilometers to Miles", "Millimeters to Inches");
        gridPane.add(unitComboBox, 0, 2, 2, 1);

        // Creating button that says convert to user.
        Button convertButton = new Button("Convert");
        gridPane.add(convertButton, 0, 3, 2, 1);

        // How the button works.
        convertButton.setOnAction(event -> {
            try {
                // Getting input value and selected unit.
                double inputValue = Double.parseDouble(inputTextField.getText());
                String selectedUnit = unitComboBox.getValue();
                double outputValue;

                // How the conversion works based on the selected input.
                switch (selectedUnit) {
                    case "Kilograms to Pounds":
                        outputValue = inputValue * kgToLb;
                        outputTextField.setText(String.format("%.2f", outputValue) + " lb");
                        break;
                    case "Grams to Ounces":
                        outputValue = inputValue * gToOz;
                        outputTextField.setText(String.format("%.2f", outputValue) + " oz");
                        break;
                    case "Kilometers to Miles":
                        outputValue = inputValue * kmToMile;
                        outputTextField.setText(String.format("%.2f", outputValue) + " mi");
                        break;
                    case "Millimeters to Inches":
                        outputValue = inputValue * mmToIn;
                        outputTextField.setText(String.format("%.2f", outputValue) + " in");
                        break;
                    default:
                        outputTextField.setText("Invalid unit");
                }
            } catch (NumberFormatException e) {
                outputTextField.setText("Invalid input");
            }
        });

        // Creating the scene and setting the stage.
        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Metric Converter");
        primaryStage.show();
    }

    // Main method to launch the JavaFX application.
    public static void main(String[] args) {
        launch(args);
    }
}
