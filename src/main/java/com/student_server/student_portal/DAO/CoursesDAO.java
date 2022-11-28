package com.student_server.student_portal.DAO;

import com.student_server.student_portal.Bean.Courses;
import com.student_server.student_portal.DAO.DAOImplementation.CoursesDAOImpl;

import java.util.List;

public interface CoursesDAO {
    boolean addCourses(Courses courseObj);
    boolean deleteCourse(int course_id);
    boolean updateCourse( int course_id);
    List<Courses> getCoursesList(int specialisation_id);
    List<Courses> getAllCoursesList();
}
