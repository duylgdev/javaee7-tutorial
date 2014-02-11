package eu.daxiongmao.tutorial.model.security;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

import eu.daxiongmao.tutorial.model.Asset;
import eu.daxiongmao.tutorial.model.common.User;
import eu.daxiongmao.tutorial.util.constant.EntityFieldSize;

/**
 * User group.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - January 2014
 */
@XmlRootElement
@Entity
@Table(name = "groups")
public class Group extends Asset {

	/** Object UID. */
	private static final long serialVersionUID = -5901729586989791650L;

	/** Description of the current element. */
	@XmlElement(required = false)
	@Column(name = "description", length = EntityFieldSize.VARCHAR_BIG_TEXT_500, nullable = true, unique = false)
	private String description;

	/** Name of the current element. */
	@XmlElement(required = true)
	@Size(min = 1, max = EntityFieldSize.VARCHAR_SMALL_SIZE_50)
	@Column(name = "name", nullable = false, unique = true, length = EntityFieldSize.VARCHAR_SMALL_SIZE_50)
	private String name;

	/**
	 * <p>
	 * List of group's permission(s).<br/>
	 * Each group can have zero or N permission(s). Each permission matches an application feature.
	 * </p>
	 * <p>
	 * This is a join table. <br/>
	 * The 'GROUP_ID' column refers to the GROUP, while the 'PERMISSION_ID' column refers to the PERMISSION.<br/>
	 * Note that for the [ @ ManyToMany ] all the mapping is done here.
	 * </p>
	 */
	@XmlElement(required = false)
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "groups_permissions", joinColumns = { @JoinColumn(name = "group_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "permission_id", referencedColumnName = "id") })
	private List<Permission> permissions;

	/**
	 * <p>
	 * The role's members.
	 * </p>
	 * <p>
	 * This is the corresponding relation of the {@link User#getGroups()}. <br/>
	 * To make bi-directional links through JoinTable, you must repeat the annotation with owner reference.<br/>
	 * see: <a href="http://en.wikibooks.org/wiki/Java_Persistence/ManyToMany">source</a>
	 * </p>
	 */
	@XmlElement(required = false)
	@ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<User> users;

	@Override
	public final boolean equals(final Object target) {
		// Check param
		if (target == null) {
			return false;
		}
		if (getClass() != target.getClass()) {
			return false;
		}

		// Name must be unique
		Group other = (Group) target;
		if (!StringUtils.isBlank(other.getName()) && other.getName().equalsIgnoreCase(this.getName())) {
			return true;
		}
		return false;
	}

	/**
	 * @return {@link #description}
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * @return {@link #$ bare_field_name}
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @return {@link #permissions}
	 */
	public final List<Permission> getPermissions() {
		if (permissions == null) {
			this.permissions = new ArrayList<>();
		}
		return permissions;
	}

	/**
	 * @return {@link #users}
	 */
	public final List<User> getUsers() {
		if (users == null) {
			users = new ArrayList<>();
		}
		return users;
	}

	@Override
	public final int hashCode() {
		int hash = 0;
		if (!StringUtils.isBlank(name)) {
			hash += this.name.toString().trim().hashCode();
		}
		return hash;
	}

	/**
	 * @param description the {@link #description} to set
	 */
	public final void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * @param name {@link #name} to set
	 */
	public final void setName(final String name) {
		this.name = name;
	}

	/**
	 * @param permissions the {@link #permissions} to set
	 */
	public final void setPermissions(final List<Permission> permissions) {
		if (permissions != null) {
			this.permissions = permissions;
		}
	}

	/**
	 * @param users the {@link #users} to set
	 */
	public final void setUsers(final List<User> users) {
		if (users != null) {
			this.users = users;
		}
	}

	@Override
	public final String toString() {
		StringBuilder log = new StringBuilder("Group # ");
		// Asset properties
		log.append(super.toString(true));

		log.append("Name: ").append(name);
		if (!StringUtils.isBlank(description)) {
			log.append(" | ").append(description);
		}

		return log.toString();
	}

}
