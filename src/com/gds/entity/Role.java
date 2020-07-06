package com.gds.entity;

public class Role {
	int roleId;
	String roleName;
	String roleInformation;
	String rolePitcture;
	int roleLevel;
	public int getRoleLevel() {
		return roleLevel;
	}
	public void setRoleLevel(int roleLevel) {
		this.roleLevel = roleLevel;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleInformation() {
		return roleInformation;
	}
	public void setRoleInformation(String roleInformation) {
		this.roleInformation = roleInformation;
	}
	public String getRolePitcture() {
		return rolePitcture;
	}
	public void setRolePitcture(String rolePitcture) {
		this.rolePitcture = rolePitcture;
	}

}
