import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {
    private TextEditor textEditor; // Initialize this with an instance of TextEditor

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        TextArea textArea = new TextArea();
        textArea.setEditable(false); // Set to true for editing
        textArea.setWrapText(true);

        // Bind the text area content to the content lines of the text editor
        textArea.textProperty().bindBidirectional(textEditor.getContentLinesProperty());

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

