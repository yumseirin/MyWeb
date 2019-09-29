package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import service.DepartmentService;
import vo.Department;
/**
 * 注册前获得可用部门
 * @author seirin
 *
 */
@SuppressWarnings("serial")
public class RegDepServlet extends HttpServlet {
	DepartmentService departmentService = new DepartmentService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//List<Department> list = departmentService.selectAllDepartment();
		List<Department> list = departmentService.selectAllUsableDepartment();
		String str = JSON.toJSONString(list);
		System.out.println(str);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(str);
		out.flush();
		out.close();
	}

}
