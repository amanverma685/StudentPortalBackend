package com.student_server.student_portal.DAO;

import com.student_server.student_portal.Bean.Admin;
import com.student_server.student_portal.Bean.Specialisation;

public interface AdminDAO {

    boolean addAdmin(Admin admin_obj);
    Admin admin_login(Admin adminObj);
}
