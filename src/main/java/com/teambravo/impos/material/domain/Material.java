package com.teambravo.impos.material.domain;

public class Material {
	
	private String materialName;
	private double materialVolume;
	
	
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public double getMaterialVolume() {
		return materialVolume;
	}
	public void setMaterialVolume(double materialVolume) {
		this.materialVolume = materialVolume;
	}
	@Override
	public String toString() {
		return materialName + "," + materialVolume;
	}
	

}
