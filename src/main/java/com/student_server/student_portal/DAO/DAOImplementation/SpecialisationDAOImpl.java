package com.student_server.student_portal.DAO.DAOImplementation;

import com.student_server.student_portal.Bean.Courses;
import com.student_server.student_portal.Bean.Specialisation;
import com.student_server.student_portal.DAO.SpecialisationDAO;
import com.student_server.student_portal.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class SpecialisationDAOImpl implements SpecialisationDAO {
    @Override
    public boolean addSpecialisation(Specialisation speObj)
    {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();

            session.save(speObj);
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
    public List<Specialisation> getSpecialisationList() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Specialisation> specialisationList = new ArrayList<>();
            for (final Object d : session.createQuery("from Specialisation ").list()) {
                specialisationList.add((Specialisation) d);
            }
            return specialisationList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public boolean deleteSpecialisation(int specialisation_id) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            String query_string="DELETE FROM Specialisation WHERE specialisation_id= :specialisation_id";
            Query query=session.createQuery(query_string);
            query.setParameter("specialisation_id", specialisation_id);
            query.executeUpdate();
            transaction.commit();
            return true;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());

        }
        return false;
    }

    @Override
    public boolean updateSpecialisation(Specialisation speObj)
    {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();

            session.update(speObj);
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
}
