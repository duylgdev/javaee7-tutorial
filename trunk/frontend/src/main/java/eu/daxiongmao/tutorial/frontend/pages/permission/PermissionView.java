package eu.daxiongmao.tutorial.frontend.pages.permission;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import eu.daxiongmao.tutorial.backend.dao.db.security.IPermissionDbDao;
import eu.daxiongmao.tutorial.model.security.Permission;

/**
 * VIEW permission controller.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - February 2014
 * @since v1.0
 */
@ManagedBean
@RequestScoped
public class PermissionView {

	/** DAO. */
	@EJB
	private IPermissionDbDao permissionDAO;

	/** List to display. */
	private List<Permission> permissions;

	/**
	 * @return list of users.
	 */
	public List<Permission> getPermissions() {
		permissions = permissionDAO.findAll();
		return permissions;
	}
}
