package eu.daxiongmao.tutorial.backend.dao.db.asset.impl;

import javax.ejb.Stateless;

import eu.daxiongmao.tutorial.backend.dao.db.AbstractAssetDbDao;
import eu.daxiongmao.tutorial.backend.dao.db.asset.IUserDbDao;
import eu.daxiongmao.tutorial.model.asset.User;

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
