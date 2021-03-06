package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Item;

@Controller
public class DetailController {
	//상세정보를 찾읍시다.
	private ItemDao itemDao;

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	@RequestMapping
	public ModelAndView returnView(Integer itemId) {//콜백 메서드
		Item item=this.itemDao.findById(itemId); //DB조회
		ModelAndView mav=new ModelAndView(); //리턴할 view 생성
		Map<String,Object> map=new HashMap<String,Object>(); 
		//view와 함께 보낼 데이터를 map의 형태로 저장
		map.put("sendMap",item); //속성 이름과 값을 가진 map에 값 저장 시작
		mav.addAllObjects(map); // 멩글어진 map을 리턴할 view에 추가
		mav.setViewName("detail"); //리턴할 view의 식별자 지정
		return mav;
//		ModelAndView : 데이터를 전송시킬 수 있는 리턴 타입
//		(cf. String 타입은 단순하게 페이지만 열어주는 역할을 함)
//		setViewName : 어떤 페이지를 보여줄 것인지
//		addObject : key와 value를 담아 보낼 수 있는 메서드
//		setAttribute를 여러개 썼던 것 처럼, addObject를 여러개 쓸 수 있다.
	}
}
