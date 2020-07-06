package com.gds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gds.entity.Role;
import com.gds.entity.Users;

public class DrawDao {
	// 查询所有角色ID
	public List<Role> selectRoleId() {
		List<Role> list = new ArrayList<>();
		String sql = "select * from role";
		Connection connection = SQLUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Role role = new Role();
				role.setRoleId(rs.getInt(1));
				role.setRoleName(rs.getString(2));
				role.setRoleInformation(rs.getString(3));
				role.setRolePitcture(rs.getString(4));
				role.setRoleLevel(rs.getInt(5));
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

	// 将抽到的角色放进去数据库
	public int addRole(int userId, int roleId) {
		String sql = "insert into house value(?,?)";
		Connection connection = SQLUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
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

	// 等级角色
	public List<Role> select_draw_role(int roleLevel) {
		List<Role> list = new ArrayList<>();
		String sql = "select * from role where roleLevel=" + roleLevel;
		Connection connection = SQLUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Role role = new Role();
				role.setRoleId(rs.getInt(1));
				role.setRoleName(rs.getString(2));
				role.setRoleInformation(rs.getString(3));
				role.setRolePitcture(rs.getString(4));
				role.setRoleLevel(rs.getInt(5));
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
}
