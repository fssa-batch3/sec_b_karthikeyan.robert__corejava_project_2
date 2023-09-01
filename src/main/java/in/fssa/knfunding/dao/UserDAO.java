package in.fssa.knfunding.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import in.fssa.knfunding.model.User;
import interfaces.UserInterface;
import in.fssa.knfunding.util.*;

public class UserDAO implements UserInterface {
	/**
     * Retrieves all active users from the database.
     *
     * @return A set of active User objects.
     * @throws RuntimeException If an error occurs while fetching users.
     */
    public List<User> findAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        List<User> userArray = new ArrayList();
        ResultSet rs = null;

        try {
            String query = "SELECT * FROM user WHERE is_active = 1";
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFullName(rs.getString("full_name")); 
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhoneNumber(rs.getLong("phone_number"));
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
    
    /**
     * Creates a new user in the database.
     *
     * @param newUser The User object representing the new user to be created.
     * @throws RuntimeException If an error occurs while creating the user.
     */

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
	
	/**
     * Deactivates a user with the given ID.
     *
     * @param id The ID of the user to be deactivated.
     * @throws RuntimeException If an error occurs while deactivating the user.
     */
	
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
	
	/**
     * Updates an existing user's information in the database.
     *
     * @param id          The ID of the user to be updated.
     * @param updatedUser The updated User object.
     * @throws RuntimeException If an error occurs while updating the user.
     */
	
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
	
	/**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The User object representing the retrieved user, or null if not found.
     * @throws RuntimeException If an error occurs while finding the user by ID.
     */
	public User findById(int id) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    User user = null;

	    try {
	        conn = ConnectionUtil.getConnection();
	        String query = "SELECT * FROM user WHERE id = ?";
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            user = new User();
	            user.setId(rs.getInt("id"));
	            user.setFullName(rs.getString("full_name"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	            user.setPhoneNumber(rs.getLong("phone_number"));
	            user.setActive(rs.getBoolean("is_active"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Error while finding user by ID", e);
	    } finally {
	        ConnectionUtil.close(conn, ps, rs);
	    }

	    return user;
	}


	@Override
	
	 /**
     * Retrieves a user by their email.
     *
     * @param email The email of the user to retrieve.
     * @return The User object representing the retrieved user, or null if not found.
     * @throws RuntimeException If an error occurs while finding the user by email.
     */
	
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	


	@Override
	
	/**
     * Retrieves the count of users in the database.
     *
     * @return The total number of users.
     */
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
   
}
