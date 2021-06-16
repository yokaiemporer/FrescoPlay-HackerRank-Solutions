package com.fresco.jdbc.code;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import com.fresco.jdbc.code.util.RunningScripts;
import com.fresco.jdbc.code.util.DbUtil;



public class DbOperations {
  Connection con= DbUtil.getConnection();
	public boolean insertCategory(String type) throws SQLException {
    Statement stmt=con.createStatement();
    int result=stmt.executeUpdate("insert into category(type) values("+"\""+type+"\""+")");
		return result>0;
	}
	public ArrayList getCategoryById(int id) throws SQLException {
    Statement stmt=con.createStatement();
    ResultSet results = stmt.executeQuery("select * from category where id="+"\""+id+"\"");
    ArrayList ar=new ArrayList();
    results.next();
    ar.add(results.getInt(1));
    ar.add(results.getString(2));
		return ar;
	}
	public ResultSet getAllCategory() throws SQLException {
    Statement stmt=con.createStatement();
    ResultSet results = stmt.executeQuery("select * from category");
		return results;
	}
	public boolean insertProduct(String name, float price, String type) throws SQLException {


    Statement stmt=con.createStatement();
    ResultSet results = stmt.executeQuery("select id from category where type="+"\""+type+"\"");
    results.next();
    int _id=results.getInt(1);
    int result=stmt.executeUpdate("insert into product(name,price,category_id) values("+"\""+name+"\","+"\""+price+"\","+"\""+_id+"\")");
		return result>0;
	}
	public ArrayList getProductById(int id) throws SQLException {
    Statement stmt=con.createStatement();
    ResultSet results = stmt.executeQuery("select * from product where id="+"\""+id+"\"");
    ArrayList ar=new ArrayList();
    results.next();
    ar.add(results.getInt(1));
    ar.add(results.getString(2));
    ar.add(results.getFloat(3));
    ar.add(results.getInt(4));
		return ar;
	}
	public ResultSet getAllProduct() throws SQLException {

    Statement stmt=con.createStatement();
    ResultSet results = stmt.executeQuery("select * from product");
		return results;
	}
	public boolean insertOrder(String product_name, Date date) throws SQLException {

    Statement stmt=con.createStatement();
    ResultSet results = stmt.executeQuery("select id from product where name="+"\""+product_name+"\"");
    results.next();

    int _id=results.getInt(1);
    int result=stmt.executeUpdate("insert into orders(product_id,order_date) values("+"\""+_id+"\","+"\""+date+"\")");
		return result>0;
	}
	public ArrayList getOrderById(int id) throws SQLException {
    Statement stmt=con.createStatement();
    ResultSet results = stmt.executeQuery("select * from orders where id="+"\""+id+"\"");
    ArrayList ar=new ArrayList();
    int i = 1;
    results.next();

    ar.add(results.getInt(1));
    ar.add(results.getInt(2));
    ar.add(results.getDate(3));
		return ar;
	}
	public ResultSet getAllOrder() throws SQLException {
		Statement stmt=con.createStatement();
    ResultSet results = stmt.executeQuery("select * from orders");
		return results;
	}
}
