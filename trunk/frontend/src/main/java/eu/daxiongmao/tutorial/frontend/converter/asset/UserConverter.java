package eu.daxiongmao.tutorial.frontend.converter.asset;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.commons.lang3.StringUtils;

import eu.daxiongmao.tutorial.backend.dao.db.asset.IUserDbDao;
import eu.daxiongmao.tutorial.model.asset.User;

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
@ManagedBean
public class UserConverter implements Converter {

	/** Backend service. */
	@EJB
	private IUserDbDao userDao;

	@Override
	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
		User target = null;
		if (value != null && StringUtils.isNoneBlank(value)) {
			long searchId = Long.parseLong(value);
			target = userDao.find(searchId);
		}
		return target;
	}

	@Override
	public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
		String target = StringUtils.EMPTY;
		if (value != null) {
			// Extract object ID as reference
			Long sourceId = ((User) value).getId();
			if (sourceId != null) {
				target = sourceId.toString();
			}
		}
		return target;
	}

}
