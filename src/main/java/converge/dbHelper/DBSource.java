package converge.dbHelper;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class DBSource {
	
	private DataSource datasourceJsonCon;
	private DataSource datasourceSpatialCon;
	private DataSource datasourceAnalytics;
	private DataSource datasourceAnalytics_2;
	private static final Logger LOG = Logger.getLogger(DBSource.class);
	
	

	
	public  Connection getJsonXmlConnection() throws SQLException{
		LOG.debug("Reached to get Analytics Connection");
		Connection con = null;
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		datasourceAnalytics = (DataSource) context.getBean("datasourceAnalytics");
			
		try {
			con = datasourceAnalytics.getConnection();
			con.setAutoCommit(false);
			LOG.info("Success connection");
		}catch(SQLException ex) {
			LOG.error(ex);
			
		}catch(Exception e) {
			LOG.error(e);
		}
	
		return con;
	}
	
	public  Connection getAnalyticsSpatialConnection() throws SQLException{
		LOG.debug("Reached to get Analytics2 Connection");
		Connection con = null;
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		datasourceAnalytics_2 = (DataSource) context.getBean("datasourceAnalytics_2");
			
		try {
			con = datasourceAnalytics_2.getConnection();
			con.setAutoCommit(false);
			LOG.info("Success connection");
		}catch(SQLException ex) {
			LOG.error(ex);
			
		}catch(Exception e) {
			LOG.error(e);
		}
	
		return con;
	}
	
}
