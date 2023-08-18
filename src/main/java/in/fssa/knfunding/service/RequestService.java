package in.fssa.knfunding.service;

import java.util.Set;

import in.fssa.knfunding.model.Request;
import in.fssa.knfunding.dao.RequestDAO;

public class RequestService {

    private RequestDAO requestDAO;

    public RequestService() {
        requestDAO = new RequestDAO();
    }

    public Set<Request> getAllRequests() {
        try {
            return requestDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while retrieving requests", e);
        }
    }

    public Set<Request> getRequestsByCategoryId(int categoryId) {
        try {
            return requestDAO.findByCategoryId(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while retrieving requests by category", e);
        }
    }

    public Request getRequestById(int requestId) {
        try {
            return requestDAO.findById(requestId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while retrieving request by ID", e);
        }
    }

    public void createRequest(Request request) {
        try {
            requestDAO.create(request);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while creating request", e);
        }
    }

    public void updateRequest(int requestId, Request updatedRequest) {
        try {
            requestDAO.update(requestId, updatedRequest);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while updating request", e);
        }
    }

    public void deleteRequest(int requestId) {
        try {
            requestDAO.delete(requestId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while deleting request", e);
        }
    }
}
