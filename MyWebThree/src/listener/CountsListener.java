package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.CountsDao;

public class CountsListener implements ServletContextListener {

	/**
	 * 关闭前--从上下文中拿count放数据库中
	 */
	public void contextDestroyed(ServletContextEvent arg0) {

		ServletContext sc = arg0.getServletContext();
		Object obj = sc.getAttribute("count");
		if (obj != null) {
			int count = Integer.parseInt(obj.toString());
			CountsDao dao = new CountsDao();
			dao.addCounts(count);
		}
	}

	/**
	 * 启动成功后--从数据库中拿count写入上下文中
	 */
	public void contextInitialized(ServletContextEvent arg0) {

		CountsDao dao = new CountsDao();
		arg0.getServletContext().setAttribute("count", dao.selectCounts());
	}

}
