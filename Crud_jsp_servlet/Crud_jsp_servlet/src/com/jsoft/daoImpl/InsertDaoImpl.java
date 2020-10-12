package com.jsoft.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsoft.dao.InsertDao;
import com.jsoft.pojo.UserBean;
import com.jsoft.utility.DbConnection;

public class InsertDaoImpl implements InsertDao{

	@Override
	public void insertValues(UserBean userBean) {
	Connection conn=null;
	PreparedStatement ps=null;
		try {
			String query="insert into student(uname,pwd,email,contact,age) values(?,?,?,?,?)";
			conn=DbConnection.get_connection();
			ps=conn.prepareStatement(query);
			ps.setString(1,userBean.getUname());
			ps.setString(2, userBean.getPwd());
			ps.setString(3, userBean.getEmail());
			
			
			ps.setString(4, userBean.getContact());
			ps.setInt(5, userBean.getAge());
			ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		try {
			DbConnection.closeConnection(conn, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	}

	@Override
	public List<UserBean> getValues() {
		Connection conn=null;
		PreparedStatement ps=null;
		List<UserBean> list=new ArrayList<UserBean>();
		ResultSet rs=null;
		try {
			String query="select * from student";
			conn=DbConnection.get_connection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			UserBean ubean=null;
			while(rs.next()){
				ubean=new UserBean();
				ubean.setId(rs.getInt("id"));
				ubean.setUname(rs.getString("uname"));
				ubean.setEmail(rs.getString("email"));
				ubean.setPwd(rs.getString("pwd"));
				ubean.setContact(rs.getString("contact"));
				ubean.setAge(rs.getInt("age"));
				list.add(ubean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbConnection.closeConnectionRs(conn, ps, rs);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public void delete(UserBean userBean) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try {
			connection=DbConnection.get_connection();
			String sql="delete from student where id=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, userBean.getId());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbConnection.closeConnection(connection, preparedStatement);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	@Override
	public void updateValues(UserBean userBean) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=DbConnection.get_connection();
			String sql="update student set uname =?,pwd=?,email=?,contact=?,age=? where id=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, userBean.getUname());
			preparedStatement.setString(2, userBean.getPwd());
			preparedStatement.setString(3, userBean.getEmail());
			preparedStatement.setString(4, userBean.getContact());
			preparedStatement.setInt(5, userBean.getAge());
			preparedStatement.setInt(6, userBean.getId());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbConnection.closeConnection(connection, preparedStatement);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	}

}
