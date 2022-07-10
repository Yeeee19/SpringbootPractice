package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {



	@Test
	void contextLoads() {
	}

	/*
	@Autowired
	private DataSource dataSource;
	*/
	/**
	 * Hikari 為 Springboot 預設連接池
	 * HikariProxyConnection@203498806 wrapping com.mysql.cj.jdbc.ConnectionImpl@7b377a53
	 * @throws SQLException
	 */
	@Test
	void getConnection() throws SQLException {
		//System.out.println(dataSource.getConnection());
	}
}
