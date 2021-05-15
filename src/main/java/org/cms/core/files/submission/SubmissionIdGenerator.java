package org.cms.core.files.submission;

import java.io.Serializable;
import org.cms.core.commons.CommonIdGenerator;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SubmissionIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
		String prefix = "SUBM";
		//language=SQL
		String sql = "select count(*) from org_cms.submission";
		return CommonIdGenerator.generateId(prefix, sql, sharedSessionContractImplementor);
	}
}
