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
	 * @return list of users.
	 */
	public List<User> getUsers() {
		users = userDAO.findAll();
		return users;
	}
}
