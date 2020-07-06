package com.gds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gds.entity.Role;
import com.gds.entity.Users;

//查询所有用户
public class AdminDao {
	public List<Users> selectuser() {
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

//删除用户
	public int delectUser(int userId) {
		String sql = "delect from users where userid=" + "'" + userId + "'";
		Connection connection = SQLUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.executeQuery(sql);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			SQLUtil.closeAll(connection, ps, null);
		}

		return 0;
	}

//用户拥有的角色
	public List<Role> selectRole(int userId) {
		List<Role> list = new ArrayList<>();
		String sql = "select * from role inner join house where house.userId=? and role.roleId=house.roleId";
		Connection connection = SQLUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Role role = new Role();
				role.setRoleId(rs.getInt(1));
				role.setRoleName(rs.getString(2));
				role.setRoleInformation(rs.getString(3));
				list.add(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SQLUtil.closeAll(connection, ps, rs);
		}
		return list;
	}

//查询所有的角色
	public List<Role> selectAllRole() {
		List<Role> list = new ArrayList<>();
		String sql = "select * from role";
		Connection connection = SQLUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Role role = new Role();
				role.setRoleId(rs.getInt(1));
				role.setRoleName(rs.getString(2));
				role.setRoleInformation(rs.getString(3));
				role.setRolePitcture(rs.getString(4));
				list.add(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SQLUtil.closeAll(connection, ps, rs);
		}
		return list;
	}

//添加角色
	public int addRole(String roleName, String roleInf, String rolePic) {
		String sql = "insert into users value(null,?,?,?)";
		Connection connection = SQLUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, roleName);
			ps.setString(2, roleInf);
			ps.setString(3, rolePic);
			int result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SQLUtil.closeAll(connection, ps, null);
		}
		return 0;
	}

//修改角色信息
	public int updateRole(int roleId, String roleName, String roleInf, String rolePic) {
		String sql = "UPDATE role set roleName =? , roleInformation=?, rolePicture=? WHERE roleId=?";
		Connection connection = SQLUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, roleName);
			ps.setString(2, roleInf);
			ps.setString(3, rolePic);
			ps.setInt(4, roleId);
			int result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SQLUtil.closeAll(connection, ps, null);
		}
		return 0;
	}

//admin	  
	public List<Users> selectadmin() {
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
				user.setAdminPwd(rs.getString(4));
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
}
