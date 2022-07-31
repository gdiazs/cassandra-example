package com.github.gdiazs.example.dao;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Row;
import com.github.gdiazs.example.entities.Employee;
import com.github.gdiazs.example.cassandra.CassandraClient;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class EmployeeDao {

    @Inject
    private CassandraClient cassandraClient;

    public List<Employee> all() {
        final Session session = this.cassandraClient.getSession();
        final ResultSet rs = session.execute("select * from  examplespace.employees");
        return rs.all().stream()
                .map((Row row)
                        -> new Employee(row.getString("name"),
                        row.getString("position"))).collect(Collectors.toList());

    }

}
