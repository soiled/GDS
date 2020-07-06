package com.gds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gds.entity.House;
import com.gds.entity.Role;
import com.gds.entity.Users;

public class UserDao {
//获得角色	
	public int getRole(Users user, int roleId) {
		String sql = "insert into house values(?,?)";
		Connection connection = SQLUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setInt(2, roleId);
			int result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SQLUtil.closeAll(connection, ps, null);
		}
		return 0;
	}

	/*
	 * //玩家新增增道具 public int getItem(Users user,int itemId,int itemNum) { String sql
	 * = "insert into bag value(?,?,?)"; Connection
	 * connection=SQLUtil.getConnection(); PreparedStatement ps = null; try {
	 * ps=connection.prepareStatement(sql); ps.setInt(1, user.getUserId());
	 * ps.setInt(2, itemId); ps.setInt(3, itemNum); int result=ps.executeUpdate();
	 * return result; } catch (Exception e) { e.printStackTrace(); }finally {
	 * SQLUtil.closeAll(connection, ps, null); } return 0; }
	 */
	// 更新背包物品
	public int updateItem_bag(Users user, int itemId, int itemNum) {
		String sql = "update bag set itemNum=itemNum+" + itemNum + "where itemId=1";
		Connection connection = SQLUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			int result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			SQLUtil.closeAll(connection, ps, null);
		}
		return 0;

	}

//查询拥有角色
	public List<Role> my_house(int userId) {
		List<Role> list = new ArrayList<>();
		String sql = "select * from house inner join role where house.userId=" + "'" +userId + "'"
				+ "and role.roleId=house.roleId";
		Connection connection = SQLUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Role role = new Role();
				//返回的具有重复的数值 随意更改数据库这里就要看着返回信息更新
				role.setRoleId(rs.getInt(2));
				role.setRoleName(rs.getString(4));
				role.setRoleInformation(rs.getString(5));
				role.setRolePitcture(rs.getString(6));
				role.setRoleLevel(rs.getInt(7));
				list.add(role);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			SQLUtil.closeAll(connection, st, rs);
		}
		return list;
	}

	// 登录
	public List<Users> select() {
		List<Users> list = new ArrayList<>();
		String sql = "select * from users";
		Connection connection = SQLUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Users user = new Users();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPwd(rs.getString(3));
				list.add(user);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			SQLUtil.closeAll(connection, st, rs);
		}
		return list;
	}

//注册	  
	public int signup(Users user) {
		String sql = "INSERT into users(userId,userName,userPwd) VALUES(null,?,?)";
		Connection connection = SQLUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPwd());
			int result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SQLUtil.closeAll(connection, ps, null);
		}
		return 0;
	}

}
