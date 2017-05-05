package kr.or.possys.food_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Food_Dao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//food �Է¿�û
	public int insertfood(Food food){
		System.out.println("01_Food_dao.java->>insertfood ���� ");	
		return sqlSessionTemplate.insert("kr.or.possys.food_service.Food_Mapper.insertfood",food);
	}
	//food ��� ���� ī��Ʈ
	public int getfoodcount(){
		System.out.println("02_Food_dao.java->>getfoodcount ���� ");
		return sqlSessionTemplate.selectOne("kr.or.possys.food_service.Food_Mapper.getfoodcount");
	}
	//food ��Ͽ�û
	public List<Food> foodlist(int currentPage, int pageRow){
		System.out.println("03_Food_dao.java->>foodlist ����");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", (currentPage-1)*pageRow);
		map.put("pageRow", pageRow);
		return sqlSessionTemplate.selectList("kr.or.possys.food_service.Food_Mapper.foodlist",map);
	}
	//food ������ ��û
	public Food foodview(String food_id){
		System.out.println("04_Food_dao.java->>foodview ����");
		return sqlSessionTemplate.selectOne("kr.or.possys.food_service.Food_Mapper.foodview",food_id);
	}
	//food �����׼� ��û
	public int foodmodify(Food food){
		System.out.println("05_Food_dao.java->>foodmodify ����");
		return sqlSessionTemplate.update("kr.or.possys.food_service.Food_Mapper.foodmodify",food);
		
	}
	//food ���� ��û
	public int fooddelete(String food_id){
		System.out.println("06_Food_dao.java->>fooddelete ����");
		return sqlSessionTemplate.delete("kr.or.possys.food_service.Food_Mapper.fooddelete",food_id);
	}
	//food �˻� ��û
	public List<Food> foodsearch(String selbox, String keyWord, int currentPage, int pageRow){
		System.out.println("07_Food_dao.java->>foodsearch ����");
		System.out.println(selbox);
		System.out.println(keyWord);
		System.out.println(currentPage);
		System.out.println(pageRow);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("selbox", selbox);
		map.put("keyWord", keyWord);
		map.put("beginRow", (currentPage-1)*pageRow);
		map.put("pageRow", pageRow);
		System.out.println(map.get("selbox"));
		System.out.println(map.get("keyWord"));
		System.out.println(map.get("beginRow"));
		System.out.println(map.get("pageRow"));
		
			
		return sqlSessionTemplate.selectList("kr.or.possys.food_service.Food_Mapper.foodsearch", map);
	}
	//food �˻� �� ��û
	public int foodSRlist(String selbox,String keyWord){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("selbox", selbox);
		map.put("keyWord", keyWord);
		System.out.println(map.get("selbox"));
		System.out.println(map.get("keyWord"));
		return sqlSessionTemplate.selectOne("kr.or.possys.food_service.Food_Mapper.foodSRlist",map);
		
	}
}
