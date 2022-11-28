package com.student_server.student_portal.DAO.DAOImplementation;

import com.student_server.student_portal.Bean.Courses;

import com.student_server.student_portal.DAO.CoursesDAO;
import com.student_server.student_portal.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CoursesDAOImpl implements CoursesDAO {

    @Override
    public boolean addCourses(Courses course_obj)
    {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.save(course_obj);
            transaction.commit();
            return  true;
        }
        catch (HibernateException exception) {
            // if Hibernate Exception occurs return false
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
        catch (Exception e){
            //generalized exception class for any IO / Arithmetic Exception
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }


    @Override
    public boolean deleteCourse(int course_id) {
        try (Session session = HibernateSessionUtil.getSession()) {
            session.createQuery("delete from Courses where course_id= :course_id") ;
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean updateCourse(int course_id) {
        return false;
    }

    @Override
    public List<Courses> getAllCoursesList() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Courses> coursesList = new ArrayList<>();
            for (final Object d : session.createQuery(" from Courses").list()) {
                coursesList.add((Courses) d);
            }

            return coursesList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<Courses> getCoursesList(int specialisation_id) {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Courses> coursesList = new ArrayList<>();
            for (final Object d : session.createQuery("from Courses").list()) {
                coursesList.add((Courses) d);
            }

            return coursesList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

}
