/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author felismelo
 */
public class layout {
    public void pagination(JButton jButton1, JButton jButton2, JLabel page, JLabel totalPage){
        int curentPage = Integer.parseInt(page.getText());
        int totPage = Integer.parseInt(totalPage.getText());
        if(curentPage == totPage){
            jButton2.setEnabled(false);
        }else{
            jButton2.setEnabled(true);
        }
        
        if(curentPage==1){
            jButton1.setEnabled(false);
        }else{
            jButton1.setEnabled(true);
        }        
    }
}
