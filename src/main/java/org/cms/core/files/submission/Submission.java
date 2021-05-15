package org.cms.core.files.submission;

import java.io.Serializable;
import javax.persistence.*;
import org.cms.core.files.assignment.Assignment;
import org.cms.core.student.Student;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "submission")
public class Submission implements Serializable {

	@Id
	@GenericGenerator(name = "submission_id_generator", strategy = "org.cms.core.files.submission.SubmissionIdGenerator")
	@GeneratedValue(generator = "submission_id_generator")
	private String id;

	@OneToOne
	private Assignment assignment;

	@OneToOne
	private Student student;

	private String downloadPath;

	private String uploadDate;

	public Submission() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getDownloadPath() {
		return downloadPath;
	}

	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Submission(Assignment assignment, Student student, String downloadPath) {
		this.assignment = assignment;
		this.student = student;
		this.downloadPath = downloadPath;
	}
}
