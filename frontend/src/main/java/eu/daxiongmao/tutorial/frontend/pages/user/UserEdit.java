package eu.daxiongmao.tutorial.frontend.pages.user;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.lang3.StringUtils;

import eu.daxiongmao.tutorial.backend.dao.db.asset.IUserDbDao;
import eu.daxiongmao.tutorial.model.asset.User;

/**
 * EDIT / ADD user controller.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - February 2014
 * @since v1.0
 */
@ManagedBean
@RequestScoped
public class UserEdit {

	/** User to edit. */
	private User currentUser;

	/** New password. */
	private String password;

	/** New password confirmation. */
	private String passwordConfirmation;

	/** User DAO. */
	@EJB
	private IUserDbDao userDAO;

	/**
	 * To check the user password.
	 * 
	 * @return boolean. "true" if the password is correct or not changed.
	 */
	private boolean checkPassword() {
		boolean passwordOk = false;
		if (StringUtils.isNotBlank(password)) {
			// Check password confirmation, and adjust target
			if (StringUtils.isNotBlank(passwordConfirmation) && password.equals(passwordConfirmation)) {
				currentUser.setPassword(password);
				passwordOk = true;
			}
		} else {
			// Password is mandatory for new user
			if (currentUser.getId() != null) {
				passwordOk = true;
			}
		}
		return passwordOk;
	}

	/**
	 * @return the {@link #currentUser}
	 */
	public User getCurrentUser() {
		if (currentUser == null) {
			this.currentUser = new User();
		}
		return currentUser;
	}

	/**
	 * @return the {@link #password}
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the {@link #passwordConfirmation}
	 */
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	/**
	 * Load default value.
	 */
	public void preRenderView() {
		if (currentUser == null) {
			currentUser = new User();
		}
	}

	/**
	 * To save (create or update) the user in database.
	 * 
	 * @return the database user ID.
	 */
	public String saveUser() {
		// FIXME check password & password confirmation!
		if (!checkPassword()) {
			System.err.println("OULA !!! :O C*est pas bon !!");
			return "/pages/user/userEdit.xhtml?faces-redirect=true";
		}

		if (currentUser.getId() == null) {
			currentUser = userDAO.save(currentUser);
		} else {
			userDAO.update(currentUser);
		}

		// FIXME adjust return URL
		return "/pages/user/usersView.xhtml?faces-redirect=true";
	}

	/**
	 * @param currentUser the {@link #currentUser} to set
	 */
	public void setCurrentUser(final User currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * @param password the {@link #password} to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * @param passwordConfirmation the {@link #passwordConfirmation} to set
	 */
	public void setPasswordConfirmation(final String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
}
