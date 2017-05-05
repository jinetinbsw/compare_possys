package kr.or.possys.Member_sevice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Member_Dao {

	@Autowired
	private SqlSessionTemplate Msql;
	
	//ȸ�� ���� ī��Ʈ �޼���
	public int getMemberCount(){
		System.out.println("getMemberCount �޼��� ����   Member_Dao.java ");
		
		return Msql.selectOne("kr.or.possys.Member_sevice.Member_Mapper.getMemberCount");
		}
	//��üȸ�� ��ȸ �޼���
	public List<Member> getMemberList(int currentPage, int pagePerRow){
		System.out.println("getMemberList �޼��� ����   Member_Dao.java ");
		Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("beginRow", (currentPage-1)*pagePerRow);
        map.put("pagePerRow", pagePerRow);
		return Msql.selectList("kr.or.possys.Member_sevice.Member_Mapper.getMemberList", map);
		
	}
	//�Ѹ� ȸ������ ��ȸ �޼���
	public Member getMember(int phone){
		System.out.println("getMember �޼��� ����   Member_Dao.java ");
		return Msql.selectOne("kr.or.possys.Member_sevice.Member_Mapper.MselectOne", phone);
	}
	//����ó�� �޼���
	public int Mupdate(Member m){
		System.out.println("Mupdate �޼��� ���� Member_Dao.java");
		return Msql.update("kr.or.possys.Member_sevice.Member_Mapper.Mupdate",m);
	}
	//����ó�� �޼���
	public int deleteMember(int member_phone){
		System.out.println("deleteMember �޼��� ���� Member_Dao.java");
		
		return Msql.delete("kr.or.possys.Member_sevice.Member_Mapper.deleteMember", member_phone);
		
	}
	//�˻�ó�� �޼���(�˻��� ����� �迭�� ����Ʈó�� ������)
	public List<Member> searchMember(String selBox,String search,int currentPage,int pagePerRow){
		System.out.println("selectMember �޼��� ���� Member_Dao.java");
		mVo m = new mVo();
		m.setSelBox(selBox);
		m.setSearch(search);
		m.setBeginRow((currentPage-1)*pagePerRow);
		m.setPagePerRow(pagePerRow);
		System.out.println(m.getSelBox()+"<----------------�����Ѱ�");
		System.out.println(m.getSearch()+"<----------------�����Ѱ�");
		return Msql.selectList("kr.or.possys.Member_sevice.Member_Mapper.Msearch",m);
	}
	//�˻� ���ǿ� �´� ȸ���� ��ȸ �޼���
		public int getsearchCount(String selBox,String search){
			System.out.println("getsearchCount �޼��� ����   Member_Dao.java ");
			mVo m = new mVo();
			m.setSelBox(selBox);
			m.setSearch(search);
			
			return Msql.selectOne("kr.or.possys.Member_sevice.Member_Mapper.getsearchCount",m);
			}

}
