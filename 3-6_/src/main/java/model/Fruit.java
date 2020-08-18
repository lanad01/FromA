package model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

public class Fruit {
	@NotNull(message="상품번호를 입력하시오")  //hibernate-validator 라이브러리 의존성 잡아줘야함
	private Integer item_id;
	@NotEmpty
	private String item_name; //이와 같이 Hibernate를 통한 message출력설정이 안되 있을 경우 properties에서 불러온다.
	//org.hibernate.validator.constraints.NotEmpty.message가 있더라.
	@NotNull
	@Min(0)
	@Range(min=0, max=1000000, message="{min}보다 크고 {max}보다 작아야합니다.")
	private Integer price;
	@NotEmpty(message="상품설명을 입력하세요")
	private String description;
	private String picture_url;
	private MultipartFile picture;
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}

	
}
