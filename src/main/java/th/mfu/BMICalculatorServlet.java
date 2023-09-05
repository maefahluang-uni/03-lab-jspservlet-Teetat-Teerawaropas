package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String weightinStr = request.getParameter("weight");
        String heightinStr = request.getParameter("height");
        response.setContentType("text/html");
        //TODO: calculate bmi
        double weight = Double.parseDouble(request.getParameter("weight"));
        double height = Double.parseDouble(request.getParameter("height"));
        double result = Math.round(weight/(height*height));

        //TODO: determine the built from BMI
        String bmi_result ="normal";
        if (result < 18.5) {
            bmi_result = "underweight";
        } else if (result < 25) {
            bmi_result = "normal";
        } else if (result < 30) {
            bmi_result = "overweight";
        } else if (result < 35) {
            bmi_result = "obese";
        } else {
            bmi_result = "extremely obese";
        }
      
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("result", result);
        request.setAttribute("bmi_result", bmi_result);

        

        //TODO: forward to jsp
        request.getRequestDispatcher("/bmi_result.jsp").forward(request, response);
           
    }
    
}
