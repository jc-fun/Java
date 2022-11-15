package com.urain4.exercise;

public class Student {
	private int FlowID;
	private int Type;
	private String IDCard;
	private String ExamCard;
	private String StudentName;
	private String Location;
	private int Grade;
	public Student() {
		super();
	}
	public Student(int flowID, int type, String iDCard, String examCard, String studentName, String location,
			int grade) {
		super();
		FlowID = flowID;
		Type = type;
		IDCard = iDCard;
		ExamCard = examCard;
		StudentName = studentName;
		Location = location;
		Grade = grade;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public String getExamCard() {
		return ExamCard;
	}
	public void setExamCard(String examCard) {
		ExamCard = examCard;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public int getGrade() {
		return Grade;
	}
	public void setGrade(int grade) {
		Grade = grade;
	}
	public int getFlowID() {
		return FlowID;
	}
	@Override
	public String toString() {
		System.out.println("=========查询结果=========");
		return info();
	}
	
	private String info() {
		return "流水号：" + FlowID + "\n四级/六级：" + Type + "\n身份证号：" + IDCard + "\n准考证号：" + ExamCard + 
				"\n学生姓名：" + StudentName + "\n区域：" + Location + "\n成绩：" + Grade;
	}
	
	
	
}
