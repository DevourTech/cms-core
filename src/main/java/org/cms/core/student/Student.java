package org.cms.core.student;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	@Id
	@GenericGenerator(name = "student_id_generator", strategy = "org.cms.core.student.StudentIdGenerator")
	@GeneratedValue(generator = "student_id_generator")
	private String id;

	private String name;
	private String password;

	public Student() {}

	public Student(String name) {
		this.name = name;
	}

	public Student(String id, String name) {
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

	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name='" + name + '}';
	}
}
