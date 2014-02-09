package eu.daxiongmao.tutorial.frontend.converter.common;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import eu.daxiongmao.tutorial.backend.dao.db.IGenericDbDao;
import eu.daxiongmao.tutorial.backend.dao.db.common.IUserDbDao;
import eu.daxiongmao.tutorial.frontend.converter.AbstractAssetConverter;
import eu.daxiongmao.tutorial.model.common.User;

/**
 * User converter.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - February 2014
 * @since v1.0
 */
@ManagedBean
public class UserConverter extends AbstractAssetConverter<User> {

	/** DAO. */
	@EJB
	private IUserDbDao dao;

	@Override
	protected IGenericDbDao<User> getDao() {
		return dao;
	}

}
