package com.company.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.company.util.DBUtil;
import com.company.dao.User;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean isValidUser(String username, String password) {
		String query = "SELECT * FROM USERS WHERE username = ? AND password = ?";
		try(Connection connection = DBUtil.getConnection();
				PreparedStatement pstm = connection.prepareStatement(query)){
			pstm.setString(1, username);
			pstm.setString(2, password);
			
			ResultSet resultSet = pstm.executeQuery();
			
			return resultSet.next();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addUser(User user) {
		String query = "insert into users(username, email, password) values (?,?,?)";
		try(Connection connection = DBUtil.getConnection();
				PreparedStatement pstm = connection.prepareStatement(query)){
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getEmail());
			pstm.setString(3, user.getPassword());
			
//			ResultSet resultSet = pstm.executeQuery();
			int rows = pstm.executeUpdate();
			return rows>0;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
