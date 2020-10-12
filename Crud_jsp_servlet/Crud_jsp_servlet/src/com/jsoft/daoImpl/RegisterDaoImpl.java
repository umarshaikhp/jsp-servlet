package com.jsoft.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jsoft.dao.RegisterDao;
import com.jsoft.pojo.RegisterBean;
import com.jsoft.utility.DbConnection;



public class RegisterDaoImpl implements RegisterDao{

	@Override
	public void registerAdd(RegisterBean registerBean) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DbConnection.get_connection();
			String query="insert into registerstudent(firstname,lastname,username,password,gender,mobile_no,aadhar_no,address,d_o_b)values(?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(query);
			ps.setString(1, registerBean.getFname());
			ps.setString(2,registerBean.getLname());
			ps.setString(3,registerBean.getUsername());
			ps.setString(4,registerBean.getPassword());
			ps.setString(5,registerBean.getGender());
			ps.setString(6,registerBean.getMno());
			ps.setString(7,registerBean.getAno());
			ps.setString(8,registerBean.getAddress());
			ps.setString(9,registerBean.getDte());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbConnection.closeConnection(conn, ps);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}

}
