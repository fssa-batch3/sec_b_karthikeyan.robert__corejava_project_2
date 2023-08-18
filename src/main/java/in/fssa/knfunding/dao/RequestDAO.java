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

	
	
    public void create(Request newRequest) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String query = "INSERT INTO requests (name, description, category_id, amount) VALUES (?, ?, ?, ?)";
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, newRequest.getName());
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

    
    
    
    
    public void update(int id, Request updatedRequest) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String query = "UPDATE requests SET name=?, description=?, category_id=?, amount=? WHERE id=?";
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, updatedRequest.getName());
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
                request.setName(rs.getString("name"));
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





	public Set<Request> findByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}





	public Request findById(int requestId) {
		// TODO Auto-generated method stub
		return null;
	}


}
