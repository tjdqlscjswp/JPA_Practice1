package model;

public class ManagerVO {
	int mgr_id;
	int mgr_password;
	
	
	public ManagerVO() {
		
	}
	
	
	public ManagerVO(int mgr_id, int mgr_password) {
		super();
		this.mgr_id = mgr_id;
		this.mgr_password = mgr_password;
	}
	public int getMgr_id() {
		return mgr_id;
	}
	public void setMgr_id(int mgr_id) {
		this.mgr_id = mgr_id;
	}
	public int getMgr_password() {
		return mgr_password;
	}
	public void setMgr_password(int mgr_password) {
		this.mgr_password = mgr_password;
	}
	
	
}
