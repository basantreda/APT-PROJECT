import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TextEditor {
    private ListProperty<String> contentLinesProperty;

    public TextEditor() {
        ObservableList<String> contentLines = FXCollections.observableArrayList();
        contentLines.add(""); // Start with an empty line
        this.contentLinesProperty = new SimpleListProperty<>(contentLines);
    }

    public ListProperty<String> getContentLinesProperty() {
        return contentLinesProperty;
    }

    public ObservableList<String> getContentLines() {
        return contentLinesProperty.get();
    }

    // Other methods for editing content
}
