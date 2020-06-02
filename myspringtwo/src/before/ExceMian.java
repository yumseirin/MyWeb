package before;

import org.aspectj.lang.JoinPoint;

public class ExceMian {
	public void log(JoinPoint jp, Throwable t) {
		System.out.println("异常通知");
		System.out.println("t为目标组件发生异常的信息：" + t);

	}

}
