package midtermlab3;

public class TextEditor {
    private String text;

    public TextEditor(String initialText) {
        this.text = initialText;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

    public void append(String newText) {
        this.text += newText;
    }

    public void delete(int n) {
        if (n <= this.text.length()) {
            this.text = this.text.substring(0, this.text.length() - n);
        }
    }
}
