package repository;

import java.util.List;

public interface MedClinicRepository {

    String findTheBestMedClinic();

    List<String> getMedClinicNames();

    String findNameById(Integer id);
}
