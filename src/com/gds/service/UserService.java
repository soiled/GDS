package com.gds.service;

import java.util.List;

import com.gds.dao.UserDao;
import com.gds.entity.Role;
import com.gds.entity.Users;

public class UserService {
	//创建Dao
		UserDao dao =new UserDao();
	//查询用户		
		List<Users> selectUsers() {
			return dao.select();
		}
	//登录
		public int logincheck(Users user) {
			List<Users> list=dao.select();
			for(Users u:list) {
				if(u.getUserName().equals(user.getUserName())
						&&u.getUserPwd().equals(user.getUserPwd())) {    
					System.out.println("登录成功并返回Id");
					return u.getUserId();
				}
			}
			System.out.println("登陆失败返回0");
			return  0;
		}
	//注册
	public int signup(Users user){
		List<Users> list = dao.select();
		int flag=0;
		for(Users u:list) {
			if(u.getUserName().equals(user.getUserName())){
				flag=1;
				System.out.println("用户已存在");
				}
			}
		if(flag==0)
			return dao.signup(user);
		return 0;
	}
	
//查询已经拥有的角色	
	public List<Role> my_house(int userId){
		return dao.my_house(userId);
	}
	
//更改道具	
	public int updateitem_bag(Users user,int itemId,int itemNum) {
		
		return dao.updateItem_bag(user, itemId, itemNum);
	}

}
		

