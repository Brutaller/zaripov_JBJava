package repository;

import model.MedClinic;
import model.Office;

import java.util.List;

public interface OfficeRepository {

    List<Office> findByMedClinic(MedClinic medClinic);

    Integer getTheMostProfitableOffice();

    List<Integer> findAllId();

    String getMedClinicId(Integer id);

    String getStreet(Integer id);

    String getCity(Integer id);

    List<String> getAllCities(String name);

    List<String> getAllStreetInCityOfMedClinic(String name, String city);
}
