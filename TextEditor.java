import java.util.ArrayList;
import java.util.List;

public class TextEditor {
    private String documentName;
    private List<String> contentLines; // Each line of text is a string in the list

    public TextEditor(String documentName) {
        this.documentName = documentName;
        this.contentLines = new ArrayList<>();
        this.contentLines.add(""); // Start with an empty line
    }

    public void insertText(int lineNumber, int offset, String text) {
        String line = contentLines.get(lineNumber);
        StringBuilder sb = new StringBuilder(line);
        sb.insert(offset, text);
        contentLines.set(lineNumber, sb.toString());
    }

    public void deleteText(int lineNumber, int offset, int length) {
        String line = contentLines.get(lineNumber);
        StringBuilder sb = new StringBuilder(line);
        sb.delete(offset, offset + length);
        contentLines.set(lineNumber, sb.toString());
    }

    public List<String> getContentLines() {
        return contentLines;
    }

    public void setContentLines(List<String> contentLines) {
        this.contentLines = contentLines;
    }

    // Other methods as needed for real-time collaborative editing
}
