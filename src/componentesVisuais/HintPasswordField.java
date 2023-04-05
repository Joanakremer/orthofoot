package componentesVisuais;

import java.awt.Color;  
import java.awt.Font;  
import java.awt.event.FocusAdapter;  
import java.awt.event.FocusEvent;  
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;
 

public class HintPasswordField extends JPasswordField{
	 Font gainFont = new Font("Yu Gothic UI ", Font.PLAIN, 14);  
	  Font lostFont = new Font("Yu Gothic UI ", Font.PLAIN, 24);
	  
	  public HintPasswordField(final String hint) {  
		  
		    setText(hint);  
		    setFont(lostFont);  
		    setForeground(Color.BLACK);  
		    setEchoChar((char) 0);
		  
		    this.addFocusListener(new FocusAdapter() {  
		      @Override  
		      public void focusGained(FocusEvent e) {  
		        if (getText().equals(hint)) {  
		          setText("");  
		          setFont(gainFont);  
		          setForeground(Color.BLACK); 
		          setEchoChar('●');
		        } else {  
		          setText(getText()); 
		          setFont(gainFont);
		          setForeground(Color.BLACK);
		          setEchoChar('●');
		        }  
		      }  
		  
		      @Override  
		      public void focusLost(FocusEvent e) {  
		        if (getText().equals(hint)|| getText().length()==0) {  
		          setText(hint);  
		          setFont(lostFont);
		          setForeground(Color.BLACK); 
		          setEchoChar((char) 0);
		        } else {  
		          setText(getText());  
		          setFont(gainFont);  
		          setForeground(Color.BLACK);
		          setEchoChar('●');
		        }
		        
		      }  
		    });  
		  
		  }  
}

