package in.fssa.knfunding;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import in.fssa.knfunding.model.User;
import in.fssa.knfunding.service.UserService;

public class TestUser {
	@Test
	public void testCreateUserWithValidataInput() {
		UserService userService = new UserService();

		User newUser = new User();

		newUser.setFullName("karthikeyan");
		newUser.setEmail("karthikn352004@gmail.com");
		newUser.setPassword("Sollamattan");
		newUser.setPhoneNumber(7010847986l);

		assertDoesNotThrow(() -> {
			userService.create(newUser);
		});

	}

	@Test
	public void testCreateUserWithInvalidataInput() {
		UserService userService = new UserService();
		Exception exception = assertThrows(Exception.class, () -> {
			userService.create(null);
		});
		String expectedMessage = "Invalid User Input";
		String actualMessage = exception.getMessage();

		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateUserWithEmailNull() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(10);
		newUser.setFullName("karthikeyan");
		newUser.setEmail("");
		newUser.setPassword("Sollamattan");
		newUser.setPhoneNumber(7010847986l);
		newUser.setActive(true);

		Exception exception = assertThrows(Exception.class, () -> {
			userService.create(newUser);
		});
		String expectedMessage = "Email cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testUserEmailWithEmailEmpty() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(10);
		newUser.setFullName("karthikeyan");
		newUser.setEmail("");
		newUser.setPassword("Sollamattan");
		newUser.setPhoneNumber(7010847986l);
		newUser.setActive(true);

		Exception exception = assertThrows(Exception.class, () -> {
			userService.create(newUser);
		});
		String expectedMessage = "Email cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testUserPasswordWithNull() {
		UserService userService = new UserService();

		User newUser1 = new User();
		newUser1.setId(10);
		newUser1.setFullName("karthikeyan");
		newUser1.setEmail("karthikn352004@gmail.com");
		newUser1.setPhoneNumber(7010847986l);
		newUser1.setPassword(null);
		newUser1.setActive(true);

		Exception exception = assertThrows(Exception.class, () -> {
			userService.create(newUser1);
		});
		String exceptedMessage = "Password cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test
	public void testUserPasswordWithEmpty() {
		UserService userService = new UserService();

		User newUser1 = new User();
		newUser1.setId(10);
		newUser1.setFullName("karthikeyan");
		newUser1.setEmail("karthikn352004@gmail.com");
		newUser1.setPhoneNumber(7010847986l);
		newUser1.setPassword(" ");
		newUser1.setActive(true);

		Exception exception = assertThrows(Exception.class, () -> {
			userService.create(newUser1);
		});
		String exceptedMessage = "Password cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test
	public void testUserNameWithNull() {
		UserService userService = new UserService();

		User newUser1 = new User();
		newUser1.setFullName(null);
		newUser1.setEmail("karthikn352004@gmail.com");
		newUser1.setPassword("sollamattan");
		newUser1.setPhoneNumber(7010847986l);

		Exception exception = assertThrows(Exception.class, () -> {
			userService.create(newUser1);
		});
		String exceptedMessage = "Name can't be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test
	public void testUserNameWithEmpty() {
		UserService userService = new UserService();

		User newUser1 = new User();
		newUser1.setId(10);
		newUser1.setFullName("  ");
		newUser1.setEmail("karthikn352004@gmail.com");
		newUser1.setPassword("sollamattan");
		newUser1.setPhoneNumber(7010847986l);
		newUser1.setActive(true);

		Exception exception = assertThrows(Exception.class, () -> {
			userService.create(newUser1);
		});
		String exceptedMessage = "Name can't be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(exceptedMessage.equals(actualMessage));
	}
	
	@Test
	public void testUpdateUserWithValidInputAndId() {
		UserService userservice = new UserService();

		User user = new User();
		user.setFullName("karthikeyan");
		user.setEmail("karthikn@354@gmail.com");
		user.setPassword("KN@354");
		user.setPhoneNumber(7010847986L);

		assertDoesNotThrow(() -> {
			userservice.update(user);
		});
	}

	@Test

	public void testUpdateUserWithIdZero() {
        UserService userService = new UserService();

        Exception exception = assertThrows(Exception.class, () -> {

            User newUser = new User();
            newUser.setFullName("karthikeyan");
            newUser.setEmail("karthikn@354@gmail.com");
            newUser.setPassword("KN@354");
            newUser.setPhoneNumber(7010847986L);

            userService.update(newUser); 
        });

        String expectedMessage = "Invalid UserId";
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));
    }

	@Test
	
	public void testUpdateUserWithInvalidId() {
	    UserService userservice = new UserService();

	    Exception exception = assertThrows(Exception.class, () -> {
	        User newUser = new User();
	        newUser.setFullName("karthikeyan");
	        newUser.setEmail("karthikn@354@gmail.com");
	        newUser.setPassword("KN@354");
	        newUser.setPhoneNumber(7010847986L);

	        userservice.update(newUser); // Using an invalid ID here
	    });

	    String expectedMessage = "Invalid UserId";
	    String actualMessage = exception.getMessage();
	    assertTrue(expectedMessage.equals(actualMessage));
	}


	@Test
	public void testDeleteUserWithValidId() {
		UserService userservice = new UserService();

		assertDoesNotThrow(() -> {
			userservice.delete(4);
		});
	}

	
	

}