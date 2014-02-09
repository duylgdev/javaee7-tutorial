package eu.daxiongmao.tutorial.backend.dao.db.security.impl;

import javax.ejb.Stateless;

import eu.daxiongmao.tutorial.backend.dao.db.AbstractAssetDbDao;
import eu.daxiongmao.tutorial.backend.dao.db.security.IPermissionDbDao;
import eu.daxiongmao.tutorial.model.security.Permission;

/**
 * Permission database DAO.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - February 2014
 */
@Stateless(name = "permissionDbDao")
public class PermissionDbDao extends AbstractAssetDbDao<Permission> implements IPermissionDbDao {

	/** Default constructor. */
	public PermissionDbDao() {
		super(Permission.class);
	}

}
