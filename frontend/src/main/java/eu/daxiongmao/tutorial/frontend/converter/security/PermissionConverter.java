package eu.daxiongmao.tutorial.frontend.converter.security;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import eu.daxiongmao.tutorial.backend.dao.db.IGenericDbDao;
import eu.daxiongmao.tutorial.backend.dao.db.security.IPermissionDbDao;
import eu.daxiongmao.tutorial.frontend.converter.AbstractAssetConverter;
import eu.daxiongmao.tutorial.model.security.Permission;

/**
 * Permission converter.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - February 2014
 * @since v1.0
 */
@ManagedBean
public class PermissionConverter extends AbstractAssetConverter<Permission> {

	/** Backend service. */
	@EJB
	private IPermissionDbDao permissionDao;

	@Override
	protected IGenericDbDao<Permission> getDao() {
		return permissionDao;
	}

}
