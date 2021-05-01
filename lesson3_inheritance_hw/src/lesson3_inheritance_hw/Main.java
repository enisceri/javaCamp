package lesson3_inheritance_hw;

public class Main {

	public static void main(String[] args) {

		Student student = new Student(1, "Enis", "Çeri", "ogrenci@gmail.com"); 
		Instructor instructor = new Instructor(1,"Engin", "Demiroğ","engindemirog@gmail.com");
		
		UserManager userManager = new UserManager();
		userManager.createUser(instructor);
		userManager.createUser(student);

		
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.publishVideo();
		
		StudentManager studentManager = new StudentManager();
		studentManager.registerToCourse("Java");
		
	}

}
