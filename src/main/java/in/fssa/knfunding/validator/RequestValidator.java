package in.fssa.knfunding.validator;

import in.fssa.knfunding.model.Request;

public class RequestValidator {

    public static boolean validate(Request request) {
        return isValidName(request.getName()) &&
               isValidDescription(request.getDescription()) &&
               isValidCategoryId(request.getCategory_id()) &&
               isValidAmount(request.getAmount());
    }

    private static boolean isValidName(String name) {
        return name != null && !name.isEmpty();
    }

    private static boolean isValidDescription(String description) {
        return description != null && description.length() >= 100; 
    }

    private static boolean isValidCategoryId(int category_id) {
        return category_id > 0; 
    }

    private static boolean isValidAmount(int amount) {
        return amount > 0; 
    }
}
