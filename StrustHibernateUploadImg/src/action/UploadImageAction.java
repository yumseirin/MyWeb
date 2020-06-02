package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import dao.UploadImageDao;

import vo.Tu;

public class UploadImageAction {
	private File image;
	private String imageContentType;
	private String imageFileName;

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String upload() {

		// tu2--存表中
		// =====url=============================================

		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext context = request.getSession().getServletContext();
		String url = context.getRealPath("\\upload\\main");
		try {
			FileUtils.copyFile(image, new File(url, imageFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ====图片存文件里=====

		Tu tu = new Tu();
		tu.setId(1);
		tu.setImageName(imageFileName);
		tu.setImageUrl(url);
		UploadImageDao dao = new UploadImageDao();
		dao.saveImg(tu);

		return "success";
	}

	public String getImg() {

		return "success";
	}

}
