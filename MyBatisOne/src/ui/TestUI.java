package ui;

import vo.Orders;
import dao.UserAndOrderDao;

public class TestUI {
	private UserAndOrderDao dao = new UserAndOrderDao();

	public void selectUserAndOrder() {
		Orders o = new Orders();
		o = dao.selectUserAndOrder(1);
		System.out.println(o.getId() + "," + o.getNum());
		System.out
				.println(o.getUser().getId() + "," + o.getUser().getUsername());
	}

	public static void main(String[] args) {
		TestUI ui = new TestUI();
		ui.selectUserAndOrder();
	}
}
