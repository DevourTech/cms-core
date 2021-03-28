package org.cms.core.admin;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "admin")
public class Admin implements Serializable {
	@Id
	@GenericGenerator(name = "admin_id_generator", strategy = "org.cms.core.admin.AdminIdGenerator")
	@GeneratedValue(generator = "admin_id_generator")
	private String id;

	private String name;
	private String password;

	public Admin() {}

	public Admin(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
