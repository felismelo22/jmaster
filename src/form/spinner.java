/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import javax.swing.JSpinner;

/**
 *
 * @author felismelo
 */
public class spinner {
    public boolean isNumeric(JSpinner jspinner){
        boolean success = true;
//        String number =  (String) jspinner.getValue();
        try{
//            number = Integer.parseInt(number);
        }catch(NumberFormatException e){
//            number = number.replaceAll("[^\\d]", "");
//            jspinner.setValue(number);
        }
        
        return success;
    }    
}
