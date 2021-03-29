package org.cms.core.admin;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.cms.core.commons.CommonIdGenerator;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class AdminIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
		//language=SQL
		String sql = "select count(*) from org_cms.admin";
		return CommonIdGenerator.generateId("ADMIN", sql, sharedSessionContractImplementor);
	}
}
