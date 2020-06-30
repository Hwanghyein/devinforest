package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devinforest.mapper.AdminMapper;
import com.devinforest.vo.Admin;

@Service
public class AdminService {
	@Autowired private AdminMapper adminMapper;
	// 관리자 목록 출력
	public Map<String, Object> getAdminList(int currentPage, int rowPerPage){
		int beginRow=(currentPage-1)*rowPerPage;
		int adminTotalCount = adminMapper.adminTotalCount();
		System.out.println(adminTotalCount+" <- adminService.getAdminList: adminTotalCount");
		int lastPage = adminTotalCount/rowPerPage;
		if(adminTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		List<Admin> adminList = adminMapper.selectAdminList(beginRow, rowPerPage);
		System.out.println(adminTotalCount+" <- AdminService.getAdmin: adminTotalCount");
		System.out.println(lastPage+" <- AdminService.getAdmin: lastPage");
		System.out.println(adminList+" <- AdminService.getAdmin: adminList");
		Map<String, Object> map = new HashMap<>();
		map.put("adminTotalCount", adminTotalCount);
		map.put("lastPage", lastPage);
		map.put("adminList", adminList);
		return map;
	}
	// 관리자 추가
	public void addAdmin(Admin admin) {
		adminMapper.insertAdmin(admin);
	}
}