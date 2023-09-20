package in.fssa.knfunding.validator;

import exception.ValidationException;
import in.fssa.knfunding.dao.UserDAO;
import in.fssa.knfunding.model.User;

public class UserValidator {
	/**
	 * 
	 * @param user
	 * @throws ValidationException
	 */
	public static void Validate(User user) throws ValidationException{
    	if(user == null) {
    		throw new ValidationException("Invalid User Input");
    	}
    	
    	if(user.getEmail() == null || "".equals(user.getEmail().trim())) {
    		throw new ValidationException("Email cannot be null or empty");
    	}
    	if(user.getPassword() == null || "".equals(user.getPassword().trim())) {
    		throw new ValidationException("Password cannot be null or empty");
    	}
    	if(user.getFullName() == null || "".equals((user.getFullName()).trim())) {
    		throw new ValidationException("Name can't be null or empty");
    	}
    	

    }
	
	
	/**
	 * 
	 * @param user
	 * @param id
	 * @throws ValidationException
	 */

	public static void ValidateUpdate(User user, int id) throws ValidationException {
		if(user == null) {
    		throw new ValidationException("Invalid User Input");
    	}
    	if(id <=0) {
    		throw new ValidationException("Invalid UserId");
    	}
    	if(user.getEmail() == null || "".equals(user.getEmail().trim())) {
    		throw new ValidationException("Email cannot be null or empty");
    	}
    	if(user.getPassword() == null || "".equals(user.getPassword().trim())) {
    		throw new ValidationException("Password cannot be null or empty");
    	}
    	if(user.getFullName() == null || "".equals((user.getFullName()).trim())) {
    		throw new ValidationException("Name can't be null or empty");
    	}
		
    	UserDAO userDao = new UserDAO();
    	User val = userDao.findById(id);
    	if(val == null) {
    		throw new ValidationException("Invalid UserId");
    	}
    	
	}
	
}
