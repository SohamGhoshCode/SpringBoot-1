package com.soham.demo.StudentServer.Service;

import com.soham.demo.StudentServer.Entity.Student;
import com.soham.demo.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student studentValidate(Student student){

        int id = student.getId();
        String name = student.getName();
        String department = student.getDepartment();
        int age = student.getAge();


        if(id < 0 || name == null || department == null || age < 0){
            return null;
        }

        studentRepository.save(student);
        return student;
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }
}