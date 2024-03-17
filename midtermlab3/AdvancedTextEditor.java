package midtermlab3;

public class AdvancedTextEditor extends TextEditor {
    private String[] history;
    private int currentIndex;

    public AdvancedTextEditor(String initialText) {
        super(initialText);
        history = new String[100];
        history[0] = initialText;
        currentIndex = 0;
    }

    @Override
    public void append(String newText) {
        super.append(newText);
        currentIndex++;
        if (currentIndex < history.length) {
            history[currentIndex] = this.getText();
        } else {
            shiftHistory();
            history[currentIndex] = this.getText();
        }
    }

    @Override
    public void delete(int n) {
        super.delete(n);
        currentIndex++;
        if (currentIndex < history.length) {
            history[currentIndex] = this.getText();
        } else {
            shiftHistory();
            history[currentIndex] = this.getText();
        }
    }

    private void shiftHistory() {
        for (int i = 1; i < history.length; i++) {
            history[i - 1] = history[i];
        }
        history[history.length - 1] = null;
        currentIndex--;
    }

    public void undo() {
        if (currentIndex > 0) {
            currentIndex--;
            setText(history[currentIndex]);
        }
    }
}
