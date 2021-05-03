package org.cms.core.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.cms.core.instructor.Instructor;
import org.cms.core.student.Student;
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
	private String branch;
	private String description;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "subscribedCourses")
	private List<Student> students;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "courses")
	private List<Instructor> instructors;

	public Course() {}

	public Course(String name, String branch, String description) {
		this.name = name;
		this.branch = branch;
		this.description = description;
	}

	public Course(String id, String name, String branch, String description) {
		this.id = id;
		this.name = name;
		this.branch = branch;
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
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
