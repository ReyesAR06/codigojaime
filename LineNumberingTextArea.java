
package compiladorjaime;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class LineNumberingTextArea extends JTextArea {
    private JTextArea textArea;
    private JTextArea lineNumberArea;

    public LineNumberingTextArea(JTextArea textArea) {
        this.textArea = textArea;
        this.setEditable(false);
        this.setBackground(Color.LIGHT_GRAY);

        // Add a document listener to the text area
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLineNumbers();
            }
        });

        // Initialize the line numbers
        updateLineNumbers();
    }

    private void updateLineNumbers() {
        int lineCount = textArea.getLineCount();
        StringBuilder lineNumberText = new StringBuilder();
        for (int i = 1; i <= lineCount; i++) {
            lineNumberText.append(i).append("\n");
        }
        this.setText(lineNumberText.toString());
    }
}
