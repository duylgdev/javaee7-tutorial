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
	 * @return list of groups.
	 */
	public List<Group> getGroups() {
		groups = groupDAO.findAll();
		return groups;
	}
}
