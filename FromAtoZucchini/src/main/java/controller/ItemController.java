package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Item;
import model.User;

@Controller
public class ItemController {
	@Autowired
	private ItemDao itemDao;
	
	@RequestMapping(value="/item/itemDetail.html")
	public ModelAndView detail(String CODE) {
		ModelAndView mav = new ModelAndView("home/template");
		//CODE에 있는 상품번호로 DB에서 상품검색
		Item item = itemDao.getItemDetail(CODE);
		//검색결과를 ModelAndView에 저장
		mav.addObject("ITEM",item);
		//ModelAndView에 상품상세정보JSP(itemDetil.jsp) 저장
		mav.addObject("BODY","itemDetail.jsp");
		return mav;
	}
	
	@RequestMapping(value="/item/entry.html")
	public ModelAndView entry(@Valid Item item, 
				BindingResult bindingResult, HttpSession session) {
		ModelAndView mav = new ModelAndView("home/template");
		if(bindingResult.hasErrors()) {
			mav.addObject("BODY","inputItem.jsp");
			return mav;
		}
		String id = (String)session.getAttribute("loginUser");
		if(id == null) {//로그인을 안 한 경우
			mav.addObject("RESULT","nomember");
			//nologin.jsp에 객체(User)주입
			mav.addObject(new User());
			mav.addObject("BODY","nologin.jsp");//nologin.jsp를 출력
			return mav;
		}else {//로그인을 한 경우
			//상품정보를 DB에 삽입한다.
			itemDao.putItem(item);
			return new ModelAndView("redirect:/item/itemList.html");
		}
	}
	@RequestMapping(value="/item/itemList.html")
	public ModelAndView readItem(Integer PAGENO) {
		ModelAndView mav = new ModelAndView("home/template");
		if(PAGENO == null) PAGENO = 1;
		//DB에서 상품정보 5개만 검색
		List<Item> itemList = itemDao.get5Items(PAGENO);
		//검색결과를 ModelAndView에 저장
		mav.addObject("ITEM_LIST", itemList);
		//ModelAndView에 상품목록JSP(itemListView.jsp)를 저장
		mav.addObject("BODY","itemListView.jsp");
		return mav;
	}
	
	@RequestMapping(value="/item/inputItem.html")
	public ModelAndView inputItem() {
		ModelAndView mav = new ModelAndView("home/template");
		//상품등록을 위한 모델 객체를 주입한다.
		mav.addObject(new Item());
		mav.addObject("BODY","inputItem.jsp");
		return mav;
	}
}

















