package mk.ukim.finki.wpvezbi.web.servlet;

import mk.ukim.finki.wpvezbi.model.Category;
import mk.ukim.finki.wpvezbi.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "category-servlet", urlPatterns = "/servlet/category")
public class CategoryServlet extends HttpServlet {

    private final CategoryService categoryService;

    public CategoryServlet(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ipAddress=req.getRemoteAddr();
        String clientAgent=req.getHeader("User-agent");
        PrintWriter out= resp.getWriter();
        out.println("<html><head><body>");
        out.println("<h3>User info</h3>");
        out.format("IP Address: %s",ipAddress);
        out.format("Client agent: %s",clientAgent);
        out.println("<h1>Category list</h1><ul>");
        categoryService.listCategories().forEach(r->out.format("<li>%s</li>",r.getName()));
        out.println("</ul>");
        out.println("<h2>Add New Category</h2>");

        out.println("<form method='POST' action='/servlet/category'/>");
        out.println("<label for='name'>Name:<label>");
        out.println("<input id='name' type='text' name='name'/>");
        out.println("<label for='desc'>Name:<label>");
        out.println("<input id='desc' type='text' name='desc'/>");
        out.println("<input type='submit' value='Submit'/>");
        out.println("</form>");

        out.println("</body></head></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName=req.getParameter("name");
        String categoryDescription=req.getParameter("desc");
        categoryService.create(categoryName,categoryDescription);
        resp.sendRedirect("/servlet/category");

    }

}
