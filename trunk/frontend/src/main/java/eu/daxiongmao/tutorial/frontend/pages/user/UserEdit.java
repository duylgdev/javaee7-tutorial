package eu.daxiongmao.tutorial.frontend.pages.user;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.lang3.StringUtils;

import eu.daxiongmao.tutorial.backend.dao.db.IGenericDbDao;
import eu.daxiongmao.tutorial.backend.dao.db.common.IUserDbDao;
import eu.daxiongmao.tutorial.frontend.pages.AbstractAssetEdit;
import eu.daxiongmao.tutorial.model.common.User;

/**
 * EDIT / ADD user controller.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - February 2014
 * @since v1.0
 */
@ManagedBean
@RequestScoped
public class UserEdit extends AbstractAssetEdit<User> {

	/** New password. */
	private String password;

	/** New password confirmation. */
	private String passwordConfirmation;

	/** User DAO. */
	@EJB
	private IUserDbDao userDAO;

	/** Default constructor that binds an object. */
	public UserEdit() {
		super(User.class);
	}

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
				getObj().setPassword(password);
				passwordOk = true;
			}
		} else {
			// Password is mandatory for new user
			if (getObj().getId() != null) {
				passwordOk = true;
			}
		}
		return passwordOk;
	}

	@Override
	protected IGenericDbDao<User> getDao() {
		return userDAO;
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

	@Override
	protected String getSuccessPage() {
		return "/pages/user/usersView.xhtml?faces-redirect=true";
	}

	/**
	 * To save (create or update) the user in database.
	 * 
	 * @return the database user ID.
	 */
	public String saveUser() {
		// Check password & password confirmation!
		if (!checkPassword()) {
			System.err.println("OULA !!! :O C*est pas bon !!");
			return "/pages/user/userEdit.xhtml?faces-redirect=true";
		}

		return super.save();
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
