package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import vo.Person;

import com.opensymphony.xwork2.ModelDriven;

public class LoginAction2 implements ModelDriven<Person>{
	
	private Person p = new Person();
	
	public Person getModel() {
			return p;
		}
	
	public String login(){
		HttpServletRequest request=ServletActionContext.getRequest();
		System.out.println(p.getUname()+","+p.getPwd());
		request.setAttribute("msg","sbb");
		return "success";
	}
	public String selectPerson(){
		return "success";	
	}

	
}
