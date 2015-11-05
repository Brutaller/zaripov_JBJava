package repository.impl;

import repository.ProviderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProviderRepositoryImpl implements ProviderRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<String> findByMedClinicOfficeStreetAndCity(String name, String city, String street) {
        Query query = entityManager.createNativeQuery("select provider.name from med_clinic INNER JOIN office on med_clinic.id = office.med_clinic_id INNER JOIN provider on office_id = provider.office_id where med_clinic.name = ? and office.city = ? and office.street = ?");
        query.setParameter(1, name);
        query.setParameter(2, city);
        query.setParameter(3, street);
        return query.getResultList();
    }
}
