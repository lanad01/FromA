package sample2;

public class KwonSangwoo implements Human {
	private String name;
	private Item item;
	
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
