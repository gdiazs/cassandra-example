package com.github.gdiazs.example.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("/ping")
public class PingResource {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
}
