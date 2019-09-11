package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.Log;

import dao.CountsDao;

public class CountsListener implements ServletContextListener {

	/**
	 * 关闭前--从上下文中拿count放数据库中
	 */
	public void contextDestroyed(ServletContextEvent arg0) {

		Log.logger.info("关闭tomcat!");
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

		Log.logger.info("启动tomcat!");
		CountsDao dao = new CountsDao();
		arg0.getServletContext().setAttribute("count", dao.selectCounts());
	}

}
