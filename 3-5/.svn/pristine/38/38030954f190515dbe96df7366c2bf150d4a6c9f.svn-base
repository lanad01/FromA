package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Item;
import model.User;

@Controller
public class DetailController {
	@Autowired
	private ItemDao itemDao;

	@RequestMapping
	public ModelAndView kimchangmin(Integer itemId,HttpSession session){
		Item item = this.itemDao.findById(itemId);
		ModelAndView mav = new ModelAndView();
		Map<String,Object> map = new HashMap<String,Object>();
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null) {//로그인 상태를 의미한다.
			mav.addObject("loginUser",loginUser);
		}
		map.put("changmin",item);
		mav.addAllObjects(map);
		//mav.setViewName("detail");
		return mav;
	}
}























