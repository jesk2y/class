package org.zerock.config;

import javax.sql.DataSource;

import org.springframework.core.env.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages= {"org.zerock.service", "org.zerock.aop"})
@MapperScan(basePackages= {"org.zerock.mapper"})
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableScheduling
@PropertySource("classpath:db.properties")
public class RootConfig {

	@Autowired
    private Environment environment;
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean
	public DataSource dataSource() {
		
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(environment.getProperty("db.driver"));
		config.setJdbcUrl(environment.getProperty("db.url"));
		config.setUsername(environment.getProperty("db.username"));
		config.setPassword(environment.getProperty("db.password"));
		
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}
	
	@Bean // 빈 들어가면 리턴타입 무조건 있어야함
	public SqlSessionFactory sqlSessionFactory()throws Exception{
		
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean(); 
		factory.setDataSource(dataSource());
		
		return factory.getObject();
	}
}
