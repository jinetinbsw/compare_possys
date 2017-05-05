package kr.or.possys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.possys.Member_sevice.Member;
import kr.or.possys.Member_sevice.Member_Dao;
import kr.or.possys.Member_sevice.mVo;

@Controller
public class Member_Controller {

	@Autowired
	private	Member_Dao	Mdao;
	// �˻�ó�� �޼���
			@RequestMapping(value="/member_select",method = RequestMethod.GET)
			public String memberselect(HttpServletRequest request
					,Model model
					,@RequestParam(value="ScurrentPage",required=false,defaultValue="1" )int ScurrentPage){
				/*@RequestParam(value="selBox")String selBox*/
				//jsp���� �˻��� �ʿ��� ���� �޾ƿ´�.
				System.out.println("memberselect�޼��� ȣ��    Member_Controller.java");
				
				
				String search =	request.getParameter("search");
				String selBox = request.getParameter("selBox");
				
				mVo m = new mVo();
				m.setSearch(search);
				m.setSelBox(selBox);
			    request.getSession().setAttribute("m", m);
				
				/*System.out.println("["+selBox+"]<---�˻� ���� memberselect �޼��� Member_Controller.java");
				System.out.println(search+"<---�˻��� memberselect �޼��� Member_Controller.java");
				*/
			    int SpagePerRow = 5;
				//�޼��� ȣ�� �迭�� �˻� �� ���ǿ� �´� ���� ��ƿ´�
				List<Member> Mlist = Mdao.searchMember(selBox, search,ScurrentPage,SpagePerRow);
				System.out.println(Mlist+"<--------- searchMember ���ϰ�Ȯ��");
				
				
				//�˻��� ������ �� ������ �ľ��ϴ� �޼��带 ȣ�� �� ������ ����ش�.
				int SmemberCount = Mdao.getsearchCount(selBox, search);
				
				//�޼��忡�� �޾ƿ� �� �����ϴ� �κ�	
				
				int Slastpage = (int)(Math.ceil((double)SmemberCount/(double)SpagePerRow));
				int Sexpage = 1;
				if(ScurrentPage == 0){
					ScurrentPage++;
				}else if(ScurrentPage >Slastpage){
					ScurrentPage = Slastpage;
				}
				
				model.addAttribute("ScurrentPage", ScurrentPage);
				model.addAttribute("SmemberCount",SmemberCount);
				model.addAttribute("SpagePerRow",SpagePerRow);
				model.addAttribute("Slastpage",Slastpage);
				model.addAttribute("Mlist",Mlist);
				model.addAttribute("Sexpage",Sexpage);
			
				
				
				
				
				return "/member/member_select";
			}
	//����Ʈ
	@RequestMapping(value="/member_list", method = RequestMethod.GET)
	public String MemberList(Model model,@RequestParam(value="currentPage",required=false,defaultValue="1" )int currentPage){
		System.out.println("MemberList �޼��� ���� Ȯ��  Member_Controller.java ");
		int memberCount = Mdao.getMemberCount();
		System.out.println(memberCount+"<-----memberCount �� Ȯ��");
		int pagePerRow = 10;
		int lastpage = (int)(Math.ceil((double)memberCount/(double)pagePerRow));
		int expage = 1;
		if(currentPage == 0){
			currentPage++;
		}else if(currentPage >lastpage){
			currentPage = lastpage;
		}
		
		List<Member> list = Mdao.getMemberList(currentPage, pagePerRow);
		System.out.println(lastpage+"lastpage ���ϰ� Ȯ��");
		System.out.println(currentPage+"currentPage ���ϰ� Ȯ��");
		
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("memberCount",memberCount);
		model.addAttribute("pagePerRow",pagePerRow);
		model.addAttribute("lastpage",lastpage);
		model.addAttribute("list",list);
		model.addAttribute("expage",expage);
	
		
		return "/member/member_list";
		
	}
	
	//ȸ�� ���� ���� ���� ȭ��
	@RequestMapping(value="/member_information_view" ,method = RequestMethod.GET)
	public String memberView(Model model,@RequestParam(value="member_phone",required=false,defaultValue="1")int member_phone){
		System.out.println("memberView �޼��� ���� Ȯ��  Member_Controller.java ");
		Member m = Mdao.getMember(member_phone);
		model.addAttribute("Member",m);
		return "/member/member_information_view";
		
	}
	
	//����ó�� ȭ�� ��� �޼��� 
	@RequestMapping(value ="/member_update", method = RequestMethod.GET)
		public String update(Model model,@RequestParam(value="member_phone")int member_phone){
			System.out.println("update �޼��� ȣ��    Member_Controller.java");
			Member m = Mdao.getMember(member_phone);
			model.addAttribute("Member",m);
			
		return "/member/member_Update";
		}
	//����ó�� �޼���
	@RequestMapping(value ="/member_update", method = RequestMethod.POST)
	public String update_Action(Member m){
		System.out.println("update_Action�޼��� ȣ��    Member_Controller.java");
		System.out.println(m.getMember_phone()+"<=-----------");
		Mdao.Mupdate(m);
	return "redirect:member_information_view?member_phone="+m.getMember_phone();
	}
	//����ȭ�� ��� �޼���
	@RequestMapping(value="/member_Secede",method = RequestMethod.GET)
	public String memberDeletePage(Model model , @RequestParam(value="member_phone")int member_phone){
		Member m = Mdao.getMember(member_phone);
		model.addAttribute("Member",m);
		
		System.out.println("memberDeletePage �޼��� ȣ��    Member_Controller.java");
		return "/member/member_Secede";
	}
	// ����ó�� �޼���
		@RequestMapping(value="/member_SecedeAction",method = RequestMethod.POST)
		public String memberDelete(@RequestParam(value="member_phone")int member_phone){
			System.out.println("memberDelete�޼��� ȣ��    Member_Controller.java");
			Mdao.deleteMember(member_phone);
			return "redirect:member_list";
		}
		
	

}
