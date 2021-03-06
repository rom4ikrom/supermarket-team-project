package net.romanov.supermarketbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"net.romanov.supermakerketbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	//local h2 database connection
//	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/supermarket";
//	private final static String DATABASE_DRIVER = "org.h2.Driver";
//	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
//	private final static String DATABASE_USERNAME = "roman";
//	private final static String DATABASE_PASSWORD = "12345";
	
	//remote oracle jdbc connection
	private final static String DATABASE_URL = "jdbc:oracle:thin:@soc.uwl.ac.uk:1521:itcent";
	private final static String DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.Oracle10gDialect";
	private final static String DATABASE_USERNAME = "21321194";
	private final static String DATABASE_PASSWORD = "21321194";

	//dataSource bean will be available
	@Bean("dataSource")
	public DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();

		//provide the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);

		return dataSource;

	}

	//session factory bean
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.romanov.supermarketbackend.dto");

		return builder.buildSessionFactory();

	}

	//all the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {

		Properties properties = new Properties();

		properties.put("hibernate.dialect", DATABASE_DIALECT);

		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");

		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

	//transaction manager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

}
