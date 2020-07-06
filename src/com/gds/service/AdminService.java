package com.gds.service;
import java.util.List;

import com.gds.dao.AdminDao;
import com.gds.entity.Role;
import com.gds.entity.Users;

public class AdminService {
	AdminDao dao = new AdminDao();
	
	public List<Users> selectuser(){
		return dao.selectuser();
	}
	public int delectUser(int userId) {
		return dao.delectUser(userId);	
		}
	public List<Role> selectRole(int userId){
		return dao.selectRole(userId);
	}	
	public int addRole(String roleName,String roleInf,String rolePic) {
		return dao.addRole(roleName, roleInf, rolePic);
		
	}
	public int updateRole(int roleId,String roleName,String roleInf,String rolePic) {
		return dao.updateRole(roleId, roleName, roleInf, rolePic);
	}
	public List<Users> selectadmin(){
		return dao.selectadmin();
	}
}
