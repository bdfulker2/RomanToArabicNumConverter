/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package romantoarabicnumconverter;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;

/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class RomanToArabicNumConverter extends JFrame implements KeyListener {
   
    private static int[]    numbers = { 1000,  900,  500,  400,  100,   90,  
                                          50,   40,   10,    9,    5,    4,    1 };                                  
    private static String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC",
                                        "L",  "XL",  "X",  "IX", "V",  "IV", "I" };
   
    private JLabel arabicLabel, romanLabel;
    private JTextField arabicJTextField, romanJTextField;
    private JPanel panel;
    private GridLayout gridLayout = new GridLayout(2,2,15,5);
    public RomanToArabicNumConverter() {
        super("Roman <--> Arabic");
        
        panel = new JPanel(gridLayout);
        add(panel);
        arabicLabel = new JLabel("Arabic Numural");
        romanLabel = new JLabel( "Roman Numural");
        
        arabicJTextField = new JTextField();
        romanJTextField = new JTextField();
        arabicJTextField.addKeyListener(this);
        panel.add(arabicLabel);
        panel.add(arabicJTextField);
        
        panel.add(romanLabel);
        panel.add(romanJTextField);
       // DocumentListener simple = new simpleDocumentListener();
        
        arabicJTextField.getDocument().addDocumentListener(
                        (SimpleDocumentListener) new SimpleDocumentListener() {
                        //overrides update method from Interface
            @Override           //if einTextfield != 7 text color red and diable
            public void update(DocumentEvent e) {   //loginButton
                
              /*  if(arabicJTextField.getText().length() == 4) {
                    arabicJTextField.setForeground(Color.red);
                    
                }
                else {      //when einTextField has 7 char text turns green
                 //   einTextField.setForeground(Color.GREEN);
                   // loginButton.setEnabled(true);   //loginButton isEnabled
                }*/
            }
        });
        
       
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RomanToArabicNumConverter convert = new RomanToArabicNumConverter();
        convert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        convert.setSize(325,100);
        convert.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        
        char c = e.getKeyChar();
        if(!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) ||
                                               (c == KeyEvent.VK_DELETE)  ))  {
            getToolkit().beep();
            e.consume();
        }
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      /*  char c = e.getKeyChar();
        char d = '3';
        int maxNum = Integer.parseInt(arabicJTextField.getText());
        if(maxNum > 3999)   {
            getToolkit().beep();
            e.consume();
        }*/
        
        char c = e.getKeyChar();
        
        String belowThis = "";
        char[] digits = null;
        String temp = "";
        belowThis = arabicJTextField.getText();
        if(arabicJTextField.getText() != null)
        {
            if (arabicJTextField.getText().length() <= 4) {
                if ( ((belowThis.charAt(0) == '1') || (belowThis.charAt(0) == '2') || (belowThis.charAt(0) == '3'))) 
                {
                    digits = belowThis.toCharArray();
                    System.out.println(" Char is 1 , 2, or 3 char[0] = "+ belowThis.charAt(0));
                }
                else 
                {
                    if( (belowThis.charAt(0) == '4') || (belowThis.charAt(0) == '5') || (belowThis.charAt(0) == '6') || (belowThis.charAt(0) == '7') || (belowThis.charAt(0) == '8') || (belowThis.charAt(0) == '9')) 
                    {
                        System.out.println(" Char is 1 , 2, or 3 char[0] = "+ belowThis.charAt(0));
                    }    
                }
            } 
            else 
            {
                temp = belowThis.substring(0, 4);
                arabicJTextField.setText(temp);
            }
        }
    }
    
    @FunctionalInterface
    public interface SimpleDocumentListener extends DocumentListener {
        void update(DocumentEvent e);

        @Override
        default void insertUpdate(DocumentEvent e) {
            update(e);
        }
        @Override
        default void removeUpdate(DocumentEvent e) {
            update(e);
        }
        @Override
        default void changedUpdate(DocumentEvent e) {
            update(e);
        }
    }
    
}
