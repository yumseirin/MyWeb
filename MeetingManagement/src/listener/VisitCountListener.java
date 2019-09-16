package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.CountDao;

public class VisitCountListener implements ServletContextListener{

	private CountDao dao = new CountDao();
	/**
	 * 关闭前--从上下文中拿count放数据库中
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		ServletContext sc = arg0.getServletContext();
		Object obj = sc.getAttribute("count");
		if (obj != null) {
			int count = Integer.parseInt(obj.toString());
			dao.updateCount(count);
		}
	}

	/**
	 * 启动成功后--从数据库中拿count写入上下文中
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		arg0.getServletContext().setAttribute("count", dao.getCount());
	}

}
