package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MyController 
{
	List<student> stud=new ArrayList<student>();
	
	@GetMapping("/")
	public String disp(Model model)
	{
		return "homepage";
	}
	
	@GetMapping("/forms")
	public String reg(Model model)
	{
		return "Registration";
	}
	
	@GetMapping("/updatestud")
	public String updatestudent(@RequestParam(value="rollno3") int rollno,@RequestParam(value="newrollno") int nrollno ,@RequestParam(value="newname")String name,@RequestParam(value="newage")int age ,Model model)
	{
		boolean flag=false;
		for(int i=0;i<stud.size();i++)
		{
			if(stud.get(i).getRollno()==rollno)
			{
				flag=true;
				stud.get(i).setRollno(nrollno);
				stud.get(i).setName(name);
				stud.get(i).setAge(age);
				break;
			}
		}
		model.addAttribute("message", flag ? "Student Updated successfully!" : "Student not found!");
        model.addAttribute("student1",stud);
		return "ShowStudents";
	}
	
	@GetMapping("/update")
	public String upd(Model model)
	{
		return "UpdateStudent";
	}
	
	@GetMapping("/deletestudent")
	public String deletestud(@RequestParam(value="Rollno2") int rollno,Model model)
	{
		boolean flag=false;
		for(int i=0;i<stud.size();i++)
		{
			if(stud.get(i).getRollno()==rollno)
			{
				flag=true;
				stud.remove(i);
				break;
			}
		}
        model.addAttribute("message", flag ? "Student deleted successfully!" : "Student not found!");
        model.addAttribute("student1",stud);
		return "ShowStudents";
	}
	
	@GetMapping("/delete")
	public String del(Model model)
	{
		return "DeleteStudent";
	}
	
	@GetMapping("/datainsert")
	public String show(@RequestParam(value="Rollno1") int rollno,@RequestParam(value="Name1") String name,@RequestParam(value="Age1") int age)
	{
		stud.add(new student(rollno,name,age));
		return "InsertData";
	}
	
	@GetMapping("/showstudent")
	public String show1(Model model)
	{
		model.addAttribute("student1",stud);
		return "ShowStudents";
	}

}
