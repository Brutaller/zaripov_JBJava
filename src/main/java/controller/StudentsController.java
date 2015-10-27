package controller;

import model.Score;
import model.Student;
import model.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ScoresService;
import service.StudentService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Azat Zaripov on 23.10.2015.
 */
@Controller
public class StudentsController {

    @Autowired
    StudentService studentService;

    @Autowired
    ScoresService scoresService;

    @RequestMapping(value = "/sum")
    public String showAllScores(@ModelAttribute("student") Student student, Model model) {
        Integer result = studentService.findStudent(student);
        BigInteger score = scoresService.findSumScoresById(result);
        model.addAttribute("result",score);
        return "result";
    }

    @RequestMapping(value = "/avg")
    public String showAvgScore(@ModelAttribute Student student, Model model) {
//        Integer result = studentService.findStudent(student);
//        List<Score> scores = scoresService.findScoresById(result);
//        int count = 0;
//        int res = 0;
//        for (Score score : scores) {
//            count++;
//            res += score.getScore();
//        }
//        model.addAttribute("result", (res / count));

        Integer result = studentService.findStudent(student);
        BigDecimal scores = scoresService.findAvgScoresById(result);
        model.addAttribute("result", scores);
        return "result";
    }

    @RequestMapping(value = "/subj")
    public String showSubjectScore(@ModelAttribute Student student, @RequestParam Integer subject, Model model) {
        Integer result = studentService.findStudent(student);
        Integer scores = scoresService.findScoresBySubject(result, subject);
        model.addAttribute("result", scores);
        return "result";
    }
}
