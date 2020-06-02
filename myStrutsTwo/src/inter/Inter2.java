package inter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class Inter2  extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("拦截loginAction222");
		long date2 = System.currentTimeMillis();
		String str = arg0.invoke();
		System.out.println("loginAction运行时222="+(System.currentTimeMillis()-date2));

		return str;
	}

}
