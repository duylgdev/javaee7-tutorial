package eu.daxiongmao.tutorial.frontend.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.commons.lang3.StringUtils;

import eu.daxiongmao.tutorial.backend.dao.db.IGenericDbDao;
import eu.daxiongmao.tutorial.model.Asset;

/**
 * Utility to convert an entity to a JSF object and vice-versa.
 * <ul>
 * <li>getAsObject() = <strong>String to Object</strong>: To retrieve an object from database using a specific String as ID</li>
 * <li>getAsString() = <strong>Object to String</strong>: To return the unique ID of the source object.<br/>
 * JSF will use this ID as reference for further use.</li>
 * </ul>
 * 
 * @author Guillaume Diaz
 * @version 1.0 - February 2014
 * @since v1.0
 */
public abstract class AbstractAssetConverter<T extends Asset> implements Converter {

	@Override
	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
		T target = null;
		if (value != null && StringUtils.isNoneBlank(value)) {
			long searchId = Long.parseLong(value);
			target = getDao().find(searchId);
		}
		return target;
	}

	@Override
	public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
		String target = StringUtils.EMPTY;
		if (value != null) {
			// Extract object ID as reference
			Long sourceId = ((T) value).getId();
			if (sourceId != null) {
				target = sourceId.toString();
			}
		}
		return target;
	}

	/** @return the backend service that will perform save / edit operation. */
	protected abstract IGenericDbDao<T> getDao();

}
