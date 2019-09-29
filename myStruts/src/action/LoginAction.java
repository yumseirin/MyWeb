package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import vo.Person;

import com.opensymphony.xwork2.ModelDriven;

public class LoginAction implements ModelDriven<Person>{
	
	private Person p = new Person();
	
	public Person getModel() {
			return p;
		}
	
	public String login(){
		@SuppressWarnings("unused")
		HttpServletRequest request=ServletActionContext.getRequest();
		System.out.println(p.getUname()+","+p.getPwd());
		return "success";
	}
	public String selectPerson(){
		return "success";	
	}

	
}
