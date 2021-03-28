package org.cms.core.commons;

import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonIdGenerator {
	public static String generateId(String prefix, String tableName, SharedSessionContractImplementor sharedSessionContractImplementor) {
		Connection connection = sharedSessionContractImplementor.connection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select count(*)  from org_cms." + tableName,
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
