package sample2;

public class KimChangMin implements Human {
	private String name; // 주입을 어떻게 하시겠습니까
	private Item item; // 과연

	public void setName(String name) {
		this.name = name;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void has() {
		System.out.print(name+"입니다. 가지고 있는 과일은 다음과 같습니다.  ");
		item.showName();
	}

}
