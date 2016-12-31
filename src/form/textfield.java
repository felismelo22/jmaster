/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author felismelo
 */
public class textfield {
    public boolean textFieldValidation(JTextField jtextfield, String fieldname, String kind){
        String text = jtextfield.getText();
        boolean success = false;
        String msg = "tidak boleh kosong";
        if(kind.isEmpty()){
            kind = "empty";
        }
        switch(kind)
        {
            case "empty":
                msg = "tidak boleh kosong";
                if(!text.isEmpty()){
                    success = true;
                }
            break;
        }
        
        if(fieldname.isEmpty()){
            fieldname = "fieldname";
        }
        if(success == false){
            JOptionPane.showMessageDialog(null, fieldname+" "+msg);
            jtextfield.setBackground(Color.red);
        }else{
            jtextfield.setBackground(null);
        }
        return success;
    }
    
    public boolean isNumeric(JTextField jtextfield){
        boolean success = true;
        String text = jtextfield.getText();
        try{
            int number = Integer.parseInt(text);
        }catch(NumberFormatException e){
            text = text.replaceAll("[^\\d]", "");
            jtextfield.setText(text);
        }
        
        return success;
    }
    
    public boolean textComparation(JTextField field1, JTextField field2, String msg){
        boolean output = false;
        String input1 = field1.getText();
        String input2 = field2.getText();
        msg = msg.isEmpty() ? "Comparation not match" : msg;
        System.out.println(input1);
        System.out.println(input2);

        if(input1.equals(input2)){
            output = true;
            field2.setBackground(null);
        }else{
            field2.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, msg);
        }
        return output;
    }
}
