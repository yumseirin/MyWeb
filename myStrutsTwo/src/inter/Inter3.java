package inter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class Inter3 extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		System.out.println("拦截loginAction333");
		long date3 = System.currentTimeMillis();
		String str = arg0.invoke();
		System.out.println("loginAction运行时333="+(System.currentTimeMillis()-date3));

		return str;
	}

}
