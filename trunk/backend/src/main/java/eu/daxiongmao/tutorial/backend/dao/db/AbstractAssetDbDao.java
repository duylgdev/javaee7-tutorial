package eu.daxiongmao.tutorial.backend.dao.db;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import eu.daxiongmao.tutorial.model.Asset;

/**
 * Asset generic database DAO implementation.<br/>
 * Do NOT put any method "final" nor the getEntityManager() !! This will break the application !!
 * 
 * @param <T> database entity. It must be an {@link Asset}
 * @author Guillaume Diaz
 * @version 1.0 - September 2013
 */
public abstract class AbstractAssetDbDao<T extends Asset> extends AbstractGenericDbDao<T> implements IAssetDbDao<T> {

	/** Class logger. */
	private static final Logger LOGGER = Logger.getLogger(AbstractAssetDbDao.class.getName());

	/**
	 * To create a new DAO instance using a dedicated entity.
	 * 
	 * @param entityClass entity to bind
	 */
	protected AbstractAssetDbDao(final Class<T> entityClass) {
		super(entityClass);
	}

	@Override
	public void delete(final T entity) {
		if (entity == null) {
			throw new IllegalArgumentException("Unable to delete a NULL object.");
		}

		// set flags
		entity.setActive(false);
		entity.setDeteled(new Date());

		// Disable entity
		update(entity);

		LOGGER.log(Level.FINE, String.format("Asset %s has been disabled.%n%s", getEntityClass().getName(), entity));
	}

	@Override
	public void reEnable(final T entity) {
		if (entity == null) {
			throw new IllegalArgumentException("Unable to re-enable a NULL object.");
		}
		// if already active: nothing to do :)
		if (!entity.isActive()) {
			// set flags
			entity.setActive(true);
			entity.setDeteled(null);

			// Disable entity
			update(entity);

			LOGGER.log(Level.FINE, String.format("Asset %s has been re-enable.%n%s", getEntityClass().getName(), entity));
		}

	}

	@Override
	public T save(final T newEntity) {
		if (newEntity == null) {
			throw new IllegalArgumentException("Unable to create a NULL object.");
		}

		// Set flags
		newEntity.setCreated(new Date());
		newEntity.setUpdated(new Date());

		// Save entity
		LOGGER.log(Level.FINE, String.format("Attempt to save asset: %s - %s", getEntityClass().getName(), newEntity));
		getEntityManager().persist(newEntity);

		LOGGER.log(Level.FINE, String.format("Asset %s has been saved.%n%s", getEntityClass().getName(), newEntity));
		return newEntity;
	}

	@Override
	public T update(final T entity) {
		if (entity == null) {
			throw new IllegalArgumentException("Unable to update a NULL object.");
		}

		// Set flags
		entity.setUpdated(new Date());

		LOGGER.log(Level.FINE, String.format("Asset %s updated.%n%s", getEntityClass().getName(), entity));
		return getEntityManager().merge(entity);
	}

}
