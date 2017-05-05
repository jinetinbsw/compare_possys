package kr.or.possys.Staff_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.possys.Staff_service.Staff;

@Repository
public class Staff_Dao {
	// Staff테이블에 맞게 DAO 수정하기.
	@Autowired
private SqlSessionTemplate sqlSessionTemplate;
	
	public int updateStaff(Staff Staff) {
        return sqlSessionTemplate.update("kr.or.possys.Staff_service.Staff_Mapper.updateStaff", Staff);
    }
    
    public int deleteStaff(String staff_id, String staff_pw) {
        Staff Staff = new Staff();
        Staff.setStaff_id(staff_id);
        Staff.setStaff_pw(staff_pw);
        return sqlSessionTemplate.delete("kr.or.possys.Staff_service.Staff_Mapper.deleteStaff", Staff);
    }
    
    public Staff getStaff(String staff_id) {
        return sqlSessionTemplate.selectOne("kr.or.possys.Staff_service.Staff_Mapper.getStaff", staff_id);
    }
 
    public List<Staff> getStaffList(int currentPage, int pagePerRow) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("beginRow", (currentPage-1)*pagePerRow);
        map.put("pagePerRow", pagePerRow);
        return sqlSessionTemplate.selectList("kr.or.possys.Staff_service.Staff_Mapper.getStaffList", map);
    }
    
    public int getStaffCount() {
        return sqlSessionTemplate.selectOne("kr.or.possys.Staff.service.StaffMapper.getStaffCount");
    }
 
    public int insertStaff(Staff Staff) {
        return sqlSessionTemplate.insert("kr.or.possys.Staff_service.Staff_Mapper.insertStaff", Staff);
    }
}
