package cn.edu.bjtu.weibo.service.impl;

import org.springframework.stereotype.Service;

import cn.edu.bjtu.weibo.dao.LoginDAO;
import cn.edu.bjtu.weibo.dao.UserDAO;
import cn.edu.bjtu.weibo.dao.impl.LoginDAOImpl;
import cn.edu.bjtu.weibo.dao.impl.UserDAOImpl;
import cn.edu.bjtu.weibo.model.User;
import cn.edu.bjtu.weibo.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService{

	@Override
	public boolean registerNewUser(String username, String password) {
		// TODO Auto-generated method stub
		LoginDAO logindao = new LoginDAOImpl();
		UserDAO userdao = new UserDAOImpl();
		User user = new User();
		
		boolean ifInsert = logindao.insert(username, password);
		if(ifInsert){
			String userID = logindao.getUserId(username, password);	
			user.setName(username);
			boolean ifInsertNewUser = userdao.insertNewUserProfile(userID, user);
			return ifInsertNewUser;
		}
		return false;
	}

	@Override
	public boolean isUserNameExisted(String username) {
		// TODO Auto-generated method stub
		LoginDAO logindao = new LoginDAOImpl();
		boolean ifexist = logindao.select(username);
		return ifexist;
	}

}
