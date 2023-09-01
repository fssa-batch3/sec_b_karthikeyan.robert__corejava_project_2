package in.fssa.knfunding.service;

import java.util.Iterator;

import java.util.List;

import exception.ValidationException;
import in.fssa.knfunding.dao.UserDAO;
import in.fssa.knfunding.model.User;
import in.fssa.knfunding.validator.UserValidator;

public class UserService {
	/**
	 * 
	 * @return
	 */

	public List<User> getAll() {
		UserDAO userDao = new UserDAO();
		List<User> userList = userDao.findAll();
		Iterator<User> iterator = userList.iterator();

		while (iterator.hasNext()) {
			User user = iterator.next();
			System.out.println(user);
			
		}
		return userList;
	}
	/**
	 * 
	 * @param newUser
	 * @throws Exception
	 */

	public void create(User newUser) throws Exception {
		UserDAO userDao = new UserDAO();
		UserValidator.Validate(newUser);
		userDao.create(newUser);
	}
	
	/**
	 * 
	 * @param id
	 */

	public void delete(int id) {
		UserDAO userDao = new UserDAO();
		userDao.delete(id);
	}
	/**
	 * 
	 * @param newId
	 * @return
	 */

	public User findById(int newId) {
		UserDAO userDao = new UserDAO();
		return userDao.findById(newId);

	}
	
	/**
	 * 
	 * @param Email
	 * @return
	 */
	public User findByEmail(String Email) {
		UserDAO userDao = new UserDAO();
		return userDao.findByEmail(Email);
	}
	/**
	 * 
	 * @param user
	 * @throws ValidationException
	 */
	
	
	public void update(User user) throws ValidationException {
	    UserDAO userDAO = new UserDAO();
	    
	    int userId = user.getId(); 
	    
	    UserValidator.ValidateUpdate(user, userId);
	    
	    userDAO.update(userId, user);
	}

	
}