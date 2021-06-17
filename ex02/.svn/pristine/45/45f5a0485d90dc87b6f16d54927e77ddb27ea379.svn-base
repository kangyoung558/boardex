package com.momtenting.persistance;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testConnection() {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@human.lepelaka.net:1521/xe", "BOOK_EX01", "BOOK_EX01")) {
			log.info(conn);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}
}
