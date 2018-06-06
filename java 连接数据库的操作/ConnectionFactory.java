package com.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	private static final ConnectionFactory FACTORY = new ConnectionFactory();

	private ConnectionFactory() {
	}

	private Connection connection = null;
	//静态代码块在主函数运行前执行，只会执行一次
	static {
		
		Properties properties = new Properties();
		try {
			InputStream inputStream = ConnectionFactory.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			//读取配置文件
			properties.load(inputStream);
		} catch (Exception e) {
			
			System.out.println();
			System.out.println("=======连接失败!=======");
			
		}
		
			driver = properties.getProperty("driver");
			System.out.println(driver);
			dburl = properties.getProperty("dburl");
			System.out.println(dburl);
			user = properties.getProperty("user");
			System.out.println(user);
			password = properties.getProperty("password");
			System.out.println(password);
		
		
	}

	// 获取连接工厂类实例
	public static ConnectionFactory getInstance() {
		return FACTORY;
	}

	public Connection makeConnection() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
			System.out.println("=======连接成功!=======");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
