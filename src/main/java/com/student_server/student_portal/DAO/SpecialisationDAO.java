package com.student_server.student_portal.DAO;
import com.student_server.student_portal.Bean.Specialisation;

import java.util.List;

public interface SpecialisationDAO {
    boolean addSpecialisation(Specialisation speObj);
    List<Specialisation> getSpecialisationList();
    boolean updateSpecialisation(Specialisation speObj);

    boolean deleteSpecialisation(int specialisation_id);


}
