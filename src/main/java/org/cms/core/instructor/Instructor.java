package org.cms.core.instructor;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "instructor")
public class Instructor implements Serializable {

	@Id
	@GenericGenerator(name = "instructor_id_generator", strategy = "org.cms.core.instructor.InstructorIdGenerator")
	@GeneratedValue(generator = "instructor_id_generator")
	private String id;

	private String name;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Instructor() {}

	public Instructor(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Instructor(String name) {
		this.name = name;
	}

	public Instructor(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
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

	@Override
	public String toString() {
		return "Instructor={" + "id=" + id + ", name='" + name + '}';
	}
}
