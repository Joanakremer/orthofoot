package modelo;
import java.awt.Color;
import java.awt.Font;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MMascaraNumero extends PlainDocument {
    private static final long serialVersionUID = 1L;
    private int maxCharacters;

    public MMascaraNumero(int maxCharacters) {
        super();
        this.maxCharacters = maxCharacters;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }

        if (getLength() + str.length() <= maxCharacters) { // Verifica o número máximo de caracteres
            char[] caracteres = str.toCharArray();
            boolean todosNumeros = true;
            for (char c : caracteres) {
                if (!Character.isDigit(c)) {
                    todosNumeros = false;
                    break;
                }
            }

            if (todosNumeros) {
                super.insertString(offs, new String(caracteres), a);
            }
        }
    }
    
    public Integer getNum() {
        try {
            return Integer.valueOf(this.getText(0, this.getLength()));
        } catch (Exception e) {
            return null;
        }
    }
}
