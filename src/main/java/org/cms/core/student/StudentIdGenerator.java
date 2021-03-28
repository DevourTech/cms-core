package org.cms.core.student;

import java.io.Serializable;
import java.sql.*;

import org.cms.core.commons.CommonIdGenerator;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StudentIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
		return CommonIdGenerator.generateId("STUDENT", "student", sharedSessionContractImplementor);
	}
}
