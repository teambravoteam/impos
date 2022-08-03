package com.teambravo.impos.init.listener;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.teambravo.impos.init.domain.DataSource;
import com.teambravo.impos.init.service.NamingService;

@WebListener
public class InitialieDataSourceListner implements ServletContextListener {
	private static final String JDBC_FILE_PATH = "/WEB-INF/classes/jdbc.properties";

	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		InputStream is = null;
		try {
			is = context.getResourceAsStream(JDBC_FILE_PATH);
			Properties prop = new Properties();
			prop.load(is);

			String jdbcDriver = prop.getProperty("jdbc.driver");
			System.out.println(jdbcDriver);
			String jdbcUrl = prop.getProperty("jdbc.url");
			System.out.println(jdbcUrl);
			String jdbcName = prop.getProperty("jdbc.user");
			System.out.println(jdbcName);
			String passwd = prop.getProperty("jdbc.passwd");
			System.out.println(passwd);

			NamingService namingService = NamingService.getInstance();

			DataSource dataSource = new DataSource(jdbcDriver, jdbcUrl, jdbcName, passwd);
			namingService.setAttribute("dataSource", dataSource);
			// context.setAttribute("dataSource", dataSource); 아래꺼 보다는 위에 꺼

			System.out.println("DataSource on");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

}
