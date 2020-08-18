package sample2;

public class KimChangMin implements Human {
	private String name;//이름
	private Item item;//과일
	public void setName(String name) {//이름 세터
		this.name = name;
	}
	public void setItem(Item item) {//Item 세터
		this.item = item;
	}
	public void has() {
		System.out.println(name+" 입니다. 다음 과일을 가지고 있습니다.");
		item.showName();
	}
}
