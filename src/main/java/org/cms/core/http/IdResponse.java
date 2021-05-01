package org.cms.core.http;

import java.io.Serializable;

public class IdResponse implements Serializable {

	String id;
	String message;

	public IdResponse() {}

	public IdResponse(String id, String message) {
		this.id = id;
		this.message = message;
	}

	@Override
	public String toString() {
		return "IdResponse{" + "id='" + id + '\'' + ", message='" + message + '\'' + '}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
