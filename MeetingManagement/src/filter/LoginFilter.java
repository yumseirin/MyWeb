package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录过滤器 验证是否登录
 * 
 * @author seirin
 * 
 */
public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		String servletPath = request.getServletPath();
		if ("/login/login.jsp".equals(servletPath)
				|| "/login/register.jsp".equals(servletPath)
				|| "/register".equals(servletPath)
				|| "/login".equals(servletPath)
				|| servletPath.contains("/images/")
				|| servletPath.contains("/js/")
				|| servletPath.contains("/My97DatePicker/")
				|| servletPath.contains("/styles/")) {
			arg2.doFilter(request, arg1);
		} else {
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("loginedEmployee");
			if (obj == null) {
				request.setAttribute("msg", "请重新登录");
				request.getRequestDispatcher("/login/login.jsp").forward(arg0, arg1);
			} else {
				arg2.doFilter(arg0, arg1);
			}
		}
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
