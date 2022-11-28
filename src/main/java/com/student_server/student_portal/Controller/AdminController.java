package com.student_server.student_portal.Controller;

import com.student_server.student_portal.Bean.Admin;
import com.student_server.student_portal.DAO.AdminDAO;
import com.student_server.student_portal.DAO.DAOImplementation.AdminDAOImpl;
import jakarta.ws.rs.* ;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/admin")

public class AdminController {
    AdminDAO admin_dao = new AdminDAOImpl();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_admin(Admin admin_obj)
    {
        if(admin_dao.addAdmin(admin_obj))
        {
            return Response.status(200).entity("Admin Added Successfully").build();
        }
        return Response.status(400).entity("Adding Admin Failed").build();
    }
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response admin_login(Admin adminObj)
    {
        Admin loggedInAdmin =  admin_dao.admin_login(adminObj);
        if (loggedInAdmin == null)
            return  Response.status(204).
                    entity("Unauthorised Admin").build();
        else  return Response.status(200).entity(loggedInAdmin).build();
    }

}
