package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.service.ProductService;
import com.mvc.service.ProductServiceImpl;
import com.mvc.vo.Member;
import com.mvc.vo.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {
	// 1. 서비스에 정보 넘기니까 service가 있어야 함
	@Autowired
	ProductService service; // 인터페이스 타입을 가짐

	@GetMapping("/list")
	public String list(HttpSession session, Model model) {
		String admin = (String) session.getAttribute("admin");
		
		ArrayList<Product> list;
		
		if(admin.equals("yes")) {
			list = service.selectAll();
		} else {
			Member user = (Member) session.getAttribute("user");
			list = service.selectByName(user.getId());
		}
		
		
		model.addAttribute("list", list);

		return "list";
	}

	@GetMapping("/read")
	//public String read(HttpServletRequest request, Model model) {
	public String read(@RequestParam("num") String num, Model model) throws Exception {
//		if(num.equals("17")) {
//			throw new Exception();
//		}
		
		Product b = service.selectOne(num);

		model.addAttribute("b", b);
		return "read";

	}

	//화면만 출력하는 메서드
	@GetMapping("/regist")
	public String insertForm() {
		return "regist";
	}

	@PostMapping("/registProcess")
	public String insertProcess(@ModelAttribute Product b) {		
		int x = service.insert(b);
		
		return "redirect:/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("num") String num) {
		service.delete(num);
		
		return "redirect:/list";
	}

	@PostMapping("/search")
	public String search(HttpServletRequest request, HttpServletResponse response, Model model) {
		String search = request.getParameter("search");
		String word = "%"+request.getParameter("word")+"%";
		
		ArrayList<Product> list = service.search(search,word);
		
		model.addAttribute("list", list);
		
		return "list";
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "exception 발생~ ㅜㅜ");
		mv.setViewName("error/error");
		return mv;
	}
	
	@GetMapping("/")
	public String index(Model model) { // 메모리에 model 이라는 이름의 Model 타입이 있다면 자동으로 넣어주지만 없을 시 하나 새로 만들어서 넣어준다.
		return "index";// 기본 forward 방식
	}
}
