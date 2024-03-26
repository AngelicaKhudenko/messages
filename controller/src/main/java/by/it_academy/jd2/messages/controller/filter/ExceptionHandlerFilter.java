package by.it_academy.jd2.messages.controller.filter;

import by.it_academy.jd2.messages.core.exceptions.UnauthorizedException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;


@WebFilter(urlPatterns ="/*")
public class ExceptionHandlerFilter implements Filter {
    private final static Logger logger= LogManager.getLogger();
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        boolean mistakeExistance=false;
        String mistakeMessage="";
        int statusCode=200;

        try {
            filterChain.doFilter(servletRequest,servletResponse);
        } catch (IllegalArgumentException e){

            logger.log(Level.WARN, "Пользователь передал некорректные данные",e);

            mistakeExistance=true;
            mistakeMessage=e.getMessage();
            statusCode=400;

        } catch (UnauthorizedException e){

            logger.log(Level.WARN, "Ошибка авторизации пользователя",e);

            mistakeExistance=true;
            mistakeMessage="Ошибка авторизации: "+e.getMessage();
            statusCode=401;

        } catch (Exception e){

            logger.log(Level.ERROR, "Ошибка на сервере",e);

            mistakeExistance=true;
            mistakeMessage="Ошибка на сервере";

        } finally {

            if (mistakeExistance){

                PrintWriter writer=servletResponse.getWriter();
                writer.write("<p>"+mistakeMessage+"</p>");

                if (servletResponse instanceof HttpServletResponse) {
                    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
                    httpServletResponse.setStatus(statusCode);
                }
            }
        }
    }
}
