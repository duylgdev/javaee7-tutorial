package eu.daxiongmao.tutorial.frontend.pages.group;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import eu.daxiongmao.tutorial.backend.dao.db.security.IGroupDbDao;
import eu.daxiongmao.tutorial.model.security.Group;

/**
 * VIEW group controller.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - February 2014
 * @since v1.0
 */
@ManagedBean
@RequestScoped
public class GroupView {

	/** Group DAO. */
	@EJB
	private IGroupDbDao groupDAO;

	/** List to display. */
	private List<Group> groups;

	/**
	 * To delete a specific item.
	 * 
	 * @param target the item to remove
	 */
	public void delete(final Group target) {
		groupDAO.delete(target);
	}

	/**
	 * @return list of groups.
	 */
	public List<Group> getGroups() {
		groups = groupDAO.findAll();
		return groups;
	}

	/**
	 * To re-enable a specific item.
	 * 
	 * @param target the item to re-enable
	 */
	public void reEnable(final Group target) {
		groupDAO.reEnable(target);
	}

}
