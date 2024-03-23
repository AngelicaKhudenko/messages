package by.it_academy.jd2.messages.controller.filter;

import by.it_academy.jd2.messages.core.exceptions.UnauthorizedException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns ="/*")
public class ExceptionHandlerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest,servletResponse);
        } catch (IllegalArgumentException e){
            PrintWriter writer=servletResponse.getWriter();
            writer.write("<p>"+"Ошибка: "+e.getMessage()+"</p>");

            if (servletResponse instanceof HttpServletResponse) {
                HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
                httpServletResponse.setStatus(400);
            }
        } catch (UnauthorizedException e){
            PrintWriter writer=servletResponse.getWriter();
            writer.write("<p>"+"Ошибка авторизации: "+e.getMessage()+"</p>");

            if (servletResponse instanceof HttpServletResponse) {
                HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
                httpServletResponse.setStatus(401);
            }
        } catch (Exception e){
            PrintWriter writer=servletResponse.getWriter();
            writer.write("<p>"+"Ошибка на сервере</p>");

            if (servletResponse instanceof HttpServletResponse) {
                HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
                httpServletResponse.setStatus(500);
            }
        }
    }
}
