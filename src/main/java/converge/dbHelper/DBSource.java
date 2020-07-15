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

    private DataSource datasource_jsonXml;
    private DataSource datasource_spatialAnalytics;
    private DataSource xmlds, spatialds;

    private static final Logger LOG = Logger.getLogger(DBSource.class);


    public Connection getJsonXmlConnection() throws SQLException {
        LOG.debug("Reached to get Analytics Connection");
        Connection con = null;
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        datasource_jsonXml = (DataSource) context.getBean("datasource_jsonXml");

        try {
            con = datasource_jsonXml.getConnection();
            con.setAutoCommit(false);
            LOG.info("Success connection");
        } catch (SQLException ex) {
            LOG.error(ex);

        } catch (Exception e) {
            LOG.error(e);
        }

        return con;
    }

    public Connection getAnalyticsSpatialConnection() throws SQLException {
        LOG.debug("Reached to get Analytics2 Connection");
        Connection con = null;
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        datasource_spatialAnalytics = (DataSource) context.getBean("datasource_spatialAnalytics");

        try {
            con = datasource_spatialAnalytics.getConnection();
            con.setAutoCommit(false);
            LOG.info("Success connection");
        } catch (SQLException ex) {
            LOG.error(ex);

        } catch (Exception e) {
            LOG.error(e);
        }

        return con;
    }

    public Connection getXMLDS() throws SQLException {
        LOG.debug("Reached to get xml Connection");
        Connection con = null;
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        xmlds = (DataSource) context.getBean("xmldsbean");

        try {
            con = xmlds.getConnection();
            con.setAutoCommit(false);
            LOG.info("Success connection");
        } catch (SQLException ex) {
            LOG.error(ex);

        } catch (Exception e) {
            LOG.error(e);
        }

        return con;
    }

    public Connection getSpatialDS() throws SQLException {
        LOG.debug("Reached to get xml Connection");
        Connection con = null;
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        spatialds = (DataSource) context.getBean("spatialdsbean");

        try {
            con = spatialds.getConnection();
            con.setAutoCommit(false);
            LOG.info("Success connection");
        } catch (SQLException ex) {
            LOG.error(ex);

        } catch (Exception e) {
            LOG.error(e);
        }

        return con;
    }

}
