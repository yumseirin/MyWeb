package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DepartmentService;
/**
 * 更改部门信息
 * @author seirin
 *
 */
@SuppressWarnings("serial")
public class UpdateDepServlet extends HttpServlet {
    private DepartmentService departmentService = new DepartmentService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
        String depName = request.getParameter("depName");
        int i = departmentService.updateDepartmentById(depName, Integer.parseInt(id));
        PrintWriter out = response.getWriter();
        if (i == 1) {
            out.write("修改成功");
        } else {
            out.write("修改失败");
        }
	}

}
