package org.cms.core.course;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String description;

	public Course() {}

	public Course(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Course(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Course{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + '}';
	}
}
