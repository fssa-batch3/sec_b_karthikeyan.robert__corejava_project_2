package interfaces;

import java.util.List;
import java.util.Set;

import exception.DAOException;
import exception.ValidationException;
import in.fssa.knfunding.model.User;

public interface Base<T> {

	public abstract List<User> findAll();

	public abstract void create(T newUser) throws Exception;

	public abstract void delete(int id);

	public abstract void update(int id, T newT);

	public abstract T findById(int id) throws ValidationException, DAOException;

}