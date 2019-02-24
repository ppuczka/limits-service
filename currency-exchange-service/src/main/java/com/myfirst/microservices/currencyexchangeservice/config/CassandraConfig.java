package com.myfirst.microservices.currencyexchangeservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.*;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.myfirst.microservices.currencyexchangeservice")
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${cassandra.contact-points}")
    protected String contactPoints;

    @Value("${cassandra.keyspace-name}")
    protected String keySpace;

    @Value("${cassandra.port}")
    protected int port;

    @Override public String[] getEntityBasePackages() {
        return super.getEntityBasePackages();
    }

    @Override public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override protected String getKeyspaceName() {
        return keySpace;
    }

    @Override protected String getContactPoints() {
        return contactPoints;
    }

    @Override protected int getPort() {
        return port;
    }

    @Override protected boolean getMetricsEnabled() {
        return false;
    }


//    @Override public SchemaAction getSchemaAction() {
//        return SchemaAction.RECREATE_DROP_UNUSED;
//    }

//    @Override public String[] getEntityBasePackages() {
//        return new String[] {"com.myfirst.microservices.currencyexchangeservice.entity"};
//        }
//    @Override
//    protected Set<Class<?>> getInitialEntitySet() throws ClassNotFoundException {
//        return CassandraEntityClassScanner.scan(getEntityBasePackages());
//    }
//
//
//    @Bean
//    public CassandraClusterFactoryBean cassandraClusterFactoryBean() {
//        CassandraClusterFactoryBean cassandraClusterFactoryBean = new CassandraClusterFactoryBean();
//        cassandraClusterFactoryBean.setContactPoints("localhost");
//        cassandraClusterFactoryBean.setMetricsEnabled(false);
//        cassandraClusterFactoryBean.setPort(9142);
//        return cassandraClusterFactoryBean;
//    }
//
//    @Bean
//    public CassandraMappingContext cassandraMappingContext() throws ClassNotFoundException {
//        CassandraMappingContext cassandraMappingContext = new CassandraMappingContext();
//        cassandraMappingContext.setInitialEntitySet(getInitialEntitySet());
//        return cassandraMappingContext;
//    }

}
