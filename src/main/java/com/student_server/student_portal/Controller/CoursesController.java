package com.student_server.student_portal.Controller;

import com.student_server.student_portal.Bean.Courses;
import com.student_server.student_portal.Bean.Specialisation;
import com.student_server.student_portal.DAO.CoursesDAO;
import com.student_server.student_portal.DAO.DAOImplementation.CoursesDAOImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/course")
public class CoursesController {

    CoursesDAO course_dao = new CoursesDAOImpl();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addCourses (Courses course_obj)
    {   System.out.println("Inside AddCourse");
        System.out.println(String.valueOf(course_obj));

        if(course_dao.addCourses(course_obj))
        {
            return  Response.status(200).entity("Course Added Successfully").build();
        }
        return  Response.status(400).entity("Failure while adding courses").build();
    }

    @DELETE
    @Path("/delete_course")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteCourse (int course_id)
    {
        if(course_dao.deleteCourse(course_id))
        {
            return  Response.status(200).entity("Success").build();
        }
        return  Response.status(400).entity("Failure while deleting specialisation").build();
    }


    @GET
    @Path("/get_courses")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesList(int specialisation_id){
        List<Courses> speObj = course_dao.getCoursesList( specialisation_id);
        return Response.status(200).entity(speObj).build();
    }

    @GET
    @Path("/get_all_courses")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCoursesList(){
        List<Courses> speObj = course_dao.getAllCoursesList();
        return Response.status(200).entity(speObj).build();
    }



}
