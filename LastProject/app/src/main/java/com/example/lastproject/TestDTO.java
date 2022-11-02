package com.example.lastproject;

public class TestDTO {
	private String id, name, phone, addr;

	
	public TestDTO(String id, String name, String phone, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
