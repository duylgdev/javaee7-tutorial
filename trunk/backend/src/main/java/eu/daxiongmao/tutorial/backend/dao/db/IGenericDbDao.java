package eu.daxiongmao.tutorial.backend.dao.db;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

/**
 * Generic database DAO.
 * 
 * @param <T> database entity
 * @author Guillaume Diaz
 * @version 1.0 - September 2013
 */
@Local
public interface IGenericDbDao<T extends Object> {

	/**
	 * Count the number of database entries for current object &lt;T&gt;.
	 * 
	 * @return the total records number
	 */
	int count();

	/**
	 * To delete a database entry &lt;T&gt;.<br/>
	 * In fact, the value will simply be "not active" anymore.
	 * 
	 * @param entity the entity to delete
	 */
	void delete(T entity);

	/**
	 * To find a database entry &lt;T&gt; by its ID.
	 * 
	 * @param id search ID
	 * @return find object or NULL
	 */
	T find(Long id);

	/**
	 * To retrieve all the database content for object &lt;T&gt;.
	 * 
	 * @return the list of results or empty list
	 */
	List<T> findAll();

	/**
	 * To execute a specific named query that returns a set of results - class &lt;T&gt;.
	 * 
	 * @param namedQuery the named query to execute
	 * @param parameters list of query parameters as {attribute name [String], value}
	 * @return the list of results or empty list
	 */
	List<T> findManyResults(String namedQuery, Map<String, Object> parameters);

	/**
	 * To execute a specific named query that returns a single result of class &lt;T&gt;.
	 * 
	 * @param namedQuery the named query to execute
	 * @param parameters list of query parameters as {attribute name [String], value}
	 * @return the single result or NULL
	 */
	T findOneResult(String namedQuery, Map<String, Object> parameters);

	/**
	 * Return all values from a specific database column.
	 * 
	 * @param columnName the column name to extract values from
	 * @return the column full content
	 */
	List<Object> getAllColumnValues(String columnName);

	/**
	 * To save a new entry &lt;T&gt; in database.
	 * 
	 * @param newEntity the entity to save
	 * @return the entity as it has been saved in database
	 */
	T save(T newEntity);

	/**
	 * To update a database entry &lt;T&gt;.
	 * 
	 * @param entity the entity to update (new values but same ID)
	 * @return the entity as it has been saved in database
	 */
	T update(T entity);
}
