package bean;


public class MemberBean {
	private int mem_num;
	private String mem_id, mem_nick, mem_passward;
	
	public MemberBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberBean(int mem_num, String mem_id, String mem_nick, String mem_passward) {
		super();
		this.mem_num = mem_num;
		this.mem_id = mem_id;
		this.mem_nick = mem_nick;
		this.mem_passward = mem_passward;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_nick() {
		return mem_nick;
	}
	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}
	public String getMem_passward() {
		return mem_passward;
	}
	public void setMem_passward(String mem_passward) {
		this.mem_passward = mem_passward;
	}
}
	