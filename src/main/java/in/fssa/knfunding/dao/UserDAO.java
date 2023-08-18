package in.fssa.knfunding.dao;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import in.fssa.knfunding.model.User;
import interfaces.UserInterface;
import in.fssa.knfunding.util.*;

public class UserDAO implements UserInterface {

    public Set<User> findAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        Set<User> userArray = new HashSet<>();
        ResultSet rs = null;

        try {
            String query = "SELECT * FROM users WHERE is_active = 1";
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFullName(rs.getString("full_name")); 
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setActive(rs.getBoolean("is_active"));
                userArray.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while fetching users", e);
        } finally {
            ConnectionUtil.close(conn, ps, rs);
        }

        return userArray;
    }
    
    @Override 

    public void create(User newUser) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String query = "INSERT INTO user (full_name, email, password, phone_number) VALUES (?, ?, ?, ?)";
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,newUser.getFullName());
            ps.setString(2, newUser.getEmail());
            ps.setString(3, newUser.getPassword());
            ps.setLong(4, newUser.getPhoneNumber());
            ps.executeUpdate();

            System.out.println("User has been created successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while creating user", e);
        } finally {
            ConnectionUtil.close(conn, ps);
        }
    }

	@Override
	
	public void delete(int id) {
	    Connection conn = null;
	    PreparedStatement ps = null;

	    try {
	        String query = "UPDATE user SET is_active = 0 WHERE id = ?";
	        conn = ConnectionUtil.getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, id);

	        int rowsUpdated = ps.executeUpdate();

	        if (rowsUpdated > 0) {
	            System.out.println("User with ID " + id + " has been deactivated successfully.");
	        } else {
	            System.out.println("User with ID " + id + " not found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Error while deactivating user", e);
	    } finally {
	        ConnectionUtil.close(conn, ps);
	    }
	}


	@Override
	public void update(int id, User updatedUser) {
	    Connection conn = null;
	    PreparedStatement ps = null;

	    try {
	        String query = "UPDATE user SET full_name = ?, email = ?, password = ? WHERE id = ? AND is_active = 1";
	        conn = ConnectionUtil.getConnection();
	        ps = conn.prepareStatement(query);

	        ps.setString(1, (String) updatedUser.getFullName());
	        ps.setString(2, updatedUser.getEmail());
	        ps.setString(3, updatedUser.getPassword());
	        ps.setInt(4, id);

	        int rowsUpdated = ps.executeUpdate();

	        if (rowsUpdated > 0) {
	            System.out.println("User with ID " + id + " has been updated successfully.");
	        } else {
	            System.out.println("User with ID " + id + " not found or not active.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Error while updating user", e);
	    } finally {
	        ConnectionUtil.close(conn, ps);
	    }
	}


	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
   
}
