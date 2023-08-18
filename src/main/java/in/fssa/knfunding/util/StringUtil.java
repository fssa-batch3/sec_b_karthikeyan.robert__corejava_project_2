package in.fssa.knfunding.util;

import java.time.LocalDate;

import exception.ValidationException;

public class StringUtil {
	public static void rejectIfInvalidString(String input , String inputName) throws ValidationException{
		if(input == null || "".equals(input.trim())) {
			throw new ValidationException(inputName.concat(" cannot be null or empty"));
		}
	}
	
	public static void rejectIfInvalidDate(LocalDate newdate,String inputName) throws ValidationException {
		LocalDate currentDate = LocalDate.now();
		if(newdate.isBefore(currentDate)) {
			throw new ValidationException(inputName.concat(" cannot be past"));
			
		}
	}
	
	
	
	
	
	
	public static boolean isValidString(String input) {
		if(input == null || "".equals(input.trim())) {
			return false;
		}
		return true;
	}

	public static boolean isInValidString(String input) {
		if(input != null) {
			return true;
		}
		return false;
	}
}
