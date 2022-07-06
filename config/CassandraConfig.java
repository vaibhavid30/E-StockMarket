package com.estockmarket.stockmarket.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {

    
    @Value("${spring.data.cassandra.keyspace-name}")
    private String keySpace;

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
      return Collections.singletonList(CreateKeyspaceSpecification.createKeyspace(keySpace)
                  .ifNotExists()
                  .with(KeyspaceOption.DURABLE_WRITES, true)
                  .withSimpleReplication());
    }

    @Override
    public SchemaAction getSchemaAction() {
    return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
    return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(keySpace));
    }

    @Override
    protected String getKeyspaceName() {
        return keySpace;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.estockmarket.stockmarket.model"};
    }
}
