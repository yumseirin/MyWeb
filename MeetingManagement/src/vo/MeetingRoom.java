package vo;
/**
 * 会议室实体类
 * @author seirin
 *
 */
public class MeetingRoom {
	private Integer roomid; //会议室id
	private String roomnum; //门牌号
	private String roomname; //会议室名称
	private Integer capacity; //容纳人数
	private Integer status; //当前状态
	private String remark; //备注
	private Integer employeeid; //谁添加的会议
	
	public Integer getRoomid() {
		return roomid;
	}
	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}
	public String getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}
	
	
}
