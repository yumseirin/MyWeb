package inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class AdminInt extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		System.out.println("拦截AdminInt");
		if (obj != null) {
			String str = arg0.invoke();
			return str;

		} else {
			request.setAttribute("msg", "请登录");
			return "fail";
		}

	}

}
