package service.impl;

import model.Score;
import model.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ScoresRepository;
import service.ScoresService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Azat Zaripov on 23.10.2015.
 */
@Service
@Transactional
public class ScoreServiceImpl implements ScoresService {

    @Autowired
    ScoresRepository repository;

    @Override
    public BigInteger findSumScoresById(Integer id) {
        return repository.findSumScoresById(id);
    }

    @Override
    public BigDecimal findAvgScoresById(Integer id){
        return repository.findAvgScoresById(id);
    }

    @Override
    public Integer findScoresBySubject(Integer id, Integer subject) {
        return repository.findScoresBySubject(id, subject);
    }

    @Override
    public void addScore(Score score) {
        repository.addScore(score);
    }
}
