package com.teambravo.impos.material.service;

import java.util.List;

import com.teambravo.impos.material.dao.MaterialDao;
import com.teambravo.impos.material.domain.Material;

public class MaterialService {
	
	private MaterialDao materialDao;
	
	// 상품판매시 원재료 차감
	// 결제완료 시 재고반영시킬때 카테고리가 커피라면 이걸 호출 아니면 stock호출
	//원재료 찾기 하나 만들고그걸 가져와서 원래 원재료빼기 차감할만큼을 만들기
	public void saleSubtractVolume(String proName) {
		if (proName.equals("아메리카노")) {
			Material firstMaterial = findMaterialByName("원두");
			double finalVolume = firstMaterial.getMaterialVolume() - 10; //현재 원재료 양 - 아메리카노 제조시 사용되는 양
			editVolume("원두", finalVolume);
		} else if (proName.equals("라떼")) {
			Material firstMaterial = findMaterialByName("원두");
			double finalVolume = firstMaterial.getMaterialVolume() - 10; //현재 원재료 양 - 아메리카노 제조시 사용되는 양
			editVolume("원두", finalVolume);
			Material secondMaterial = findMaterialByName("우유");
			double finalVolume2 = secondMaterial.getMaterialVolume() - 10; //현재 원재료 양 - 아메리카노 제조시 사용되는 양
			editVolume("우유", finalVolume2);
		}
	}
	
	
	// 원재료 추가, 차감 (수정)
	// 폼으로 들어온 정보를 material객체로 받기
	public void editVolume(String materialName, double materialVolume) {
		materialDao = new MaterialDao();
		materialDao.editVolume(materialName, materialVolume);
	}
	
	// 원재료 전체 리스트
	public List<Material> findAllMaterial() {
		materialDao = new MaterialDao();
		return materialDao.findAllMaterial();
	}
	
	// 재료명으로 원재료 항목 얻기
	public Material findMaterialByName(String materialName) {
		materialDao = new MaterialDao();
		return materialDao.findMaterialByName(materialName);
	}
}
