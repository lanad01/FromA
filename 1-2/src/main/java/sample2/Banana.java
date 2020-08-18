package sample2;

public class Banana implements Item {
	private String name;//과일이름
	public void setName(String name) {
		this.name = name;
	}
	public void showName() {
		System.out.println(name+"입니다.");
	}
}
