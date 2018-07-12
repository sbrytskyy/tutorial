package com.sb.gl.privileges;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ApplicationManifest")
@XmlType(namespace = "http://schemas.google.com/ApplicationManifest/2009")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApplicationManifest {

	@XmlElement(name = "PrivilegesSchema")
	private PrivilegesSchema privilegesSchema;

	public ApplicationManifest() {
	}

	public ApplicationManifest(PrivilegesSchema privilegesSchema) {
		this.privilegesSchema = privilegesSchema;
	}

	public PrivilegesSchema getPrivilegesSchema() {
		return privilegesSchema;
	}

	public void setPrivilegesSchema(PrivilegesSchema privilegesSchema) {
		this.privilegesSchema = privilegesSchema;
	}

	@Override
	public String toString() {
		return "ApplicationManifest [privilegesSchema=" + privilegesSchema + "]";
	}
}
