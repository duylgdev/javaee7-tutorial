package eu.daxiongmao.tutorial.backend.dao.db;

import javax.ejb.Local;

import eu.daxiongmao.tutorial.model.Asset;

/**
 * Asset generic database DAO.<br/>
 * This extends the {@link IGenericDbDao}. Only the new and overrides methods are described here.<br/>
 * See {@link Asset} definition for more information.
 * 
 * @param <T> database entity. It must be an {@link Asset}
 * @author Guillaume Diaz
 * @version 1.0 - September 2013
 */
@Local
public interface IAssetDbDao<T extends Asset> extends IGenericDbDao<T> {

	/**
	 * To disable a database entry &lt;T&gt;.<br/>
	 * The &lt;T&gt; asset will simply be "not active" anymore.<br/>
	 * <strong>This will only work if T extends <code><br/>
	 * The deleted + update date will be set to the current instant.
	 * 
	 * @param entity the entity to delete
	 */
	@Override
	void delete(T entity);

	/**
	 * To re-enable a previously deleted database entry &lt;T&gt;.
	 * 
	 * @param entity the entity to re-enable
	 */
	void reEnable(T entity);

	/**
	 * To save a new entry &lt;T&gt; in database.<br/>
	 * This will set the creation + update date to the current instant.<br/>
	 * <i>Reminder</i>: the asset is "active" by default.
	 * 
	 * @param newEntity the entity to save
	 * @return the entity as it has been saved in database
	 */
	@Override
	T save(T newEntity);

	/**
	 * To update a database entry &lt;T&gt;.<br/>
	 * This will adjust the update date to the current instant.
	 * 
	 * @param entity the entity to update (new values but same ID)
	 * @return the entity as it has been saved in database
	 */
	@Override
	T update(T entity);
}
