package in.fssa.knfunding.service;

import java.util.Iterator;
import java.util.Set;

import exception.ValidationException;
import in.fssa.knfunding.dao.UserDAO;
import in.fssa.knfunding.model.User;
import in.fssa.knfunding.validator.UserValidator;

public class UserService {
	/**
	 * 
	 * @return
	 */

	public Set<User> getAll() {
		UserDAO userDao = new UserDAO();
		Set<User> userList = userDao.findAll();
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
	 * @param newUpdate
	 * @throws ValidationException
	 */

	public void update(int id, User newUpdate) throws ValidationException {
		UserDAO userDAO = new UserDAO();
		UserValidator.ValidateUpdate(newUpdate, id);
		userDAO.update(id, newUpdate);
		
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
}