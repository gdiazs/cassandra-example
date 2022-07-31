package com.github.gdiazs.example.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import java.util.UUID;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CassandraClient {

    private Cluster cluster;
    private Session session;

    private static final Logger LOG = Logger.getLogger(CassandraClient.class.getName());

    @PostConstruct
    public void setup() {
        this.cassandraSession();
        this.session.execute("CREATE KEYSPACE IF NOT EXISTS examplespace WITH REPLICATION = { 'class' : 'NetworkTopologyStrategy', 'datacenter1' : 3 }");
        this.session.execute("CREATE TABLE IF NOT EXISTS examplespace.employees (name text primary key, position text)");
        this.session.execute(String.format("insert into examplespace.employees (name, position) values ('%s', 'developer')", "user" + UUID.randomUUID().toString()));
        LOG.info("Employee inserted");
    }

    @PreDestroy
    public void tearDown() {
        if (session != null) {
            session.close();
        }
        if (cluster != null) {
            cluster.close();
        }
        LOG.info("Clossing cassandra session");
    }

    private Session cassandraSession() {
        this.cluster = Cluster.builder()
                .addContactPoint("127.0.0.1")
                .withPort(9042).build();
        this.session = this.cluster.connect();
        LOG.info("Cassandra Session Initialized");
        return this.session;

    }

    public Session getSession() {
        return this.session;
    }

}
