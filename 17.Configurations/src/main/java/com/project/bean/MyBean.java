package com.project.bean;

public class MyBean {
	private long beanId;
	private String beanName;
	private int beanCount;

	public MyBean() {
	}

	public MyBean(long beanId, String beanName, int beanCount) {
		this.beanId = beanId;
		this.beanName = beanName;
		this.beanCount = beanCount;
	}

	public void initMetod() {
		System.out.println("Başlatıldı");
	}
	public void destroyMetod() {
		System.out.println("Sonlandırıldı");
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

	public int getBeanCount() {
		return beanCount;
	}

	public void setBeanCount(int beanCount) {
		this.beanCount = beanCount;
	}

	@Override
	public String toString() {
		return "MyBean [beanId=" + beanId + ", beanName=" + beanName + ", beanCount=" + beanCount + "]";
	}
}
