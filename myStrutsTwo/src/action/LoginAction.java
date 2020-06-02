package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import vo.User;

import com.opensymphony.xwork2.ModelDriven;

public class LoginAction implements ModelDriven<User> {

	private User user = new User();

	public User getModel() {
		return user;
	}

	public String login2() {
		return "success";
	}

	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user", getModel());
		return "success";
	}

}
