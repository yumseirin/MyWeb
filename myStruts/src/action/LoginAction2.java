package action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import vo.Person;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction2 implements ModelDriven<Person>{
	
	private Person p = new Person();
	
	public Person getModel() {
			return p;
		}
	
	public String login(){
		//HttpServletRequest request=ServletActionContext.getRequest();
		System.out.println(p.getUname()+","+p.getPwd());
		//解耦：
		ActionContext cont = ActionContext.getContext();
		//request
		Map<String,Object>request = (Map<String,Object>)cont.get("request");
		request.put("requestJO", "requestJO");
		//session
		Map<String,Object>session=cont.getSession();
		session.put("sessionJO","sessionJO");
		//application
		Map<String,Object>application=cont.getApplication();
		application.put("applicationJO","applicationJO");
		
		//耦合
		//request
		HttpServletRequest request2 = ServletActionContext.getRequest();
		request2.setAttribute("requestOH", "requestOH");
		//session
		HttpSession session2 = request2.getSession();
		session2.setAttribute("sessionOH", "sessionOH");
		//application == ServletContext
		ServletContext cont2 = session2.getServletContext();
		cont2.setAttribute("applicationOH", "applicationOH");
		
		return "success";
	}
	public String selectPerson(){
		return "success";	
	}

	
}
