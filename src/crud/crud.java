/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import config.config;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felismelo
 */
public class crud {
    config c = new config();
    private String table;
    private String field;
    private String values;
    private String key;
    private String addsql;
    private ResultSet resultset;
    private DefaultTableModel model;
    private static String id;
    private static String title;

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        crud.title = title;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        crud.id = id;
    }
    
    public boolean getSuccess(){
        return c.getSuccess();
    }
    
    public String getTable() {
        return table;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAddsql() {
        return addsql;
    }
    
    public void setAddsql(String addsql) {
        this.addsql = addsql;
    }
    
    public ResultSet getResultset() {
        return resultset;
    }

    public void setResultset(ResultSet resultset) {
        this.resultset = resultset;
    }
    
    public void add(){
        c.query("INSERT INTO "+this.table+" ("+this.field+") VALUES("+this.values+")");
    }
    
    public void edit(){
        String exsql = (this.addsql==null) ? "": this.addsql;
        c.query("UPDATE "+this.table+" SET "+this.field+" "+exsql);
    }
    
    public void delete(){
        String exsql = (this.addsql==null) ? "": this.addsql;
        c.query("DELETE FROM "+this.table+" "+exsql);
    }
    
    public void show(String query){
        this.resultset = c.show(query);
        getResultset();
    }

    public String getOne(String query){
        String output = "";
        ResultSet rs;
        try{
            config config = new config();
            rs = config.show(query);
            while(rs.next()){
              output = rs.getString(1);
              break;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return output;
    }
    
    public void addData(String table,String field,String values){
        this.setTable(table);
        this.setField(field);
        this.setValues(values);
        this.add();
    }
    
    public void editData(String table,String field,String addSql){
        this.setTable(table);
        this.setField(field);
        this.setAddsql(addSql);
        this.edit();
    }
    
    public void deleteData(String table,String addSql){
        this.setTable(table);
        this.setAddsql(addSql);
        this.delete();
    }
        
    public boolean uniqueText(JTextField jtextfield, String table, String index){
        boolean output = true;
        String text = jtextfield.getText();
        if(table.isEmpty()){
            table = "user";
        }
        if(index.isEmpty()){
            index = "id";
        }
        ResultSet resultset;
        resultset = c.show("SELECT "+index+" FROM "+table+" WHERE "+index+" = '"+text+"' LIMIT 1");
        try{
            while(resultset.next()){
                output = false;
            }
        }catch(Exception e){
            
        }
        if(output==false){
            jtextfield.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, text+" sudah ada");
        }else{
            jtextfield.setBackground(null);
        }
        return output;
    }    

    
    public void comboData(JComboBox combobox, String table, String index, String field){
        ResultSet rs;
        
        rs = c.show("SELECT "+index+", "+field+" FROM "+table);
        String isexist = null;
        try{
            while(rs.next()){
                combobox.addItem(rs.getString(index)+" - "+rs.getString(field));
                isexist = rs.getString(index);
            }
            if(isexist == null){
                System.out.println("gak ada");
            }
        }catch(Exception e){
            
        }
    }

    public void tableData(JTable jtable, String table, String index, String condition){
        ResultSet rs;
        ResultSetMetaData metaData;
        model = new DefaultTableModel();
        condition = condition==null ? "" : condition;
        if(index == null) index = "*";
        rs = c.show("SELECT "+index+" FROM "+table+" "+condition);
        String isexist = null;
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        jtable.setModel(model);
        try{
            metaData = rs.getMetaData();
            int indexlength = metaData.getColumnCount();
            boolean check = false;
            for(int i=0;i<indexlength;i++){
                model.addColumn(metaData.getColumnLabel(i+1));
                jtable.getColumnModel().getColumn(i).setPreferredWidth(200);
            }
            while(rs.next()){
                Object[] datarow = new Object[indexlength];

                for(int i=0;i<indexlength;i++){
                    datarow[i] = rs.getString(metaData.getColumnLabel(i+1));
                }
                model.addRow(datarow);
                isexist = rs.getString(1);
            }

            if(isexist == null){
                System.out.println("gak ada");
            }
            rs.close();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }    

    public void detailData(JTable jtable, String table, String index, String condition){
        ResultSet rs;
        ResultSetMetaData metaData;
        model = new DefaultTableModel();
        condition = condition==null ? "LIMIT 1" : condition+" LIMIT 1";
        if(index == null) index = "*";
        rs = c.show("SELECT "+index+" FROM "+table+" "+condition);
        String isexist = null;
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        jtable.setModel(model);

        try{
            metaData = rs.getMetaData();
            int indexlength = metaData.getColumnCount();
            model.addColumn("label");
            model.addColumn("value");
            while(rs.next()){
                Object[] datarow = new Object[indexlength];
                for(int i=0;i<indexlength;i++){
                    for(int j=0;j<2;j++){
                        datarow[0] = metaData.getColumnLabel(i+1);
                        datarow[1] = rs.getString(metaData.getColumnLabel(i+1));
                    }
                    model.addRow(datarow);
                }
                isexist = rs.getString(1);
            }
            if(isexist == null){
                System.out.println("gak ada");
            }
            rs.close();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }        
    
    public int INSERT_ID(){
        int id = 0;
        ResultSet rs;
        rs = c.show("SELECT last_insert_id()");
        
        try{
            while(rs.next()){
                id = Integer.parseInt(rs.getString("last_insert_id()"));
            }
        }catch(Exception e){
            
        }
        return id;
    }
    
    public void auto_code(String table,String code,int digit){
        int current_id = this.INSERT_ID();
        String string_id = String.valueOf(current_id);
        String basic_code = code;
        String zero = "";
        String code_value = "";
        int length_code = 0;
        int length_zero = 0;

        for(int i=0;i<digit;i++){
            zero += "0";
            System.out.println(zero);
        }
        length_code = string_id.length();
        length_zero = digit - length_code;
        code_value = zero.substring(0, length_zero);
        code_value = basic_code+code_value+current_id;
        
        this.editData(table, "code = '"+code_value+"'", "WHERE id = "+current_id);
    }
    
    public void alert(String text){
        JOptionPane.showMessageDialog(null, text);
    }
    
}
