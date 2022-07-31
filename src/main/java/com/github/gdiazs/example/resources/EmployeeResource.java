
package com.github.gdiazs.example.resources;

import com.github.gdiazs.example.dao.EmployeeDao;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/employees")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    
    private static final Logger LOG = Logger.getLogger(EmployeeResource.class.getName());

    
    @Inject
    private EmployeeDao employeeDao;
    
    
    @GET
    public Response get(){
        return Response.ok(this.employeeDao.all()).build();
    }
}
