package JavaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class StudentManagement {
ArrayList<Student> studentList;
	public StudentManagement() {
		this.studentList = new ArrayList<>();
	}
	
	public void add(Student student) {
		if(findID(student.getStudentID())!=-1) {System.out.println("SameID");}
		else {
			studentList.add(student);
		}
	}
	
	public Student delete(int index) {
		return studentList.remove(index);
	}
	
	public int findID(String studentID) {
		for(int i=0;i< studentList.size();i++) {
			if(studentList.get(i).getStudentID().equals(studentID)) {
				return i;
			}
		}
		return -1;
	}
	
	public Queue<Student> findName(String name) {
		Queue<Student> result=new LinkedList<>(); 
		for(Student student:studentList) {
			if(student.getName().equals(name)) {
				result.add(student);
			}
		}
		return result;
	}
	
	public void load(String path) throws IOException, ClassNotFoundException {
		File file =new File(path);
		FileInputStream fis =new FileInputStream(file);
		ObjectInputStream ois =new ObjectInputStream(fis);
		while (fis.available()!=0) {
			studentList.add((Student)ois.readObject());
		}
		fis.close();
		ois.close();
	}
	
	public void save(String path) throws IOException {
		File file =new File(path);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos =new ObjectOutputStream(fos);
		for(Student student:studentList) {
			oos.writeObject(student);
		}
		oos.close();
		fos.close();
	}
	public static void main(String[] args) {
		StudentManagement s =new StudentManagement();
//		for(int i=0;i<10;i++) {
//			s.add(new Student());
//		}
		try {
//			s.save("C:\\Users\\MioRiy\\Desktop\\Java\\save.txt");
			s.load("C:\\Users\\MioRiy\\Desktop\\Java\\save.txt");
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
