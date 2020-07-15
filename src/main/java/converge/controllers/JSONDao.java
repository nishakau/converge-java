package converge.controllers;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import converge.dbHelper.DBSource;
import converge.models.Product;

class JSONDao {
	private static String GET_PRODUCT_BY_ID = "SELECT a.product_document from products a where a.product_document.pid=?";
	private static String UPDATE_PRODUCT_BY_ID="UPDATE products a SET a.product_document =json_mergepatch(a.product_document,?) where  a.product_document.pid=?";
	private static String DELETE_PRODUCT_BY_ID="DELETE FROM products a where a.product_document.pid=?";
	private static String INSERT_PRODUCT = "insert into products(PRODUCT_DOCUMENT) values (?)";
	private DBSource dbs= new DBSource();
	
public String insertJson(Connection con,String jsonString, String pid) throws Exception{
		
		Connection conn = con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int i =0;
		int count =0;
		try {
			if(conn== null) conn = dbs.getJsonXmlConnection();
			pstmt = conn.prepareStatement(GET_PRODUCT_BY_ID);
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count++;
			}
			if(count >0) {
				return "Product with this id already exists";
			}
			pstmt = conn.prepareStatement(INSERT_PRODUCT);
			pstmt.setString(1, jsonString);
			i = pstmt.executeUpdate();
			//System.out.println(i+" Records updated");
			conn.commit();
			
		}catch(Exception e) {
			if(conn != null)
				conn.rollback();
			throw e;
		}finally {
			if(con== null && conn !=null)
				conn.close();
		}
		return i+ " Row Inserted";
	}
	
	public String getProductById(Connection con, String id) throws Exception {
		
		Connection conn = con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Clob clob = null;
		String jsonData ="";
	
		try {
			if(conn== null) conn = dbs.getJsonXmlConnection();
			pstmt = conn.prepareStatement(GET_PRODUCT_BY_ID);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				clob = rs.getClob(1);
				jsonData = clob.getSubString(1, (int) clob.length());
				
			

			}
			
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			throw e;
		} finally {
			if (con == null && conn != null)
				conn.close();
		}
		
		return jsonData;
	}
	
	public int updateProductById(Connection con,String json,String pid) throws Exception{
		
//		System.out.println("From dao layer");
//		System.out.println(json);
//		System.out.println(pid);
		Connection conn = con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int i =0;
		
		try {
			if(conn== null) conn = dbs.getJsonXmlConnection();
			pstmt = conn.prepareStatement(UPDATE_PRODUCT_BY_ID);
			pstmt.setString(1, json);
			pstmt.setString(2, pid);
			i = pstmt.executeUpdate();
			//System.out.println(i+" Records updated");
			conn.commit();
			
		}catch(Exception e) {
			if(conn != null)
				conn.rollback();
			throw e;
		}finally {
			if(con== null && conn !=null)
				conn.close();
		}
		return i;
	}

public int deleteProductById(Connection con,String pid) throws Exception{
		
		Connection conn = con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int i =0;
		
		try {
			if(conn== null) conn = dbs.getJsonXmlConnection();
			pstmt = conn.prepareStatement(DELETE_PRODUCT_BY_ID);
			pstmt.setString(1, pid);
			i = pstmt.executeUpdate();
			//System.out.println(i+" Records updated");
			conn.commit();
			
		}catch(Exception e) {
			if(conn != null)
				conn.rollback();
			throw e;
		}finally {
			if(con== null && conn !=null)
				conn.close();
		}
		return i;
	}

}
