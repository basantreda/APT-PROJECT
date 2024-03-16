import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {
    private TextEditor textEditor; // Initialize this with an instance of TextEditor

    @Override
    public void start(Stage primaryStage) {
        textEditor = new TextEditor(); // Create an instance of TextEditor

        VBox root = new VBox();
        TextArea textArea = new TextArea();
        textArea.setEditable(true); // Set to true for editing
        textArea.setWrapText(true);

        // Update text area when content lines change
        textEditor.getContentLinesProperty().addListener((ListChangeListener<String>) change -> {
            StringBuilder sb = new StringBuilder();
            while (change.next()) {
                if (change.wasAdded()) {
                    for (String addedLine : change.getAddedSubList()) {
                        sb.append(addedLine).append("\n");
                    }
                } else if (change.wasRemoved()) {
                    // Handle removal if needed
                }
            }
            textArea.setText(sb.toString());
        });

        root.getChildren().add(textArea);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Collaborative Text Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
