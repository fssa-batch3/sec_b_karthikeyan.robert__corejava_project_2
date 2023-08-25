package in.fssa.knfunding.service;

import java.util.Set;

import in.fssa.knfunding.model.Request;
import in.fssa.knfunding.dao.RequestDAO;

public class RequestService {
	/**
	 * 
	 */

    private RequestDAO requestDAO;

    public RequestService() {
        requestDAO = new RequestDAO();
    }

    /**
     * 
     * @return
     */
    public Set<Request> getAllRequests() {
        try {
            return requestDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while retrieving requests", e);
        }
    }
    
    /**
     * 
     * @param categoryId
     * @return
     */

    public Set<Request> getRequestsByCategoryId(int categoryId) {
        try {
            return requestDAO.findByCategoryId(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while retrieving requests by category", e);
        }
    }


    public RequestService(RequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void createRequest(Request request) {
        validateRequest(request);

        try {
            requestDAO.create(request);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while creating request", e);
        }
    }

    private void validateRequest(Request request) {
        if (request.getTitle() == null || request.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        
        if (request.getDescription() == null || request.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        
        if (request.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be a positive value");
        }
        
        if (request.getCategoryId() <= 0) {
            throw new IllegalArgumentException("Invalid category ID");
        }
    }
    
    public void updateRequest(int requestId, Request updatedRequest) {
        validateRequest(updatedRequest);

        try {
            requestDAO.update(requestId, updatedRequest);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while updating request", e);
        }
    }

    /**
     * 
     * @param requestId
     */
    public void deleteRequest(int requestId) {
        Request existingRequest = requestDAO.findById(requestId);
        if (existingRequest == null) {
            throw new RuntimeException("Request not found.");
        }

        try {
            requestDAO.delete(requestId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while deleting request", e);
        }
    }

   
    /**
     * 
     * @param requestId
     * @return
     */
	
    public Request findById(int requestId) {
        try {
            return requestDAO.findById(requestId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while retrieving request by ID", e);
        }
    }

}
