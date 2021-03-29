package org.cms.core.commons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

public class CommonIdGenerator {

	public static String generateId(String prefix, String sql, SharedSessionContractImplementor sharedSessionContractImplementor) {
		Connection connection = sharedSessionContractImplementor.connection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
				sql,
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE
			);
			ResultSet rs = preparedStatement.executeQuery();
			int id = 0;
			while (rs.next()) {
				id = Integer.parseInt(rs.getString("count(*)"));
			}
			return prefix + id;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
