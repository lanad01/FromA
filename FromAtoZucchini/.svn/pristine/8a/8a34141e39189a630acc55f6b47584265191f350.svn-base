package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User;
@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private SqlSession session;
	public User findByIdAndPwd(User user) {
		User usr = session.selectOne("user.getUser",user);
		return usr;
	}

}

















