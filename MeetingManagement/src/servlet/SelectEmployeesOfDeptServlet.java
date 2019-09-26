package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import service.EmployeeService;
import vo.Employee;

@SuppressWarnings("serial")
public class SelectEmployeesOfDeptServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String departmentid = request.getParameter("deptid");
		
		EmployeeService service = new EmployeeService();
		
		List<Employee> list = service.selectEmployeesOfDept(Integer.parseInt(departmentid));
		String str =JSON.toJSONString(list);
         System.out.println(str);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(str);
		out.flush();
		out.close();		
	}

}
