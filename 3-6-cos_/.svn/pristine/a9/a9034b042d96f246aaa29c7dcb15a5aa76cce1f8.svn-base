package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ItemDao;
import model.Fruit;

@Controller
public class ItemController {
	@Autowired
	private ItemDao itemDao;
	@RequestMapping(value="/item/confirm.html")
	public ModelAndView confirm(Integer itemId) {
		ModelAndView mav = new ModelAndView("delete");
		Fruit item = this.itemDao.findById(itemId);//번호로 과일 검색
		mav.addObject(item);//조회결과를 저장
		mav.addObject("imageName",item.getPicture_url());//파일이름 저장
		return mav;
	}
	
	@RequestMapping(value="/item/register.html")
	public ModelAndView register(Fruit fruit,HttpServletRequest request) 
		throws Exception{
		//fruit에 저장된 정보를 DB에 삽입, 이미지파일은 업로드한다.
		//업로드 할 때 절대경로(upload폴더의 절대경로)가 필요하다.
		//절대경로를 획득하기위해서 HttpServletRequest가 필요하다.
		ServletContext ctx = request.getSession().getServletContext();
		String filePath = ctx.getRealPath("/upload");
		String encType = "euc-kr";
		MultipartRequest multipart = new MultipartRequest(request,
				filePath, 5*1024*1024, encType,
				new DefaultFileRenamePolicy());
		String pictureUrl = multipart.getFilesystemName("pictureUrl");//업로드
		fruit.setItem_id(Integer.parseInt(
				multipart.getParameter("item_id")));//상품번호 설정
		fruit.setItem_name(multipart.getParameter("item_name"));//이름설정
		fruit.setPrice(Integer.parseInt(multipart.getParameter("price")));
		fruit.setPicture_url(pictureUrl);//이미지 파일이름 설정
		fruit.setDescription(multipart.getParameter("description"));
		this.itemDao.create(fruit);//DB에 삽입
		return index();//삽입 후 다시 목록을 띄운다.
	}
	
	@RequestMapping(value="/item/create.html")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("add");
		mav.addObject(new Fruit());
		return mav;
	}
	
	@RequestMapping(value="/item/index.html")
	public ModelAndView index() {
		List<Fruit> itemList = this.itemDao.findAll();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("itemList", itemList);
		ModelAndView mav = new ModelAndView("index");
		mav.addAllObjects(map);
		return mav;
	}
}





















