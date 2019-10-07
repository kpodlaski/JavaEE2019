package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(name = "ImgServlet", urlPatterns = "/img")
public class ImgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream img = getClass().getClassLoader()
                .getResourceAsStream("images/"+request.getQueryString());
        response.setHeader("Conetnt-type","image/jpeg");
        OutputStream os =response.getOutputStream();
        int bit;
        while ( (bit=img.read())>=0){
            os.write(bit);
        }
        img.close();
        os.close();
    }
}
