package br.facitec.bibliotech.persistence;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.jdbc.Driver;

@Configuration
@EnableTransactionManagement
public class PersistenceConfiguration {
	
	@Bean(name="dataSource")
	public DataSource dataSource() throws SQLException{
		
		 SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		 dataSource.setDriver(new Driver());
		 dataSource.setUsername("root");
		 dataSource.setPassword("root");
		 dataSource.setUrl("jdbc:mysql://localhost/bibliotech");
		 
		 return dataSource;
	
	}
	
	@Bean(name = "jpaVendorAdapter")
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
		hibernateJpaVendorAdapter.setShowSql(true);
		return hibernateJpaVendorAdapter;
	}
	
	@Bean(name = "jpaProperties")
	public Properties jpaProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.jdbc.use_scrollable_resultset", "false");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.hbm2ddl.import_files_sql_extractor", "org.hibernate.tool.hbm2ddl.MultipleLinesSqlCommandExtractor");
		return prop;
	}
	
	@Bean
	@DependsOn({"dataSource", "jpaVendorAdapter", "jpaProperties"})
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter, Properties jpaProperties) {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setPackagesToScan("br.facitec.bibliotech");
		lef.setJpaVendorAdapter(jpaVendorAdapter);
		lef.setDataSource(dataSource);
		lef.setJpaProperties(jpaProperties);
		return lef;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

}
