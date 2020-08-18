package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.ItemDao;
import model.Item;

public class IndexController implements Controller {
	private ItemDao itemDao;
	public void setItemDao(ItemDao itemDao) { // DB접속을 위한 DAO객체 선언 및 Setter 
		this.itemDao = itemDao;
	}
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//임마는 콜백 메소드야 자동호출 됨 
		//ModelAndView 형태로 서블릿으로 보낸다. 국룰이다.
		//MV에 저장하는 방법이 몇 가지 있다.
		// 1. 작업의 결과를 Map에 담고, Map을 ModelAndView에 담는다. [ 자료가 多할 시]
		// 2. 작업의 결과를 직접 ModelAndView에 담는다
		List<Item> itemList=this.itemDao.findAll();
		System.out.println("검색된 건 수:"+itemList.size());
		ModelAndView mav=new ModelAndView();
		//1번 방법으로 작업의 결과를 넘겨주기 위해서는, 데이터 개수가 많아야한다.
		//연수원 프로젝트에서는 힘들다. 
		//그러나 1번 방법 연습을 위해서라도 데이터 개수가 적더라도 시도해보고자 합니다.
		// 당분간은 1번 방법으로 데이터를 DispatcherServlet으로 넘깁니다.
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", itemList); //작업의 결과를 맵에 저장
		mav.addAllObjects(map);//맵을 ModelAndView에 저장
		mav.setViewName("index"); //파일경로 삭제 이유 : viewResolver를 사용하면 뷰(jsp)값만 넣어주면 된다
		//클라이언트의 요청을 처리하고 , view의 이름을 리턴.
		return mav;
	}
	
}
