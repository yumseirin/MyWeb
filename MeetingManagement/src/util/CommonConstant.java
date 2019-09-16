package util;

/**
 * 系统相关常量定义
 * @author seirin
 * @version v1.0
 */
public class CommonConstant {
	
	/**
	 * 人员角色
	 */
	public static final String ROLEMANAGE="0";   //管理员
	public static final String ROLEEMPLOYEE="1"; //员工
	
	/**
	 * 人员状态
	 *  
	 */
	public static final String STATUS1="0"; //正在审核，登录失败
	public static final String STATUS2="1"; //登录成功
	public static final String STATUS3="2"; //审核未通过，登录失败
	public static final String STATUS4="3"; //用户名或密码错误，登录失败
	public static final String STATUS5="4"; //关闭
	public static final String STATUS6="5"; //所有状态
	
	/**
	 * 部门状态
	 */
	public static final String DEPARTMENTSTATUS1="0"; //有效
	public static final String DEPARTMENTSTATUS2="1"; //无效
	
	/**
	 * 会议室状态
	 */
	public static final String MEETINGROOMSTATUS0="0"; //空闲
	public static final String MEETINGROOMSTATUS1="1"; //占用
	
	/**
	 * 预订会议状态
	 */
	public static final String MEETINGSTATUS0="0";  //正常
	public static final String MEETINGSTATUS1="1";  //撤销
	
	/**
	 * 每页显示几条记录
	 */
	public static final String pagesize="3"; 
}
