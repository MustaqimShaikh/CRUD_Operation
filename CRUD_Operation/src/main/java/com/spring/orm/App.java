package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
       @SuppressWarnings("resource")
	ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/entities/config.xml");
       StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//       Student student = new Student(123,"Mustaqim Ahmad","Amravati"); 
//       int r=studentDao.insert(student);
//       System.out.println("Done :"+r);
       
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       boolean go=true;
       System.out.println("");
       System.out.println("****************WELCOME_TO_MY_APP***************");
       System.out.println("");
       while(go){

    	   System.out.println("********************************************");
    	   System.out.println("PESS 1 : for add a new student");
    	   System.out.println("PESS 2 : for all students details");
    	   System.out.println("PESS 3 : for display a single student details");
    	   System.out.println("PESS 4 : for delete student details");
    	   System.out.println("PESS 5 : for update a student details");
    	   System.out.println("PESS 6 : for exit from application");
            
       try {
    	   int input = Integer.parseInt(br.readLine());
    	    
    	   switch(input){
    	   
    	   case 1:
    		   //adding a new student
    		   //taking input from user...
    		   System.out.print("Enter studentId : ");
    		   int uId = Integer.parseInt(br.readLine());
    		   
    		   System.out.print("Enter studentName : ");
    		   String uName = br.readLine();
    		   
    		   System.out.print("Enter studentCity : ");
    		   String uCity = br.readLine();
    		   
    		   //creating object of Student class and setting value by student dao..
    		   Student s =new Student();
    		   s.setStudentId(uId);
    		   s.setStudentName(uName);
    		   s.setStudentCity(uCity);
    		   int r = studentDao.insert(s);
    		   System.out.println("___________________________________________");
    		   System.out.println("Student whos id = "+r+" added Successfully..!");
    		   System.out.println("********************************************");
    		   break;
    		 
    	   case 2:
    		   //display all students details..
    		   System.out.println("*********************************************");
    		   List<Student> allStudents = studentDao.getAllStudents();
    		   for(Student st:allStudents){
    			   System.out.println("___________________________________________");
    			   System.out.println("Id : "+st.getStudentId());
    			   System.out.println("Name : "+st.getStudentName());
    			   System.out.println("City : "+st.getStudentCity());
    			   System.out.println("___________________________________________");
    		   }
    		   System.out.println("*********************************************");
    		   break;
    	   case 3:
    		   //display a single student details..
    		   System.out.println("Enter the StudentId :");
    		   int userId = Integer.parseInt(br.readLine());
    		   Student student = studentDao.getStudent(userId);
    		   System.out.println("___________________________________________");
    		   System.out.println("Id : "+student.getStudentId());
			   System.out.println("Name : "+student.getStudentName());
			   System.out.println("City : "+student.getStudentCity());
			   System.out.println("___________________________________________");
    		   break;
    	   case 4:
    		   //delete student details..
    		   System.out.println("Enter the StudentId :");
    		   int dId = Integer.parseInt(br.readLine());
    		   studentDao.deleteStudent(dId);
    		   System.out.println("___________________________________________");
    		   System.out.println("Student details deleted successfully..!");
    		   break;
    	   case 5:
    		   //update student details..
    		   System.out.println("Enter the StudentId :");
    		   int updateId = Integer.parseInt(br.readLine());
    		   Student oldstudent = studentDao.getStudent(updateId);
    		   System.out.println("-----------------OLD DATE------------------");
    		   System.out.println("Id : "+oldstudent.getStudentId());
			   System.out.println("Name : "+oldstudent.getStudentName());
			   System.out.println("City : "+oldstudent.getStudentCity());
			   System.out.println("-----------------Options-------------------");
			   System.out.println("To Update Data : PRESS Y");
			   System.out.println("To NOT Update Data : PRESS N");
			   String old = br.readLine();
			   String nw1 = "Y";
			   String nw2 = "N";
			   // while(update){
			   if(old.equals(nw1)){
				   System.out.println("-----------------FOR NEW DATA---------------");
				   
				   System.out.print("Enter old studentId  : ");
	    		   int nId = Integer.parseInt(br.readLine());
	    		   
	    		   System.out.print("Enter studentName : ");
	    		   String nName = br.readLine();
	    		   
	    		   System.out.print("Enter studentCity : ");
	    		   String nCity = br.readLine();
	    		   
	    		   Student ns =new Student();
	    		   ns.setStudentId(nId);
	    		   ns.setStudentName(nName);
	    		   ns.setStudentCity(nCity);
	    		   studentDao.updateStudent(ns);
	    		   System.out.println("___________________________________________");
	    		   System.out.println("Student updated Successfully..!");
	    		   System.out.println("********************************************");  
				   
			   }
			    else if (old.equals(nw2)) {
			    	System.out.println("___________________________________________");
			    	System.out.println("OKK.. we taking you to main menu..!");
					
				//} 
			   System.out.println("___________________________________________");
//			  update=false;
			  break;

			   }
    	   case 6:
    		   //exit from the application..
    		   go=false;
    		   break;		  
    		   
    	   }	   
		
	} catch (Exception e) {
		
		System.out.println("Invalid input tyr with another..!");
		System.out.println(e.getMessage());
		
	}
       }
       System.out.println("Thank you for using my application ...");
       System.out.println("See you soon.. :)");
    }
}
