package com.myfirst.microservices.currencyexchangeservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.*;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Set;

@Configuration
@EnableCassandraRepositories(basePackages = "com.myfirst.microservices.currencyexchangeservice.repository")
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override protected String getKeyspaceName() {
        return "currency";
    }
    @Override protected boolean getMetricsEnabled() {
        return false;
    }
    @Override public SchemaAction getSchemaAction() {
        return SchemaAction.RECREATE_DROP_UNUSED;
    }
    @Override public String[] getEntityBasePackages() {
        return new String[] {"com.myfirst.microservices.currencyexchangeservice.entity"};
        }
    @Override
    protected Set<Class<?>> getInitialEntitySet() throws ClassNotFoundException {
        return CassandraEntityClassScanner.scan(getEntityBasePackages());
    }

    @Bean
    public CassandraOperations cassandraOperations() throws Exception {
        return new CassandraTemplate(session().getObject());
    }
    @Bean
    public CassandraClusterFactoryBean cassandraClusterFactoryBean() {
        CassandraClusterFactoryBean cassandraClusterFactoryBean = new CassandraClusterFactoryBean();
        cassandraClusterFactoryBean.setContactPoints("localhost");
        cassandraClusterFactoryBean.setMetricsEnabled(false);
        cassandraClusterFactoryBean.setPort(9142);
        return cassandraClusterFactoryBean;
    }

    @Bean
    public CassandraMappingContext cassandraMappingContext() throws ClassNotFoundException {
        CassandraMappingContext cassandraMappingContext = new CassandraMappingContext();
        cassandraMappingContext.setInitialEntitySet(getInitialEntitySet());
        return cassandraMappingContext;
    }


}
