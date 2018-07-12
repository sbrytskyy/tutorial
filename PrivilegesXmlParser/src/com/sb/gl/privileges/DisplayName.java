package com.sb.gl.privileges;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DisplayName")
@XmlAccessorType(XmlAccessType.FIELD)
public class DisplayName {
	
	@XmlAttribute(name="msgId")
	private String msgId;

	public DisplayName() {
	}
	
	public DisplayName(String msgId) {
		super();
		this.msgId = msgId;
	}

	@Override
	public String toString() {
		return "DisplayName [msgId=" + msgId + "]";
	}
}
