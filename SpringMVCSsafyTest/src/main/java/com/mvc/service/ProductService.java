package com.mvc.service;

import java.util.ArrayList;

import com.mvc.vo.Product;

//Controller를 위한 인터페이스
public interface ProductService {
	public ArrayList<Product> selectAll();//모든 글정보
	public Product selectOne(String num);//해당 번호의 글 하나
	public int insert(Product b);//새글 등록
	public void delete(String num);//글 삭제
	public ArrayList<Product> search(String type, String word);
	public void txtest();
	ArrayList<Product> selectByName(String memberName);
}
