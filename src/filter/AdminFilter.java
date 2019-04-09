package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession httpSession = httpServletRequest.getSession();
        String username = (String) httpSession.getAttribute("username");
        if (username != null && username.length() > 0) {
            int role = (int) httpSession.getAttribute("role");
            if (role == 1) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        } else {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    @Override
    public void destroy() {

    }
}
