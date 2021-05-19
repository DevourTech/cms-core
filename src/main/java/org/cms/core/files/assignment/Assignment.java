package org.cms.core.files.assignment;

import java.io.Serializable;
import javax.persistence.*;
import org.cms.core.course.Course;
import org.cms.core.instructor.Instructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "assignment")
public class Assignment implements Serializable {

	@OneToOne
	private Instructor instructor;

	private String downloadPath;

	@OneToOne
	private Course course;

	private String uploadDate;
	private String dueDate;

	@Id
	@GenericGenerator(name = "assignment_id_generator", strategy = "org.cms.core.files.assignment.AssignmentIdGenerator")
	@GeneratedValue(generator = "assignment_id_generator")
	private String id;

	public Assignment() {}

	public Assignment(Instructor instructor, String downloadPath, Course course) {
		this.instructor = instructor;
		this.downloadPath = downloadPath;
		this.course = course;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public String getDownloadPath() {
		return downloadPath;
	}

	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
