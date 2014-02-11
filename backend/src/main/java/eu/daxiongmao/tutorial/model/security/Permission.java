package eu.daxiongmao.tutorial.model.security;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

import eu.daxiongmao.tutorial.model.Asset;
import eu.daxiongmao.tutorial.util.constant.EntityFieldSize;

/**
 * Group permission.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - January 2014
 */
@XmlRootElement
@Entity
@Table(name = "permissions")
public class Permission extends Asset {

	/** Object UID. */
	private static final long serialVersionUID = 4386255988141414124L;

	/** Description of the current element. */
	@XmlElement(required = false)
	@Column(name = "description", length = EntityFieldSize.VARCHAR_BIG_TEXT_500, nullable = true, unique = false)
	private String description;

	/**
	 * <p>
	 * List of group(s) - if any - that possess the current permission.
	 * </p>
	 * <p>
	 * This is the corresponding relation of the {@link Group#getPermissions()}. <br/>
	 * To make bi-directional links through JoinTable, you must repeat the annotation with owner reference.<br/>
	 * see: <a href="http://en.wikibooks.org/wiki/Java_Persistence/ManyToMany">source</a>
	 * </p>
	 */
	@XmlElement(required = false)
	@ManyToMany(mappedBy = "permissions", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<Group> groups;

	/** Name of the current element. */
	@XmlElement(required = true)
	@Size(min = 1, max = EntityFieldSize.VARCHAR_SMALL_SIZE_50)
	@Column(name = "name", nullable = false, unique = true, length = EntityFieldSize.VARCHAR_SMALL_SIZE_50)
	private String name;

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
		Permission other = (Permission) target;
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
	 * @return {@link #groups}
	 */
	public final List<Group> getGroups() {
		if (this.groups == null) {
			this.groups = new ArrayList<>();
		}
		return this.groups;
	}

	/**
	 * @return {@link #$ bare_field_name}
	 */
	public final String getName() {
		return name;
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
	 * @param groups the {@link #groups} to set
	 */
	public final void setGroups(final List<Group> groups) {
		if (groups != null) {
			this.groups = groups;
		}
	}

	/**
	 * @param name {@link #name} to set
	 */
	public final void setName(final String name) {
		this.name = name;
	}

	@Override
	public final String toString() {
		StringBuilder log = new StringBuilder("Permission # ");
		// Asset properties
		log.append(super.toString(true));

		log.append("Name: ").append(name);
		if (!StringUtils.isBlank(description)) {
			log.append(" | ").append(description);
		}

		return log.toString();
	}

}
