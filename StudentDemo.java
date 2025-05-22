class Student{
	private String name;
	private int exam1;
	private int exam2;
	private int exam3;
	
	boolean validateMarks(int marks){
		if (marks<=100 && marks>=0){
			return true;
		}else{
			return false;
		}
	}
	
	Student(String na, int e1,int e2,int e3)throws Exception{
		name=na;
		exam1=e1;
		exam2=e2;
		exam3=e3;

		if (validateMarks(e1)&&validateMarks(e2)&&validateMarks(e3)){
			exam1=e1;
			exam2=e2;
			exam3=e3;
		}else {
			System.out.println("Setting the marks value to 0");
			throw new Exception("Invalid marks");
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
}

class StudentDemo{
	public static void main(String[] args){
		
		
		try{
		
		Student student2= new Student("John",75,100,90);
		System.out.println("Name of the student 2 is : "+student2.getName());
		System.out.println("Name of the student 2 for exam1 is : "+student2.getExam1());
		
		Student student1= new Student("Adam",75,110,-90);		
		System.out.println("Name of the student 1 is : "+student1.getName());
		System.out.println("Name of the student 1 for exam1 is : "+student1.getExam1());
		System.out.println("Name of the student 1 for exam2 is : "+student1.getExam2());
		
		}catch(Exception e){
			System.out.println("Exception is: "+e.getMessage());
		}
		
	}
}