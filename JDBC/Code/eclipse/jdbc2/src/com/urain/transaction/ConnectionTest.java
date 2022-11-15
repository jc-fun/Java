package com.urain.transaction;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.urain.utils.JDBCUtils;

public class ConnectionTest {
	@Test
	public void testGetConnection() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(conn);
	}
}
