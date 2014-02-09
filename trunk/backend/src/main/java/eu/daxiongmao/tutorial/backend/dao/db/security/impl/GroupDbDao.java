package eu.daxiongmao.tutorial.backend.dao.db.security.impl;

import javax.ejb.Stateless;

import eu.daxiongmao.tutorial.backend.dao.db.AbstractAssetDbDao;
import eu.daxiongmao.tutorial.backend.dao.db.security.IGroupDbDao;
import eu.daxiongmao.tutorial.model.security.Group;

/**
 * Group database DAO.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - February 2014
 */
@Stateless(name = "groupDbDao")
public class GroupDbDao extends AbstractAssetDbDao<Group> implements IGroupDbDao {

	/** Default constructor. */
	public GroupDbDao() {
		super(Group.class);
	}

}
