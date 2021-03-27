package org.cms.core.course;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "course")
public class Course implements Serializable {

	@Id
	@GenericGenerator(name = "course_id_generator", strategy = "org.cms.core.course.CourseIdGenerator")
	@GeneratedValue(generator = "course_id_generator")
	@Column(name = "course_id", unique = true, nullable = false)
	private String id;

	private String name;
	private String description;

	public Course() {}

	public Course(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Course(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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
