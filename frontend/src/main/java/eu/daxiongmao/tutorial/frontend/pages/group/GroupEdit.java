package eu.daxiongmao.tutorial.frontend.pages.group;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import eu.daxiongmao.tutorial.backend.dao.db.IGenericDbDao;
import eu.daxiongmao.tutorial.backend.dao.db.security.IGroupDbDao;
import eu.daxiongmao.tutorial.frontend.pages.AbstractAssetEdit;
import eu.daxiongmao.tutorial.model.security.Group;

/**
 * Edit group controller.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - February 2014
 * @since v1.0
 */
@ManagedBean
@RequestScoped
public class GroupEdit extends AbstractAssetEdit<Group> {

	/** DAO. */
	@EJB
	private IGroupDbDao groupDAO;

	/** Default constructor that binds an object. */
	public GroupEdit() {
		super(Group.class);
	}

	@Override
	protected IGenericDbDao<Group> getDao() {
		return groupDAO;
	}

	@Override
	protected String getSuccessPage() {
		return "/pages/group/groupsView.xhtml?faces-redirect=true";
	}

}
