package org.cms.core.files.assignment;

import java.io.Serializable;
import org.cms.core.commons.CommonIdGenerator;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class AssignmentIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
		String prefix = "ASGN";
		//language=SQL
		String sql = "select count(*) from org_cms.assignment";
		return CommonIdGenerator.generateId(prefix, sql, sharedSessionContractImplementor);
	}
}
