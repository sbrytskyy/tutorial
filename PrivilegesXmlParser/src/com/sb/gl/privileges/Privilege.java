package com.sb.gl.privileges;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Privilege")
@XmlAccessorType(XmlAccessType.FIELD)
public class Privilege {

	@XmlAttribute
	private String id;
	@XmlAttribute(name = "Delegatable")
	private Boolean delegatable;
	@XmlAttribute(name = "OuScopeable")
	private Boolean ouScopeable;
	@XmlAttribute(name = "AdminProtected")
	private Boolean adminProtected;
	@XmlAttribute(name = "ParentId")
	private String parentId;
	@XmlAttribute(name = "SyncToServicesAdminRoles")
	private Boolean syncToServicesAdminRoles;
	@XmlElement(name = "DisplayName")
	private DisplayName displayName;

	public Privilege() {
	}

	public Privilege(String id, Boolean delegatable, Boolean ouScopeable, Boolean adminProtected, String parentId,
			Boolean syncToServicesAdminRoles, DisplayName displayName) {
		super();
		this.id = id;
		this.delegatable = delegatable;
		this.ouScopeable = ouScopeable;
		this.adminProtected = adminProtected;
		this.parentId = parentId;
		this.setSyncToServicesAdminRoles(syncToServicesAdminRoles);
		this.displayName = displayName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getDelegatable() {
		return delegatable;
	}

	public void setDelegatable(Boolean delegatable) {
		this.delegatable = delegatable;
	}

	public Boolean getOuScopeable() {
		return ouScopeable;
	}

	public void setOuScopeable(Boolean ouScopeable) {
		this.ouScopeable = ouScopeable;
	}

	public Boolean getAdminProtected() {
		return adminProtected;
	}

	public void setAdminProtected(Boolean adminProtected) {
		this.adminProtected = adminProtected;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public DisplayName getDisplayName() {
		return displayName;
	}

	public void setDisplayName(DisplayName displayName) {
		this.displayName = displayName;
	}

	public Boolean getSyncToServicesAdminRoles() {
		return syncToServicesAdminRoles;
	}

	public void setSyncToServicesAdminRoles(Boolean syncToServicesAdminRoles) {
		this.syncToServicesAdminRoles = syncToServicesAdminRoles;
	}

	//@formatter:off
	@Override
	public String toString() {
		return id + "\t" + (delegatable != null && delegatable ? "Yes" : "no") 
				+ "\t" + (adminProtected != null && adminProtected ? "Yes" : "no") 
				+ "\t" + (parentId != null ? parentId : "")
				+ "\t" + (ouScopeable != null && ouScopeable ? "Yes" : "no")
				+ "\t" + (syncToServicesAdminRoles != null && syncToServicesAdminRoles ? "Yes" : "no");
	}
	//@formatter:on
}
