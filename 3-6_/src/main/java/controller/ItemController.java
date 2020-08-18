package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Fruit;

@Controller
public class ItemController {
	@Autowired
	private ItemDao itemDao;
	@RequestMapping(value="/item/search.html")
	public ModelAndView search(String item_name) throws Exception {
		if(item_name==null || item_name.equals("")) {
			//상품이름이 입력되지 않았다?
			return this.index();
		}
		List<Fruit> itemList=itemDao.findByName(item_name);//DB검색
		if(itemList==null || itemList.isEmpty()) {
			//검색 결과 없다?
			return this.index();
		}
		ModelAndView mav=new ModelAndView("index");
		mav.addObject("itemList",itemList);//검색결과 저장해서 보내야지 index의 c:forEach에서 받는다 ${itemList}
		return mav;
	}
	@RequestMapping(value="/item/update.html") 
	public ModelAndView update(@Valid Fruit fruit,BindingResult bindingResult,
			HttpServletRequest request) throws Exception{ 
		if(bindingResult.hasErrors()) {
			ModelAndView mav=new ModelAndView("update");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		MultipartFile multiFile=fruit.getPicture();
		String fileName=null; String path=null;
		OutputStream out=null;
		if(! fruit.getPicture().getOriginalFilename().equals("")) {
			//이미지 파일이 선택된 경우, 즉 이미지 변경인 경우
			fileName=multiFile.getOriginalFilename();
			path=request.getSession().getServletContext().getRealPath("/upload/"+fileName);
			File file=new File(path);
			out=new FileOutputStream(path);
			BufferedInputStream bis=new BufferedInputStream(multiFile.getInputStream());
			byte[] buffer =new byte[8106];
			int read=0;
			while((read=bis.read(buffer))>0){
				out.write(buffer,0,read);
			}
			if(bis != null) bis.close();
			if(out != null) out.close();
			fruit.setPicture_url(fileName);
		}
		this.itemDao.update(fruit);
		return index(); //변경 후 목록으로 전환
	}
	@RequestMapping(value="/item/edit.html") 
	//왜 보낼 땐 edit.html인데 여기선 /item/이 붙는가? 이미 url에 저장된 정보이기 때문이다.
	//하지만 저장되어 있다고 콘트롤러가 받을 때 없으면 안된다. url은 엄연히 item/edit.html로 보내는 것이기 때문이다.
	public ModelAndView update(Integer itemId) {
		Fruit item=this.itemDao.findById(itemId);//편집할 과일
		ModelAndView mav=new ModelAndView("update"); //update jsp로 보낼거야.
		mav.addObject(item); // 근데 여기서 검색한 객체가 함께 가는거야
		return mav;
	}
	
	@RequestMapping(value="/item/delete.html") //맵핑이름이 이거고
	public ModelAndView delete(Integer item_id) { // 콜백으로 return view //매개인자 잘 알아봐야대
		ModelAndView mav=new ModelAndView("delete"); //viewResolver로 앞에 알아서 WEB-INF/jsp가 붙는다
		this.itemDao.delete(item_id);	
		return this.index(); //다시 목록으로
	}
	@RequestMapping(value="/item/confirm.html") //맵핑이름이 이거고
	public ModelAndView confirm(Integer itemId) { // 콜백으로 return view
		ModelAndView mav=new ModelAndView("delete"); //viewResolver로 앞에 알아서 WEB-INF/jsp가 붙는다
		Fruit item=this.itemDao.findById(itemId); // 번호로 과일 검색
		mav.addObject(item); //조회결과를 저장
		System.out.println("그림"+item.getPicture_url());
		mav.addObject("imageName",item.getPicture_url()); //파일이름 저장
		return mav;
	}
	@RequestMapping(value="/item/register.html") //맵핑이름이 이거고
	public ModelAndView register(@Valid Fruit fruit, BindingResult bindingResult, 
			HttpServletRequest request) throws Exception { // 콜백으로 return view
		//Valid라는 어노테이션을 통해서 유효성 검사가 진행된다. BindingResult는 반드시 두 번째 매개변수로 와야한다. 순서 잊지말 것
		if(bindingResult.hasErrors()) {
			//유효성검사 결과
			ModelAndView mav=new ModelAndView("add");//폼에 에러가 있으면 계속 add.jsp만 반환한다
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		MultipartFile multiFile=fruit.getPicture();
		String fileName=null; String path=null;
		OutputStream out=null; //쓰는 객체
		if(multiFile !=null) { //이미지 파일이 존재하는 경우
			fileName=multiFile.getOriginalFilename();
			path=request.getSession().getServletContext().getRealPath("/upload/"+fileName); //절대경로 획득
			File file=new File(path);//절대경로를 이용하여 파일 생성
			out=new FileOutputStream(path);//파일 출력 객체 생성'
			BufferedInputStream bis=new BufferedInputStream(multiFile.getInputStream());//파일 입력객체
			byte[] buffer=new byte[8196]; //8k크기의 공간
			int read=0;
			while((read=bis.read(buffer))> 0) { //파일을 읽음
				out.write(buffer,0,read); // 읽은 내용을 출력될 파일로 출력
			}
			if(out != null) out.close(); //출력에 사용한 객체를 닫음
			if(bis != null) bis.close(); //입력에 사용한 객체를 닫음
		}
		fruit.setPicture_url(fileName); //이미지 파일명을 설정
		this.itemDao.create(fruit);//DB삽입
		ModelAndView mav=new ModelAndView("redirect:/item/index.html"); //이게 없으면 새로고침 누를 시 중복등록이 발생
		return mav; // 삽입 후 다시 목록을 띄운다
	}
	@RequestMapping(value="/item/index.html") //맵핑이름이 이거고
	public ModelAndView index() { // 콜백으로 return view
		List<Fruit> itemList=this.itemDao.finaAll();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("itemList", itemList);
		ModelAndView mav=new ModelAndView("index"); //viewResolver로 앞에 알아서 WEB-INF/jsp가 붙는다
		mav.addAllObjects(map);
		return mav;
	}
	@RequestMapping(value="/item/create.html") //맵핑이름이 이거고
	public ModelAndView create() { // 콜백으로 return view
		ModelAndView mav=new ModelAndView("add");
		mav.addObject(new Fruit());
		return mav;
	}
}

