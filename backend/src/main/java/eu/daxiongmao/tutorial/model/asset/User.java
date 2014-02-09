package eu.daxiongmao.tutorial.model.asset;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

import eu.daxiongmao.tutorial.model.Asset;
import eu.daxiongmao.tutorial.model.security.Group;
import eu.daxiongmao.tutorial.util.constant.EntityFieldSize;
import eu.daxiongmao.tutorial.util.validation.EmailValidation;

/**
 * Application user.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - January 2014
 */
@XmlRootElement
@Entity
@Table(name = "users")
public class User extends Asset {

	/** Object UID. */
	private static final long serialVersionUID = -1897968760585409731L;

	/** Email address. */
	@Column(name = "email", nullable = true, length = EntityFieldSize.VARCHAR_MEDIUM_TEXT_255, unique = true)
	@XmlElement(required = false)
	@EmailValidation(message = "not a valid email")
	private String email = null;

	/** First name. */
	@Column(name = "first_name", nullable = true, length = EntityFieldSize.VARCHAR_MEDIUM_TEXT_200, unique = false)
	@XmlElement(required = false)
	private String firstName = null;

	/**
	 * <p>
	 * List of user's group(s).<br/>
	 * Each user can belong to one or more groups.
	 * </p>
	 * <p>
	 * This is a join table. <br/>
	 * The 'USER_ID' column refers to the USER, while the 'GROUP_ID' column refers to the GROUP.<br/>
	 * Note that for the [ @ ManyToMany ] all the mapping is done here.
	 * </p>
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "users_groups", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "group_id", referencedColumnName = "id") })
	@XmlElement(required = false)
	private List<Group> groups;

	/** Object ID in database. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@XmlElement(required = false)
	private Long id;

	/** Last name (= surname). */
	@Column(name = "last_name", nullable = true, length = EntityFieldSize.VARCHAR_MEDIUM_TEXT_200, unique = false)
	@XmlElement(required = false)
	private String lastName = null;

	/** Login. */
	@Column(name = "login", nullable = false, length = EntityFieldSize.VARCHAR_SMALL_SIZE_50, unique = true)
	@XmlElement(required = true)
	@Size(min = 1, max = EntityFieldSize.VARCHAR_SMALL_SIZE_50)
	@NotNull
	private String login;

	/** Password. */
	@Column(name = "password", nullable = false, length = EntityFieldSize.VARCHAR_SMALL_TEXT_75, unique = false)
	@XmlElement(required = false)
	private String password;

	@Override
	public final boolean equals(final Object target) {
		// Check param
		if (target == null) {
			return false;
		}
		if (getClass() != target.getClass()) {
			return false;
		}

		// Check isActive
		if (!super.equals(target)) {
			return false;
		}

		// Login must be unique
		User other = (User) target;
		if (!StringUtils.isBlank(other.getLogin()) && other.getLogin().equalsIgnoreCase(this.getLogin())) {
			return true;
		}
		return false;
	}

	/**
	 * @return {@link #email}
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * @return {@link #firstName}
	 */
	public final String getFirstName() {
		return firstName;
	}

	/**
	 * @return {@link #groups}
	 */
	public final List<Group> getGroups() {
		if (this.groups == null) {
			this.groups = new ArrayList<>();
		}
		return this.groups;
	}

	/**
	 * @return {@link #id}
	 */
	public final Long getId() {
		return id;
	}

	/**
	 * @return {@link #lastName}
	 */
	public final String getLastName() {
		return lastName;
	}

	/**
	 * @return {@link #login}
	 */
	public final String getLogin() {
		return login;
	}

	/**
	 * @return {@link #password}
	 */
	public final String getPassword() {
		return password;
	}

	@Override
	public final int hashCode() {
		int hash = super.hashCode();
		if (!StringUtils.isBlank(login)) {
			hash += this.login.toString().trim().hashCode();
		}
		return hash;
	}

	/**
	 * @param email the {@link #email} to set
	 */
	public final void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * @param firstName the {@link #firstName} to set
	 */
	public final void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param groups the {@link #groups} to set
	 */
	public final void setGroups(final List<Group> groups) {
		if (groups != null) {
			this.groups = groups;
		}
	}

	/**
	 * @param id the {@link #id} to set
	 */
	public final void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @param lastName the {@link #lastName} to set
	 */
	public final void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param login the {@link #login} to set
	 */
	public final void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * @param password the {@link #password} to set
	 */
	public final void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public final String toString() {
		StringBuilder log = new StringBuilder("User # ");

		if (id != null && id > 0) {
			log.append("ID: ").append(id).append(" | ");
		}

		// Display dates
		log.append(super.toString(true));

		// Extract name
		if (firstName != null) {
			log.append(firstName);
			if (lastName != null) {
				log.append(" ").append(lastName);
			}
			log.append(" | ");
		} else if (lastName != null) {
			log.append(lastName).append(" | ");
		}

		// Optional attributes
		if (!StringUtils.isBlank(email)) {
			log.append(email).append(" | ");
		}

		// mandatory stuff
		log.append("login: ").append(login);

		return log.toString();
	}

}
