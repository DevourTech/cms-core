package org.cms.core.course;

import java.io.Serializable;
import java.sql.*;
import java.util.Locale;
import org.cms.core.commons.CommonIdGenerator;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CourseIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
		boolean b = o instanceof Course;
		if (!b) {
			return null;
		}
		Course course = (Course) o;
		String branch = course.getBranch();
		String prefix = branch.substring(0, 3).toUpperCase();
		//language=SQL
		String sql = "select count(*) from org_cms.course where branch='" + branch + "'";
		return CommonIdGenerator.generateId(prefix, sql, sharedSessionContractImplementor);
	}
}
