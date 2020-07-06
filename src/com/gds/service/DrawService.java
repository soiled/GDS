package com.gds.service;

import com.gds.dao.DrawDao;
import com.gds.dao.UserDao;
import com.gds.entity.Role;
import com.gds.entity.Users;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.gds.dao.AdminDao;

public class DrawService {
	DrawDao dao = new DrawDao();
	UserDao udao = new UserDao();

	public List<Role> draw(int userId, int chance) {
		List<Role> getlist = new ArrayList<>();
		for (int i = 0; i < chance; i = i + 1) {// 抽奖次数
			// 随机过程
			double rate = Math.random();
			int level = 3;
//		DecimalFormat df=new DecimalFormat("#.000");//保留两位
//		df.format(rate);//保留后的数 需要整个放进去  String  
			if (rate <= 0.020) {
				level = 6;
			} else if (rate < 0.1) {
				level = 5;
			} else if (rate < 0.6) {
				level = 4;
			} else if (rate <= 1) {
				level = 3;
			}
			List<Role> list = dao.select_draw_role(level);
			List<Integer> rid = new ArrayList<>();
			for (Role r : list) {// 某个等级的全部Id
				rid.add(r.getRoleId());
			}
			Random rd=new Random();
			int num=rd.nextInt(rid.size());//随机数
			System.out.println(num);
			getlist.add(list.get(num)); // getlist中加入     在list中的某一个role
			dao.addRole(userId, list.get(num).getRoleId()/*这里是抽到的roleId*/);	// 加入数据库
		
		for (Role r1 : getlist) {
			System.out.println(r1.getRoleName());
		
		}
	}
		return getlist;
	}
}