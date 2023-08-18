package in.fssa.knfunding.validator;

import in.fssa.knfunding.model.Request;

public class RequestValidator {
	/**
	 * 
	 * @param request
	 * @return
	 */
    public static boolean validate(Request request) {
        return isValidName(request.getName()) &&
               isValidDescription(request.getDescription()) &&
               isValidCategoryId(request.getCategory_id()) &&
               isValidAmount(request.getAmount());
    }
/**
 * 
 * @param name
 * @return
 */
    private static boolean isValidName(String name) {
        return name != null && !name.isEmpty();
    }
/**
 * 
 * @param description
 * @return
 */
    private static boolean isValidDescription(String description) {
        return description != null && description.length() >= 100; 
    }
/**
 * 
 * @param category_id
 * @return
 */
    private static boolean isValidCategoryId(int category_id) {
        return category_id > 0; 
    }
/**
 * 
 * @param amount
 * @return
 */
    private static boolean isValidAmount(int amount) {
        return amount > 0; 
    }
}
