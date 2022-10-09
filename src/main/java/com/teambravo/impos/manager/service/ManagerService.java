package com.teambravo.impos.manager.service;

import com.teambravo.impos.manager.dao.Managerdao;
import com.teambravo.impos.manager.domain.Managerdomain;

public class ManagerService {

	public ManagerService() {

	}

	Managerdao dao = new Managerdao();

	public void addManager(Managerdomain user) { // 입력한 유저정보를 전달한다
		dao.addmanager(user);
	}

	public boolean isVaildUser(String userId, String passwd) { // 로그인하기위해 입력한 아이디와 비번이 있는건지 검사
		Managerdomain user = dao.findUser(userId);

		if (user == null) { // 아이디가 존재하지 않으면 유저가 null이니 실패
			System.out.println("아이디가 존재 X");
			return false;
		} else { // 아이디가 존재하면 비번을 입력한 비번이랑 비교
			if (user.getPasswd().equals(passwd)) {
				System.out.println(userId);
				System.out.println(passwd);
				return true;
			} else {
				System.out.println("비밀번호를 잘못 입력했습니다");
				return false;
			}
		}

	}
	
	// 로그인된 유저의 정보를 불러온다
	public Managerdomain user(String userId) {
		Managerdomain user = dao.findUser(userId);
		return user;
	}
	
	// 아이디 중복확인
	public boolean checkId(String userId) {
		Managerdomain user = dao.findUser(userId);
		
		if (user == null) {
			return true;
		}
		return false;
		
	}
	
}
