package com.gds.service;

import java.util.List;

import com.gds.dao.UserDao;
import com.gds.entity.Role;
import com.gds.entity.Users;

public class UserService {
	//����Dao
		UserDao dao =new UserDao();
	//��ѯ�û�		
		List<Users> selectUsers() {
			return dao.select();
		}
	//��¼
		public int logincheck(Users user) {
			List<Users> list=dao.select();
			for(Users u:list) {
				if(u.getUserName().equals(user.getUserName())
						&&u.getUserPwd().equals(user.getUserPwd())) {    
					System.out.println("��¼�ɹ�������Id");
					return u.getUserId();
				}
			}
			System.out.println("��½ʧ�ܷ���0");
			return  0;
		}
	//ע��
	public int signup(Users user){
		List<Users> list = dao.select();
		int flag=0;
		for(Users u:list) {
			if(u.getUserName().equals(user.getUserName())){
				flag=1;
				System.out.println("�û��Ѵ���");
				}
			}
		if(flag==0)
			return dao.signup(user);
		return 0;
	}
	
//��ѯ�Ѿ�ӵ�еĽ�ɫ	
	public List<Role> my_house(int userId){
		return dao.my_house(userId);
	}
	
//���ĵ���	
	public int updateitem_bag(Users user,int itemId,int itemNum) {
		
		return dao.updateItem_bag(user, itemId, itemNum);
	}

}
		

