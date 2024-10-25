package com.mvc.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.vo.Product;

//Controller를 위한 인터페이스
@Mapper
public interface ProductMapper {
	public ArrayList<Product> selectAll();//모든 글정보
	public Product selectOne(String num);//해당 번호의 글 하나
	public int insert(Product b);//새글 등록
	public void delete(String num);//글 삭제
	public void countUp(String num);
	public ArrayList<Product> search(HashMap<String, String> map);
	public void txtest();
	public ArrayList<Product> selectByName(String memberName);
}
