package com.sb.gl.privileges;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PrivilegesSchema")
@XmlAccessorType(XmlAccessType.FIELD)
public class PrivilegesSchema {

	@XmlElement(name = "Privilege")
	private List<Privilege> privileges;

	public PrivilegesSchema() {
	}

	public PrivilegesSchema(List<Privilege> privileges) {
		super();
		this.privileges = privileges;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	@Override
	public String toString() {
		return "PrivilegesSchema [privileges=" + privileges + "]";
	}

}
