package cn.edu.bjtu.weibo.service.impl;

import cn.edu.bjtu.weibo.dao.UserDAO;
import cn.edu.bjtu.weibo.dao.impl.UserDAOImpl;
import cn.edu.bjtu.weibo.model.User;
import cn.edu.bjtu.weibo.service.RegisterService;

public class RegisterServiceImpl implements RegisterService{

	@Override
	public boolean registerNewUser(String username, String password) {
		// TODO Auto-generated method stub
		UserDAO userdao = new UserDAOImpl();
		User user = new User();
		
		user.setName(username);
		user.setPassword(password);
        boolean fpass = userdao.insertNewUser(user);

		
		return ifpass;
	}

	@Override
	public boolean isUserNameExisted(String username) {
		// TODO Auto-generated method stub
		UserDAO userdao = new UserDAOImpl();
		return false;
	}

}
