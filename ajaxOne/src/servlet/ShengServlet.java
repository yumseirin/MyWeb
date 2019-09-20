package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AreaService;
import vo.Area;

import com.alibaba.fastjson.JSON;

@SuppressWarnings("serial")
public class ShengServlet extends HttpServlet {

	
	private AreaService service = new AreaService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Area> areaList = service.getSheng();

		String str = JSON.toJSONString(areaList);
		System.out.println(str);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(str);
		out.flush();
		out.close();
	}

}
