/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;

/**
 *
 * @author felismelo
 */
public class button {
    public void colorButton(JButton button, String background, String foreground){
        button.setBackground(Color.decode(background));
        button.setForeground(Color.decode(foreground));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
