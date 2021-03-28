package org.cms.core.instructor;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class InstructorIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
		String prefix = "INST";
		Connection connection = sharedSessionContractImplementor.connection();

		try {
			PreparedStatement pstat = connection.prepareStatement(
				"select count(*)  from org_cms.instructor",
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE
			);
			ResultSet rs = pstat.executeQuery();
			int id = 0;
			while (rs.next()) {
				id = Integer.parseInt(rs.getString("count(*)"));
				System.out.println(Integer.parseInt(rs.getString("count(*)")));
			}
			String generatedId = prefix + id;
			System.out.println("Generated Id: " + generatedId);
			return generatedId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
