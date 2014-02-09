package eu.daxiongmao.tutorial.frontend.pages;

import eu.daxiongmao.tutorial.backend.dao.db.IGenericDbDao;
import eu.daxiongmao.tutorial.model.Asset;

/**
 * Generic controller to edit a database object.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - February 2014
 * @since v1.0
 * @param <T> asset entity to edit.
 */
public abstract class AbstractAssetEdit<T extends Asset> {

	/** Object to edit. */
	private T obj;

	/** Object class. */
	private Class<T> objClass;

	/**
	 * To generate an edit page for a dedicated entity.
	 * 
	 * @param objClass entity to bind
	 */
	protected AbstractAssetEdit(final Class<T> objClass) {
		this.objClass = objClass;
	}

	/** @return the backend service that will perform save / edit operation. */
	protected abstract IGenericDbDao<T> getDao();

	/**
	 * @return the object to edit.
	 */
	public T getObj() {
		if (obj == null) {
			try {
				obj = objClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				throw new IllegalArgumentException(e);
			}
		}
		return obj;
	}

	/** @return success page to display - in JSF format. */
	protected abstract String getSuccessPage();

	/**
	 * To save (create or update) the object.
	 * 
	 * @return the success page to display.
	 */
	public String save() {
		if (obj.getId() == null) {
			obj = getDao().save(obj);
		} else {
			getDao().update(obj);
		}

		return getSuccessPage();
	}

	/**
	 * @param obj the object to edit to set
	 */
	public void setObj(final T obj) {
		this.obj = obj;
	}
}
