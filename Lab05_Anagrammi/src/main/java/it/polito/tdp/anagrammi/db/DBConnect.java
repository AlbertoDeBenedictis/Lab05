package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	// TODO cambiare nome del database a cui accedere
		static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=Adb16081998";

		public static Connection getConnection() {

			try {
					Connection connection = DriverManager.getConnection(jdbcUrl);
					return connection;

			} catch (SQLException e) {

				e.printStackTrace();
				throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
			}
		}
}
