package eu.daxiongmao.tutorial.frontend.converter.security;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import eu.daxiongmao.tutorial.backend.dao.db.IGenericDbDao;
import eu.daxiongmao.tutorial.backend.dao.db.security.IGroupDbDao;
import eu.daxiongmao.tutorial.frontend.converter.AbstractAssetConverter;
import eu.daxiongmao.tutorial.model.security.Group;

/**
 * Group converter.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - February 2014
 * @since v1.0
 */
@ManagedBean
public class GroupConverter extends AbstractAssetConverter<Group> {

	/** Backend service. */
	@EJB
	private IGroupDbDao groupDao;

	@Override
	protected IGenericDbDao<Group> getDao() {
		return groupDao;
	}

}
