package repository.impl;

import model.Score;
import model.Subjects;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import repository.ScoresRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Azat Zaripov on 23.10.2015.
 */
@Repository
public class ScoresRepositoryImpl implements ScoresRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public BigInteger findSumScoresById(Integer id) {
        Query query = em.createNativeQuery("SELECT sum(score) FROM scores where student_id = ?");
        query.setParameter(1, id);
        return (BigInteger) query.getSingleResult();
    }

    @Override
    public BigDecimal findAvgScoresById(Integer id) {
        Query query = em.createNativeQuery("SELECT avg(score) FROM scores where student_id = ?");
        query.setParameter(1, id);
        return (BigDecimal) query.getSingleResult();
    }


    @Override
    public Integer findScoresBySubject(Integer id, Integer subject) {
        Query query = null;
        try {
            query = em.createNativeQuery("SELECT score FROM scores WHERE student_id = ? and subject_type = ?");
            query.setParameter(1, id);
            query.setParameter(2, subject);
            return (Integer) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public void addScore(Score score) {
        em.persist(score);
    }

}