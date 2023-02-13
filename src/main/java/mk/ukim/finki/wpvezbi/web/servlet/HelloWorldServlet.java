package mk.ukim.finki.wpvezbi.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloworldservlet",urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
    {
        String username=req.getParameter("username");



        PrintWriter writer=resp.getWriter();
        writer.format("<html><head><body><h1>Hi %s!</h1></body></head></html>", username);
        writer.flush();
    }
}
