package com.luv2code.com.springsecuritydemo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.luv2code.com.springsecuritydemo")
@PropertySource( "classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	//Set a environment varable to hold property file
	
	@Autowired
	private Environment env;
	
	private Logger logger=Logger.getLogger(getClass().getName());
	
	
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	//DAta source
	@Bean
	public DataSource SecurityDataSource()
	{
		
		try 
		{
			//create connection pool
			ComboPooledDataSource securityDataSource=
					new ComboPooledDataSource();
		
			//set the jdbc driver class
			
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
				
			//logg connection propertis
			
			logger.info(">>JDBC URL:\t"+env.getProperty("jdbc.driver"));
			logger.info(">>JDBC URL:\t"+env.getProperty("jdbc.user"));
						
			//setup db connection prop
				
			securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			securityDataSource.setUser(env.getProperty("jdbc.user"));
			securityDataSource.setPassword(env.getProperty("jdbc.Password"));
			//set connection pool pro
			securityDataSource.setInitialPoolSize(GetIntPrperty("connection.pool.initialPoolSize"));
			securityDataSource.setMinPoolSize(GetIntPrperty("connection.pool.minPoolSize"));
			securityDataSource.setMaxPoolSize(GetIntPrperty("connection.pool.maxPoolSize"));
			securityDataSource.setMaxIdleTime(GetIntPrperty("connection.pool.maxIdleTime"));
			
			return securityDataSource;
			
			
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	
	}
	
	private int GetIntPrperty(String propertyName)
	{
		String propValue=env.getProperty(propertyName);
		
		int intValue = Integer.parseInt(propValue);
		
		return intValue;
		
	}
	
	
}
