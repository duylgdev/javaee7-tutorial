package eu.daxiongmao.tutorial.backend.dao.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Generic database DAO implementation.<br/>
 * Do NOT put any method "final" nor the getEntityManager() !! This will break the application !!
 * 
 * @param <T> database entity
 * @author Guillaume Diaz
 * @version 1.0 - September 2013
 */
public abstract class AbstractGenericDbDao<T extends Object> implements IGenericDbDao<T> {

	/** Class logger. */
	private static final Logger LOGGER = Logger.getLogger(AbstractGenericDbDao.class.getName());

	/** Persistence unit name. */
	private static final String PERSISTENCE_UNIT = "tutorialJeePU";

	/** Persistence context. */
	@PersistenceContext(unitName = PERSISTENCE_UNIT)
	private EntityManager em;

	/** Entity class. */
	private Class<T> entityClass;

	/**
	 * To create a new DAO instance using a dedicated entity.
	 * 
	 * @param entityClass entity to bind
	 */
	protected AbstractGenericDbDao(final Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public int count() {
		Query q = em.createQuery("SELECT COUNT(obj) FROM " + entityClass.getSimpleName() + " obj");
		Long nbRows = (Long) q.getSingleResult();
		return nbRows.intValue();
	}

	@Override
	public void delete(final T entity) {
		if (entity == null) {
			throw new IllegalArgumentException("Unable to delete a NULL object.");
		}

		// To remove the row from database [you first need to merge it to avoid "detached"]
		T targetEntity = em.merge(entity);
		em.remove(targetEntity);

		LOGGER.log(Level.FINE, String.format("Object deleted. Class: '%s' | Element: %s", this.entityClass.getName(), entity));
	}

	@Override
	public T find(final Long id) {
		return em.find(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		// HQL: SELECT * FROM clazz
		CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(entityClass);
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findManyResults(final String namedQuery, final Map<String, Object> parameters) {
		Query query = em.createNamedQuery(namedQuery);
		// Method that will populate parameters if they are passed not null and empty
		if (parameters != null && !parameters.isEmpty()) {
			populateQueryParameters(query, parameters);
		}
		List<T> results = query.getResultList();
		if (results == null) {
			results = new ArrayList<T>();
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findOneResult(final String namedQuery, final Map<String, Object> parameters) {
		T result = null;
		Query query = em.createNamedQuery(namedQuery);
		// Method that will populate parameters if they are passed not null and empty
		if (parameters != null && !parameters.isEmpty()) {
			populateQueryParameters(query, parameters);
		}
		result = (T) query.getSingleResult();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAllColumnValues(final String columnName) {
		String queryStr = "SELECT DISTINCT obj." + columnName + " FROM " + entityClass.getSimpleName() + " obj ORDER BY obj." + columnName;
		Query query = em.createQuery(queryStr);
		return query.getResultList();
	}

	/**
	 * @return {@link #entityClass}
	 */
	protected final Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @return the current javax.persistence.EntityManager > mean to access database.
	 */
	protected EntityManager getEntityManager() {
		return em;
	}

	/**
	 * Build generic query using a list of {attribute name [String], value}.
	 * 
	 * @param query the query to update with the given list of {attribute, value}
	 * @param parameters List of {attribute name, value}
	 */
	private void populateQueryParameters(final Query query, final Map<String, Object> parameters) {
		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public T save(final T newEntity) {
		if (newEntity == null) {
			throw new IllegalArgumentException("Unable to create a NULL object.");
		}

		// Save entity
		em.persist(newEntity);

		LOGGER.log(Level.FINE, String.format("An object type %s has been saved: %s", this.entityClass.getName(), newEntity));
		return newEntity;
	}

	@Override
	public T update(final T entity) {
		if (entity == null) {
			throw new IllegalArgumentException("Unable to update a NULL object.");
		}

		LOGGER.log(Level.FINE, String.format("Object updated. Class: '%s' | Element: %s", this.entityClass.getName(), entity));
		return em.merge(entity);
	}
}
