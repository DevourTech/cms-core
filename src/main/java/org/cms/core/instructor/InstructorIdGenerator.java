package org.cms.core.instructor;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.cms.core.commons.CommonIdGenerator;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class InstructorIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
		//language=SQL
		String sql = "select count(*) from org_cms.instructor";
		return CommonIdGenerator.generateId("INST", sql, sharedSessionContractImplementor);
	}
}
