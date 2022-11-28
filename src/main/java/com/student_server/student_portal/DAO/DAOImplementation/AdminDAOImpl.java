package com.student_server.student_portal.DAO.DAOImplementation;
import com.student_server.student_portal.Bean.Admin;
import com.student_server.student_portal.DAO.AdminDAO;
import com.student_server.student_portal.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;

public class AdminDAOImpl implements AdminDAO {

    @Override
    public boolean addAdmin( Admin admin_obj) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(admin_obj);
            transaction.commit();
            return true;
//             Admin adminData = session.get();
        } catch (HibernateException exception) {
            // if Hibernate Exception occurs return false
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        } catch (Exception e) {
            //generalized exception class for any IO / Arithmetic Exception
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }
        @Override
        public Admin admin_login( Admin adminObj)
        {
            String email = adminObj.getEmail();
            String password = adminObj.getPassword();
            try(Session session = HibernateSessionUtil.getSession()){
                List<Object> result = new ArrayList<Object>(
                        session.createQuery("From Admin Where email= : email  and password = :password").setParameter("email",email).setParameter("password",password).list()
                );
                if(result.size() == 0)
                    return null;
                else
                    return (Admin) result.get(0);
            }
            catch (HibernateException exception) {
                // if Hibernate Exception occurs return false
                System.out.println("Hibernate Exception");
                System.out.print(exception.getLocalizedMessage());
                return  null;
            }
            catch (Exception e){
                //generalized exception class for any IO / Arithmetic Exception
                System.out.print(e.getLocalizedMessage());
                return null;
            }
    }



}
