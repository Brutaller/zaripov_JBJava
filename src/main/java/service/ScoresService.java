package service;

import model.Score;
import model.Subjects;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Azat Zaripov on 23.10.2015.
 */
public interface ScoresService {

    BigInteger findSumScoresById(Integer id);

    BigDecimal findAvgScoresById(Integer id);

    Integer findScoresBySubject(Integer id, Integer subject);

    void addScore(Score score);

}
