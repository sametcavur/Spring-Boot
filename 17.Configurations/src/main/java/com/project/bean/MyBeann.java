package com.project.bean;

public class MyBeann {
	private long beanId;
	private String beanName;
	private MyBean myBean;
	
	public MyBeann() {
		// TODO Auto-generated constructor stub
	}

	public MyBeann(long beanId, String beanName, MyBean myBean) {
		super();
		this.beanId = beanId;
		this.beanName = beanName;
		this.myBean = myBean;
	}

	public long getBeanId() {
		return beanId;
	}

	public void setBeanId(long beanId) {
		this.beanId = beanId;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public MyBean getMyBean() {
		return myBean;
	}

	public void setMyBean(MyBean myBean) {
		this.myBean = myBean;
	}

	@Override
	public String toString() {
		return "MyBeann [beanId=" + beanId + ", beanName=" + beanName + ", myBean=" + myBean + "]";
	}
	
}
