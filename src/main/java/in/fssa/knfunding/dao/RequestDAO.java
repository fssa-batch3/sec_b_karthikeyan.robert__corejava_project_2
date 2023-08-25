package in.fssa.knfunding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

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
            String query = "INSERT INTO requests (title, description, category_id, amount) VALUES (?, ?, ?, ?)";
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, newRequest.getTitle());
            ps.setString(2, newRequest.getDescription());
            ps.setInt(3, newRequest.getCategoryId());
            ps.setInt(4, newRequest.getAmount());
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
    
    public void update(int id, Request updatedRequest) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String query = "UPDATE requests SET title=?, description=?, category_id=?, amount=? WHERE id=?";
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, updatedRequest.getTitle());
            ps.setString(2, updatedRequest.getDescription());
            ps.setInt(3, updatedRequest.getCategoryId());
            ps.setInt(4, updatedRequest.getAmount());
            ps.setInt(5, id);

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Request with ID " + id + " has been updated successfully.");
            } else {
                System.out.println("Request with ID " + id + " not found.");
            }

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
    
    public void delete(int id) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String query = "DELETE FROM requests WHERE id=?";
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Request with ID " + id + " has been deleted successfully.");
            } else {
                System.out.println("Request with ID " + id + " not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while deleting request: " + e.getMessage());
            throw new RuntimeException();
        } finally {
            in.fssa.knfunding.util.ConnectionUtil.close(conn, ps);
        }
    }

    
    /**
     * 
     * @return
     */
    

    public Set<Request> findAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        Set<Request> requestSet = new HashSet<>();

        try {
            String query = "SELECT * FROM requests";
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Request request = new Request();
                request.setId(rs.getInt("id"));
                request.setTitle(rs.getString("title"));
                request.setDescription(rs.getString("description"));
                request.setCategoryId(rs.getInt("category_id"));
                request.setAmount(rs.getInt("amount"));
                requestSet.add(request);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while retrieving requests: " + e.getMessage());
            throw new RuntimeException();
        } finally {
            ConnectionUtil.close(conn, ps);
        }

        return requestSet;
    }


    /**
     * Retrieves a set of requests by their associated category ID.
     *
     * @param categoryId The ID of the category for which to retrieve requests.
     * @return A set of Request objects associated with the given category ID.
     * @throws RuntimeException If an error occurs while retrieving requests by category ID.
     */
    public Set<Request> findByCategoryId(int categoryId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set<Request> requestSet = new HashSet<>();

        try {
            conn = ConnectionUtil.getConnection();
            String query = "SELECT * FROM requests WHERE category_id = ?";
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
            String query = "SELECT * FROM requests WHERE id = ?";
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
    
    public void retriveDelete(int id) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String query = "DELETE FROM requests WHERE id=?";
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Request with ID " + id + " has been deleted successfully.");
            } else {
                System.out.println("Request with ID " + id + " not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while deleting request: " + e.getMessage());
            throw new RuntimeException();
        } finally {
            in.fssa.knfunding.util.ConnectionUtil.close(conn, ps);
        }
    }




}
