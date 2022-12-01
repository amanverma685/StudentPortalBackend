package com.student_server.student_portal.Controller;

import com.student_server.student_portal.Bean.Specialisation;
import com.student_server.student_portal.DAO.DAOImplementation.SpecialisationDAOImpl;
import com.student_server.student_portal.DAO.SpecialisationDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/specialisation")

public class SpecialisationController {

        SpecialisationDAO speDAO = new SpecialisationDAOImpl();

        @POST
        @Path("/add")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.TEXT_PLAIN)
        public Response add_specialisation(Specialisation speObj)
        {
                System.out.println(speObj);

                if(speDAO.addSpecialisation(speObj))
                {
                        return  Response.status(200).entity("Success").build();
                }
              return  Response.status(400).entity("Failure while accepting specialisation").build();
        }

        @GET
        @Path("/get")
        @Produces(MediaType.APPLICATION_JSON)
        public Response get_all_specialisations(){
                List<Specialisation> speObj = speDAO.getSpecialisationList();
                return Response.status(200).entity(speObj).build();
        }

        @DELETE
        @Path("/{specialisation_id}")
        @Produces(MediaType.TEXT_PLAIN)
        public Response deleteSpecialisation(@PathParam("specialisation_id") int specialisation_id) {
                boolean successfulDelete = speDAO.deleteSpecialisation(specialisation_id);
                if (successfulDelete)
                        return Response.status(204).build();
                else
                        return Response.status(400).build();
        }


        @PUT
        @Path("/update")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.TEXT_PLAIN)
        public Response update_specialisation(Specialisation speObj)
        {
                System.out.println(speObj);

                if(speDAO.updateSpecialisation(speObj))
                {
                        return  Response.status(200).entity("Success").build();
                }
                return  Response.status(400).entity("Failure while accepting specialisation").build();
        }




}

