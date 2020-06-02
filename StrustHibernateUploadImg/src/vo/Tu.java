package vo;

/**
 * Tu entity. @author MyEclipse Persistence Tools
 */

public class Tu implements java.io.Serializable {

	// Fields

	private Integer id;
	private String imageUrl;
	private String imageName;

	// Constructors

	/** default constructor */
	public Tu() {
	}

	/** minimal constructor */
	public Tu(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Tu(Integer id, String imageUrl, String imageName) {
		this.id = id;
		this.imageUrl = imageUrl;
		this.imageName = imageName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}