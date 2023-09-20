package in.fssa.knfunding.service;

import java.util.List;

import in.fssa.knfunding.model.Request;
import in.fssa.knfunding.dao.RequestDAO;

public class RequestService {
    private RequestDAO requestDAO;

    
    public RequestService() {
        requestDAO = new RequestDAO();
    }
    
    

    public List<Request> getAllRequests() {
        try {
            return requestDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while retrieving requests", e);
        }
    }

    
    
    
    public List<Request> getRequestsByCategoryId(int categoryId) {
        try {
            return requestDAO.findByCategoryId(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while retrieving requests by category", e);
        }
    }
/**
 * 
 * @param request
 */
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
        // Validation checks
    }

    public void updateRequest(int requestId, Request updatedRequest) {
        validateRequest(updatedRequest);

        try {
            Request existingRequest = requestDAO.findById(requestId);
            if (existingRequest == null) {
                throw new RuntimeException("Request not found.");
            }

            updatedRequest.setId(requestId);
            requestDAO.update(requestId, updatedRequest);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while updating request", e);
        }
    }

    public void deleteRequest(int requestId) {
        try {
            Request existingRequest = requestDAO.findById(requestId);
            if (existingRequest == null) {
                throw new RuntimeException("Request not found.");
            }

            requestDAO.delete(requestId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while deleting request", e);
        }
    }

    public Request findById(int requestId) {
        try {
            return requestDAO.findById(requestId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while retrieving request by ID", e);
        }
    }
    
    
    public List<Request> getRequestsByUserId(int userId) {
        try {
            return requestDAO.findByUserId(userId); // Call the DAO method
        } catch (Exception e) {
            // Handle exceptions appropriately (e.g., log, throw custom exception)
            e.printStackTrace();
            throw new RuntimeException("Error while getting requests by User ID: " + e.getMessage());
        }
    }
}
