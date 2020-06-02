package inter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class Inter1 implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation arg0) throws Exception {

		System.out.println("拦截loginAction111");
		long date1 = System.currentTimeMillis();
		String str = arg0.invoke();
		System.out.println("loginAction运行时111="
				+ (System.currentTimeMillis() - date1));

		return str;
	}

}
