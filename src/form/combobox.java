/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import javax.swing.JComboBox;

/**
 *
 * @author felismelo
 */
public class combobox {
    public combobox(){
        
    }
    
    public combobox(JComboBox jcombobox){
        jcombobox.removeAllItems();
    }
    
    public combobox(JComboBox jcombobox,String item){
        jcombobox.addItem(item);
    }
}
