class Student{
	private String name;
	private int exam1;
	private int exam2;
	private int exam3;
	
	boolean validateMarks(int marks){
		if (marks>=0 && marks<=100){
			return true;
		}else{
			return false;
		}
	}
	Student(String name, int exam1, int exam2, int exam3) throws Exception{
		this.name = name;
		this.exam1 = exam1;
		this.exam2 = exam2;
		this.exam3 = exam3;
		
		if (validateMarks(exam1) && validateMarks(exam2) && validateMarks(exam3)){
			exam1 = exam1;
			exam2 = exam2;
			exam3 = exam3;
		}else{			
			throw new Exception ("Exam scores must be between 0 and 100.");
		}
	}
	
	String getName(){
		return name;
	}
	int getExam1(){
		return exam1;
	}
	int getExam2(){
		return exam2;
	}
	int getExam3(){
		return exam3;
	}
	
	double calculateAverage(){
		double average=exam1+exam2+exam3/3;
		return average;
	}
}

public class StudentDemo{
	public static void main(String[] args){
		try{
			
			Student s1=new Student("Mark",55,100,80);
			System.out.println("Name: "+s1.getName()+" \nExam1: "+s1.getExam1()+" \nExam2: "+s1.getExam2()+" \nExam3: "+s1.getExam3()+" \nAverage: "+s1.calculateAverage());
			
			Student s2=new Student("John",75,110,90);
			System.out.println("Name: "+s2.getName()+" \nExam1: "+s2.getExam1()+" \nExam2: "+s2.getExam2()+" \nExam3: "+s2.getExam3()+" \nAverage: "+s2.calculateAverage());
			
		}catch(Exception e){
			System.out.println("Exception is : "+e.getMessage());
		}
	}
}