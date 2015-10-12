import javafx.util.Pair;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by Azat Zaripov on 08.10.2015.
 */
@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer operation = 1;
        BigDecimal firstNumber = null;
        BigDecimal secondNumber = null;

        Pair<Boolean, String> error = new Pair<Boolean, String>(false, "");

        BigDecimal result = new BigDecimal(0);
        operation = Integer.parseInt(req.getParameter("operation"));
        try {
            if (req.getParameter("number-1") != null) {
                firstNumber = new BigDecimal(req.getParameter("number-1"));
            }
            if (req.getParameter("number-2") != null) {
                secondNumber = new BigDecimal(req.getParameter("number-2"));
            }
        } catch (Exception e) {
            error = new Pair<Boolean, String>(true, "incorrect input parameters");
        }
        if (!error.getKey()) {
            switch (operation) {
                case 1:
                    result = firstNumber.add(secondNumber);
                    break;
                case 2:
                    result = firstNumber.subtract(secondNumber);
                    break;
                case 3:
                    result = firstNumber.multiply(secondNumber);
                    break;
                case 4:
                    try {
                        if (secondNumber.toString().equals("0"))
                            throw new ArithmeticException();
                        result = firstNumber.divide(secondNumber);
                    } catch (Exception ex) {
                        error = new Pair<Boolean, String>(true, "you can not divide by zero");
                    }
                    break;
            }
        }
        HttpSession session = req.getSession(false);

        if (error.getKey() == true) {
            session.setAttribute("error", error.getValue());
        } else {
            session.setAttribute("answer", result.toString());
        }
        resp.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
