package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Item;
import model.User;
@Controller 
public class IndexController{
	@Autowired
	private ItemDao itemDao;
	@RequestMapping
	public ModelAndView handleRequest(
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {
	//스프링 웹의 규칙에 따라, 작업의 결과를 ModelAndView에 저장한다.
	//ModelAndView에 저장하는 방법이 몇 가지 있다.
	//1. 작업의 결과를 Map에 담고, Map을 ModelAndView에 저장
	//2. 작업의 결과를 ModelAndView에 직접 저장
	//예)작업의 결과가 10개가 있다고 가정
	//1. 10개의 데이터를 한 개의 Map에 저장, Map을 ModelAndView에 저장
	//2. 10개의 데이터를 각각 ModelAndView에 저장
		List<Item> itemList = this.itemDao.findAll();
		ModelAndView mav = new ModelAndView();
		//1번 방법으로 작업의 결과를 넘겨주기위해서는,
		//데이터의 갯수가 많아야된다. 따라서, 1번 방법으로 데이터를
		//넘겨줄 정도의 대규모 프로젝트는 작성을 하지 않을 예정이므로,
		//2번 방법을 사용할 예정입니다. 하지만, 2번 방법만 사용하면
		//1번 방법의 사용법을 학습하지 못하므로, 데이터의 갯수가 작더라도
		//당분간은 1번 방법으로 데이터를 DispatcherServlet으로 넘긴다.
		Map<String,Object> map = new HashMap<String,Object>();
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null) {//로그인 상태를 의미한다.
			mav.addObject("loginUser",loginUser);
		}
		map.put("list", itemList);//작업의 결과를 맵에 저장
		mav.addAllObjects(map);//맵을 ModelAndView에 저장
//		mav.setViewName("/WEB-INF/jsp/index.jsp");//작업의 결과를 보여줄 뷰(JSP)를 설정
//		mav.setViewName("index");//작업의 결과를 보여줄 뷰(JSP)를 설정
		return mav;//ModelAndView가 DispatcherServlet로 전달
	}

}
















