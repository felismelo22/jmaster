/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import crud.crud;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felismelo
 */
public class test {
    private DefaultTableModel model;
    
    
//    public void show(){
//        config connect = new config();
//        ResultSet rs;
//        String data[] = new String[]{"username","password"};
//        StringBuilder field = new StringBuilder();
//        int datalength = data.length;
//        for(int i=0;i<datalength;i++){
//            field.append(data[i]);
//            if(i<datalength-1){
//                field.append(",");
//            }
//            
//        }
//        
//        
//        model.getDataVector().removeAllElements();
//        model.fireTableDataChanged();
//        int i = 0;
//        try{
//            String word = field.toString();
//            System.out.print(word);
//            rs = connect.show("SELECT "+word+" FROM user");
//            while(rs.next()){
//                Object[] o = new Object[datalength];
//                for(int j=0;j<data.length;j++){
//                    o[j] = rs.getString(data[j]);
//                    System.out.println(o[j]);
//                }
//                model.addRow(o);
//            }
//        }catch(SQLException e){
//            System.out.println(e);
//        }        
//    }

    public static void main(String[]args){
//        test t = new test();
//        t.show();
//        String myName = "domanokz";
//        String newName = myName.substring(0,4);
//        System.out.println(newName);
//        String test = "iwan,dwi,predi,h";
//        String[] tested = test.split(",");
//        int a = tested.length;
//        System.out.println(a);
        
//        int current_id = 15;
//        String string_id = String.valueOf(current_id);
//        String basic_code = "SUP";
//        String zero = "";
//        String code_value = "";
//        int length_code = 0;
//        int length_zero = 0;
//        int digit = 3;

//        for(int i=0;i<digit;i++){
//            zero += "0";
//            System.out.println(zero);
//        }
//        length_code = string_id.length();
//        System.out.println(length_code);
//        length_zero = digit - length_code;
//        System.out.println(length_zero);
//        code_value = zero.substring(0, length_zero);
//        System.out.println(code_value);
//        code_value = basic_code+code_value+current_id;
//        System.out.println(code_value);

//        String data = crud.getOne("select name,id from suplier ");
//        System.out.println(data);

//        ResultSet rs;
//        ResultSetMetaData metaData;
//        config c = new config();
//        rs = c.show("select * from user");
//        try{
//            metaData = rs.getMetaData();
//            int z = metaData.getColumnCount();
//            System.out.println(z);
//            int i = 1;
//            while(rs.next()){
//                System.out.println(metaData.getColumnName(i));
//                i++;
//            }
//        }catch(Exception e){
//            
//        }
        int a = 35;
        int b = 10;
        int c = (int) Math.ceil(a/b);
        System.out.println(c);
    }

}
