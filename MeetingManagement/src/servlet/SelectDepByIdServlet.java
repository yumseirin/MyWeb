package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import service.DepartmentService;
import vo.Department;
/**
 * 根据Id获得部门信息
 * @author seirin
 *
 */
@SuppressWarnings("serial")
public class SelectDepByIdServlet extends HttpServlet {
	private DepartmentService departmentService = new DepartmentService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Department dep = departmentService.selectDepartmentById(Integer.parseInt(id));
		String str = JSON.toJSONString(dep);
		//System.out.println(str);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(str);
		out.flush();
		out.close();
	}

}
