package interfaces;

import java.util.Set;

import exception.DAOException;
import exception.ValidationException;

public interface Base<T> {

	public abstract Set<T> findAll();

	public abstract void create(T newUser) throws Exception;

	public abstract void delete(int id);

	public abstract void update(int id, T newT);

	public abstract T findById(int id) throws ValidationException, DAOException;

}