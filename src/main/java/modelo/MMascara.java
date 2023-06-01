package modelo;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public final class MMascara extends JTextField {
    private static final long serialVersionUID = 1L;
    private int maxCharacters;

    public MMascara(int maxCharacters) {
        super();
        this.maxCharacters = maxCharacters;
        setDocument(new LettersOnlyDocument());
    }

    private class LettersOnlyDocument extends PlainDocument {
        private static final long serialVersionUID = 1L;

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null) {
                return;
            }

            if (getLength() + str.length() <= maxCharacters) { // Verifies the maximum number of characters
                StringBuilder sb = new StringBuilder();
                for (char c : str.toCharArray()) {
                    if (Character.isLetter(c)) {
                        sb.append(c);
                    }
                }

                super.insertString(offs, sb.toString(), a);
            }
        }
    }
}