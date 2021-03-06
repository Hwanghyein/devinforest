package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Admin;

@Mapper
public interface AdminMapper {
	// 관리자 목록 출력
	public List<Admin> selectAdminList(Map<String, Object> map);
	// 관리자 추가
	public void insertAdmin(Admin admin);
	// 관리자 totalCount
	public int adminTotalCount(String searchWord);
	// 관리자 이메일 중복체크
	public int selectAdminEmail(String adminEmail);
	// 관리자 닉네임 중복체크
	public int selectAdminName(String adminName);
}
