package com.lance.common.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * mybatis 辅数据源 2
 *
 * @author lance
 * @since 2019-1-2
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource")
@EnableTransactionManagement
@Configuration
@MapperScan(basePackages = SlaveSecondDataSourceConfiguration.DAO_PATH, sqlSessionFactoryRef = "slaveSecondSqlSessionFactory")
public class SlaveSecondDataSourceConfiguration
{

    /**
     * slaveSecond dao 扫描路径
     */
    static final String DAO_PATH = "com.lance.business.dao.slavesecond";
    /**
     * slaveSecond mybatis.mapper 扫描路径
     */
    static final String MAPPER_PATH = "classpath:mybatis/mapper/slavesecond/*.xml";

    private String urlSlaveSecond;
    private String usernameSlaveSecond;
    private String passwordSlaveSecond;
    private String driverClassName;
    private int initialSize;
    private int minIdle;
    private int maxActive;
    private int maxWait;
    private int timeBetweenEvictionRunsMillis;
    private int minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    private String filters;
    private String connectionProperties;


    @Bean(name = "slaveSecondDataSource")
    public DataSource slaveSecondDateSource() throws Exception
    {
        DruidDataSource druid = new DruidDataSource();
        // 配置基本属性
        druid.setDriverClassName(driverClassName);
        druid.setUrl(urlSlaveSecond);
        druid.setUsername(usernameSlaveSecond);
        druid.setPassword(passwordSlaveSecond);
        //初始化时建立物理连接的个数
        druid.setInitialSize(initialSize);
        //最大连接池数量
        druid.setMaxActive(maxActive);
        //最小连接池数量
        druid.setMinIdle(minIdle);
        //获取连接时最大等待时间，单位毫秒。
        druid.setMaxWait(maxWait);
        //间隔多久进行一次检测，检测需要关闭的空闲连接
        druid.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        //一个连接在池中最小生存的时间
        druid.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        //用来检测连接是否有效的sql
        druid.setValidationQuery(validationQuery);
        //建议配置为true，不影响性能，并且保证安全性。
        druid.setTestWhileIdle(testWhileIdle);
        //申请连接时执行validationQuery检测连接是否有效
        druid.setTestOnBorrow(testOnBorrow);
        druid.setTestOnReturn(testOnReturn);
        //是否缓存preparedStatement，也就是PSCache，oracle设为true，mysql设为false。分库分表较多推荐设置为false
        druid.setPoolPreparedStatements(poolPreparedStatements);
        // 打开PSCache时，指定每个连接上PSCache的大小
        druid.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        // 监控统计拦截的filters
        druid.setFilters(filters);
        druid.init();
        return druid;
    }

    @Bean(name = "slaveSecondTransactionManager")
    public DataSourceTransactionManager slaveSecondTransactionManager() throws Exception
    {
        return new DataSourceTransactionManager(slaveSecondDateSource());
    }


    @Bean(name = "slaveSecondSqlSessionFactory")
    public SqlSessionFactory slaveSecondSqlSessionFactory(@Qualifier("slaveSecondDataSource") DataSource dataSource) throws Exception
    {
        final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_PATH));
        return sqlSessionFactory.getObject();
    }

}
