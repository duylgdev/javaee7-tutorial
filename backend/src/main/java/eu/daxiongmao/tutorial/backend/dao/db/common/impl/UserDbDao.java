package eu.daxiongmao.tutorial.backend.dao.db.common.impl;

import javax.ejb.Stateless;

import eu.daxiongmao.tutorial.backend.dao.db.AbstractAssetDbDao;
import eu.daxiongmao.tutorial.backend.dao.db.common.IUserDbDao;
import eu.daxiongmao.tutorial.model.common.User;

/**
 * User database DAO.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - January 2014
 */
@Stateless(name = "userDbDao")
public class UserDbDao extends AbstractAssetDbDao<User> implements IUserDbDao {

	/** Default constructor. */
	public UserDbDao() {
		super(User.class);
	}

}
