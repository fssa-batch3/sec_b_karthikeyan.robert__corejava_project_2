package in.fssa.knfunding.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import exception.ValidationException;
import in.fssa.knfunding.model.Request;
import in.fssa.knfunding.util.ConnectionUtil;

public class RequestDAO {

	/**
	 * 
	 * @param newRequest
	 */
	 
	
	
	
	public void create(Request newRequest) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    

	    try {
	        String query = "INSERT INTO requests (title, description, category_id, amount, img_url,user_id) VALUES (?, ?, ?, ?, ?, ?)";
	        conn = ConnectionUtil.getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setString(1, newRequest.getTitle());
	        ps.setString(2, newRequest.getDescription());
	        ps.setInt(3, newRequest.getCategoryId());
	        ps.setInt(4, newRequest.getAmount());
	        ps.setString(5, newRequest.getImg_url());
	        ps.setInt(6, newRequest.getUser_id());
	       
	        ps.executeUpdate();

	        System.out.println("Request has been created successfully");

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error while creating request: " + e.getMessage());
	        throw new RuntimeException();
	    } finally {
	        ConnectionUtil.close(conn, ps);
	    }
	}


    
    
    /**
     * 
     * @param id
     * @param updatedRequest
     */
    
	public void update(int requestId, Request updatedRequest) throws ValidationException {
	    update(requestId, updatedRequest.getTitle(), updatedRequest.getDescription(),
	           updatedRequest.getCategoryId(), updatedRequest.getAmount());
	}

	public void update(int requestId, String title, String description, int categoryId, int amount) throws ValidationException {
	    Connection conn = null;
	    PreparedStatement ps = null;

	    try {
	        String query = "UPDATE requests SET title = ?, description = ?, category_id = ?, amount = ? WHERE id = ?";
	        conn = ConnectionUtil.getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setString(1, title);
	        ps.setString(2, description);
	        ps.setInt(3, categoryId);
	        ps.setInt(4, amount);
	        ps.setInt(5, requestId);

	        int rowsAffected = ps.executeUpdate();

	        if (rowsAffected == 0) {
	            throw new ValidationException("No request found with id: " + requestId);
	        }

	        System.out.println("Request has been updated successfully");

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error while updating request: " + e.getMessage());
	        throw new RuntimeException();
	    } finally {
	        ConnectionUtil.close(conn, ps);
	    }
	}

    
    /**
     * 
     * @param id
     */
    
	public void delete(int requestId) {
	    Connection conn = null;
	    PreparedStatement ps = null;

	    try {
	        String query = "UPDATE requests SET is_active = false WHERE id = ?";
	        conn = ConnectionUtil.getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, requestId);

	        int rowsAffected = ps.executeUpdate();

	        if (rowsAffected == 0) {
	            System.out.println("No request found with id: " + requestId);
	        } else {
	            System.out.println("Request has been deleted successfully");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error while deleting request: " + e.getMessage());
	        throw new RuntimeException();
	    } finally {
	        ConnectionUtil.close(conn, ps);
	    }
	}   
    /**
     * 
     * @return
     */
   
//	public List<Request> findAll() {
//	    List<Request> requestList = new ArrayList<>();
//	    Connection conn = null;
//	    PreparedStatement ps = null;
//	    ResultSet rs = null;
//
//	    try {
//	        String query = "SELECT * FROM requests WHERE is_active = true";
//	        conn = ConnectionUtil.getConnection();
//	        ps = conn.prepareStatement(query);
//	        rs = ps.executeQuery();
//
//	        while (rs.next()) {
//	            Request request = new Request();
//	            request.setId(rs.getInt("id"));
//	            request.setTitle(rs.getString("title"));
//	            request.setDescription(rs.getString("description"));
//	            request.setCategoryId(rs.getInt("category_id"));
//	            request.setImg_url(rs.getString("img_url"));
//	            request.setAmount(rs.getInt("amount"));
//	            request.setActive(true);
//	            requestList.add(request);
//	        }
//
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	        System.out.println("Error while fetching requests: " + e.getMessage());
//	        throw new RuntimeException();
//	    } finally {
//	        ConnectionUtil.close(conn, ps, rs);
//	    }
//
//	    return requestList;
//	}
	
	public List<Request> findAll() {
        List<Request> requestList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "SELECT r.id, r.title, r.description, r.category_id, r.img_url, r.amount, c.name " +
                           "FROM requests r " +
                           "INNER JOIN category c ON r.category_id = c.id " +
                           "WHERE r.is_active = true";
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Request request = new Request();
                request.setId(rs.getInt("id"));
                request.setTitle(rs.getString("title"));
                request.setDescription(rs.getString("description"));
                request.setCategoryId(rs.getInt("category_id"));
                request.setCategory_name(rs.getString("name")); 
                request.setImg_url(rs.getString("img_url"));
                request.setAmount(rs.getInt("amount"));
                request.setActive(true);
                requestList.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while fetching requests with categories: " + e.getMessage());
            throw new RuntimeException();
        } finally {
            ConnectionUtil.close(conn, ps, rs);
        }

        return requestList;
    }


    /**
     * Retrieves a set of requests by their associated category ID.
     *
     * @param categoryId The ID of the category for which to retrieve requests.
     * @return A set of Request objects associated with the given category ID.
     * @throws RuntimeException If an error occurs while retrieving requests by category ID.
     */
	public List<Request> findByCategoryId(int categoryId) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    List<Request> requestSet = new ArrayList<>();

	    try {
	        conn = ConnectionUtil.getConnection();
	        String query = "SELECT * FROM requests WHERE category_id = ? AND is_active = true";
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, categoryId);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            Request request = new Request();
	            request.setId(rs.getInt("id"));
	            request.setTitle(rs.getString("title"));
	            request.setDescription(rs.getString("description"));
	            requestSet.add(request);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Error while retrieving requests by category ID", e);
	    } finally {
	        ConnectionUtil.close(conn, ps, rs);
	    }

	    return requestSet;
	}

    
    /**
     * 
     * @param requestId
     * @return
     */
	public Request findById(int requestId) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    Request request = null;

	    try {
	        String query = "SELECT * FROM requests WHERE id = ? AND is_active = true";
	        conn = ConnectionUtil.getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, requestId);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            request = new Request();
	            request.setId(rs.getInt("id"));
	            request.setTitle(rs.getString("title"));
	            request.setDescription(rs.getString("description"));
	            request.setCategoryId(rs.getInt("category_id"));
	            request.setAmount(rs.getInt("amount"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error while retrieving request by ID: " + e.getMessage());
	        throw new RuntimeException();
	    } finally {
	        ConnectionUtil.close(conn, ps);
	    }

	    return request;
	}
	
	
	public List<Request> findByUserId(int userId) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    List<Request> requests = new ArrayList<>();

	    try {
	        String query = "SELECT * FROM requests WHERE user_id = ? AND is_active = true";
	        conn = ConnectionUtil.getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, userId);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Request request = new Request();
	            request.setId(rs.getInt("id"));
	            request.setTitle(rs.getString("title"));
	            request.setDescription(rs.getString("description"));
	            request.setCategoryId(rs.getInt("category_id"));
	            request.setImg_url(rs.getString("img_url"));
	            request.setAmount(rs.getInt("amount"));
	            // Add more fields as needed

	            requests.add(request);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error while retrieving requests by User ID: " + e.getMessage());
	        throw new RuntimeException();
	    } finally {
	        ConnectionUtil.close(conn, ps);
	    }

	    return requests;
	}





}
