package eu.daxiongmao.tutorial.frontend.pages.user;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import eu.daxiongmao.tutorial.backend.dao.db.common.IUserDbDao;
import eu.daxiongmao.tutorial.model.common.User;

/**
 * VIEW user controller.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - February 2014
 * @since v1.0
 */
@ManagedBean
@RequestScoped
public class UserView {

	/** User DAO. */
	@EJB
	private IUserDbDao userDAO;

	/** User list to display. */
	private List<User> users;

	/**
	 * To delete a specific item.
	 * 
	 * @param target the item to remove
	 */
	public void delete(final User target) {
		userDAO.delete(target);
	}

	/**
	 * To disable a specific item.
	 * 
	 * @param target the item to disable
	 */
	public void disable(final User target) {
		userDAO.disable(target);
	}

	/**
	 * @return list of users.
	 */
	public List<User> getUsers() {
		users = userDAO.findAll();
		return users;
	}

	/**
	 * To re-enable a specific item.
	 * 
	 * @param target the item to re-enable
	 */
	public void reEnable(final User target) {
		userDAO.reEnable(target);
	}
}
