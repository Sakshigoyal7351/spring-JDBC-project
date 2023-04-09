package com.day2;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ExpressionInvocationTargetException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.day2.model.Student;
import com.day2.studentDao.studentDao;
import com.day2.studentDao.studentDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My project is Started" );
        ApplicationContext context = 
        		new ClassPathXmlApplicationContext("config.xml");
        studentDao studentDao = context.getBean("studentDao",studentDaoImpl.class);
        
        
        Scanner sc= new Scanner(System.in);
        Boolean go=true;
        
        while(go)
        {
        System.out.println("press 1 to insert new student");
        System.out.println("press 2  to update student data");
        System.out.println("press 3 to delete student data");
        System.out.println("press 4 to display single student data");
        System.out.println("press 5 to display all students data");
        System.out.println("press 6 to  exit");
        
        int input=sc.nextInt();
        
        switch (input) {
        
        case 1:
        	
        	 System.out.println("enter the id");
             int id=sc.nextInt();
             System.out.println("enter the name");
             String name=sc.next();
             System.out.println("enter the city");
             String city=sc.next();
             
             Student student = new Student();
             student.setId(id);
             student.setName(name);
             student.setCity(city);
             
             int r = studentDao.insert(student);
             System.out.println("Data inserted successfully");
             System.out.println(r);
             
             break;
        case 2:
        	System.out.println("enter the id of student whose data you want to update");
        	int id2=sc.nextInt();
        	 System.out.println("enter the name");
             String name2=sc.next();
             System.out.println("enter the city");
             String city2=sc.next();
        	
             
             Student student1 = new Student();
             student1.setId(id2);
             student1.setName(name2);
             student1.setCity(city2);
             
             int result = studentDao.change(student1);
             System.out.println("Student data got updated!!"+result);
        	break;
        	
        case 3:
        	System.out.println("enter the id of student whose data you want to delete");
        	int id3=sc.nextInt();
        	int r1 = studentDao.delete(id3);
        	System.out.println("data deleted successfully!!!!!"+r1);
        	break;
        
        case 4:
        	
        	System.out.println("enter the student id whose data you want to get!!!");
        	int id4= sc.nextInt();
        	
        	Student s1 = studentDao.getStudent(id4);
        	System.out.println(s1);
        	break;
        	
        case 5:
        	
        	List<Student> students = studentDao.getAllStudents();
        	for(Student s : students)
        	{
        		System.out.println(s);
        	}
        	break;
        	
        case 6:
        	go=false;
        	break;
        default:
        	System.out.println("you enter the wrong choice try agian!!!!!!!");
        	
        }
        
       
        System.out.println("thankyou for using my application!!!!");
        
        
      
        
        
    }
}
}
