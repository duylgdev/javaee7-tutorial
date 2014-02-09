package eu.daxiongmao.tutorial.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Asset entity. <br/>
 * All application's asset should extends that one.<br/>
 * <br/>
 * Asset business properties:
 * <ul>
 * <li>An asset represents something UNIQUE and IMPORTANT in the application (such as an User | Product)</li>
 * <li>An asset represents a specific type of thing - something that is real</li>
 * <li>An asset has some business value. Therefore it should never be deleted.</li>
 * </ul>
 * <br/>
 * Asset technical properties:
 * <ul>
 * <li>It's never delete. Just enable / disable</li>
 * <li>We keep track on create / update / enable / disable time</li>
 * <li>An asset is serializable</li>
 * <li>Asset is a generic type that can be used throughout all the application</li>
 * </ul>
 * 
 * @author Guillaume Diaz
 * @version 1.0 - September 2013
 */
@XmlRootElement
@MappedSuperclass
public class Asset implements Serializable {

	/** Object UID. */
	private static final long serialVersionUID = 1877036570715771557L;

	/**
	 * Flag to know if the current object is active or not.<br/>
	 * NB: assets are not "deleted" but disabled in database.<br/>
	 * By default every new asset is "active"
	 */
	@Column(name = "active", nullable = false)
	@XmlElement(required = true)
	private boolean active = true;

	/** Date of object 1st registration in database. */
	@Column(name = "created", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@XmlElement(required = false)
	private Date created = new Date();

	/**
	 * Tells when the object was disabled (= deleted from user point of view). <br/>
	 * If null, then the object is still active.
	 */
	@Column(name = "deleted", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@XmlElement(required = false)
	private Date deleted = null;

	/** Object ID in database. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@XmlElement(required = false)
	private Long id;

	/** Represent the last time the object was updated in database. */
	@Column(name = "updated", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@XmlElement(required = false)
	private Date updated = new Date();

	@Override
	public boolean equals(final Object obj) {
		// Check param
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		Asset other = (Asset) obj;
		if (!(other.isActive() == this.isActive())) {
			return false;
		}

		// Do not take dates into account!

		return true;
	}

	/**
	 * @return the {@link #created}
	 */
	public final Date getCreated() {
		if (this.created != null) {
			return new Date(this.created.getTime());
		}
		return null;
	}

	/**
	 * @return the {@link #deleted}
	 */
	public final Date getDeleted() {
		if (this.deleted != null) {
			return new Date(this.deleted.getTime());
		}
		return null;
	}

	/**
	 * @return {@link #id}
	 */
	public final Long getId() {
		return id;
	}

	/**
	 * @return the {@link #updated}
	 */
	public final Date getUpdated() {
		if (this.updated != null) {
			return (Date) updated.clone();
		}
		return null;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		if (isActive()) {
			hash += 1;
		}
		// date checks
		if (getCreated() != null) {
			hash += this.created.hashCode();
		}
		if (getUpdated() != null) {
			hash += this.updated.hashCode();
		}
		if (getDeleted() != null) {
			hash += this.deleted.hashCode();
		}
		return hash;
	}

	/**
	 * @return the {@link #active}
	 */
	public final boolean isActive() {
		return active;
	}

	/**
	 * @param active the {@link #active} to set
	 */
	public final void setActive(final boolean active) {
		this.active = active;
	}

	/**
	 * @param created the {@link #created} to set
	 */
	public final void setCreated(final Date created) {
		if (created != null) {
			this.created = new Date(created.getTime());
		}
	}

	/**
	 * @param deleted the {@link #deleted} to set
	 */
	public final void setDeteled(final Date deleted) {
		if (deleted != null) {
			this.deleted = new Date(deleted.getTime());
		}
	}

	/**
	 * @param id the {@link #id} to set
	 */
	public final void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @param updated the {@link #updated} to set
	 */
	public final void setUpdated(final Date updated) {
		if (updated != null) {
			this.updated = new Date(updated.getTime());
		}
	}

	/**
	 * @param fullLog flag to get the simple / full log (including dates [creation, update, deletion]).
	 * @return String representation of the object.
	 */
	public final String toString(final boolean fullLog) {
		StringBuilder msg = new StringBuilder();
		if (id != null && id > 0) {
			msg.append("ID: ").append(id).append(" | ");
		}
		msg.append("is active: ").append(active);

		if (fullLog) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			if (this.getCreated() != null) {
				msg.append(" | created: ").append(sdf.format(getCreated()));
			}
			if (this.getUpdated() != null) {
				msg.append(" | updated: ").append(sdf.format(getUpdated()));
			}
			if (this.getDeleted() != null) {
				msg.append(" | deleted: ").append(sdf.format(getDeleted()));
			}
		}

		return msg.toString();
	}
}
