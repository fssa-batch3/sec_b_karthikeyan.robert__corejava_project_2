package in.fssa.knfunding.validator;

import in.fssa.knfunding.model.Request;

public class RequestValidator {

	/**
	 * 
	 * @param newRequest
	 * @return
	 */
    public static boolean isValid(Request newRequest) {
        if (newRequest == null) {
            System.out.println("Request is null.");
            return false;
            
        }

        if (isEmpty(newRequest.getTitle())) {
            System.out.println("Title is required.");
            return false;
        }

        if (isEmpty(newRequest.getDescription())) {
            System.out.println("Description is required.");
            return false;
        }

        if (newRequest.getCategoryId() <= 0) {
            System.out.println("Invalid category ID.");
            return false;
        }

        if (newRequest.getAmount() < 0 || !isValidAmount(newRequest.getAmount())) {
            System.out.println("Amount must be between 2500 and 1,000,000.");
            return false;
        }

        if (isEmpty(newRequest.getImg_url()) || !isValidImageUrl(newRequest.getImg_url())) {
            System.out.println("Invalid image URL.");
            return false;
        }

        return true;
    }

    private static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
    
    private static boolean isValidAmount(int amount) {
        
        return amount > 2500 && amount <= 1000000;
    }
    
    private static boolean isValidImageUrl(String imageUrl) {
       
        return imageUrl != null && (imageUrl.startsWith("http://") || imageUrl.startsWith("https://"));
    }
}

