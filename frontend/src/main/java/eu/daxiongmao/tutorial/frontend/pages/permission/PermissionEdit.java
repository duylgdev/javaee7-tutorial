package eu.daxiongmao.tutorial.frontend.pages.permission;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import eu.daxiongmao.tutorial.backend.dao.db.IGenericDbDao;
import eu.daxiongmao.tutorial.backend.dao.db.security.IPermissionDbDao;
import eu.daxiongmao.tutorial.frontend.pages.AbstractAssetEdit;
import eu.daxiongmao.tutorial.model.security.Permission;

/**
 * EDIT / ADD permission controller.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - February 2014
 * @since v1.0
 */
@ManagedBean
@RequestScoped
public class PermissionEdit extends AbstractAssetEdit<Permission> {

	/** DAO. */
	@EJB
	private IPermissionDbDao permissionDAO;

	/** Default constructor that binds an object. */
	public PermissionEdit() {
		super(Permission.class);
	}

	@Override
	protected IGenericDbDao<Permission> getDao() {
		return permissionDAO;
	}

	@Override
	protected String getSuccessPage() {
		return "/pages/permission/permissionsView.xhtml?faces-redirect=true";
	}

}
