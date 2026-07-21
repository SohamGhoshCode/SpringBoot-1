package com.soham.demo.StudentServer.Service;

import com.soham.demo.StudentServer.DTO.*;
import com.soham.demo.StudentServer.Entity.Student;
import com.soham.demo.StudentServer.Exception.EmailAlreadyExistsException;
import com.soham.demo.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO dto) {

        // 🔴 EMAIL CHECK
        Optional<Student> existing = studentRepository.findByEmail(dto.getEmail());

        if (existing.isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        Student student = mapToStudent(dto);
        studentRepository.save(student);

        return mapToResponseDTO(student);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student studentUpdate(int id, Student student) {

        Student result = studentRepository.findById(id).orElse(null);

        if (result == null) return null;

        result.setName(student.getName());
        result.setAge(student.getAge());
        result.setDepartment(student.getDepartment());
        result.setEmail(student.getEmail());

        return studentRepository.save(result);
    }

    public Student deleteStudent(int id) {

        Student result = studentRepository.findById(id).orElse(null);

        if (result == null) return null;

        studentRepository.delete(result);
        return result;
    }

    private Student mapToStudent(CreateStudentRequestDTO dto) {

        Student student = new Student();

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setDepartment(dto.getDepartment());
        student.setEmail(dto.getEmail());

        return student;
    }

    private CreateStudentResponseDTO mapToResponseDTO(Student student) {

        CreateStudentResponseDTO res = new CreateStudentResponseDTO();

        res.setId(student.getId());
        res.setName(student.getName());
        res.setAge(student.getAge());
        res.setDepartment(student.getDepartment());
        res.setEmail(student.getEmail());
        res.setCreatedAt(student.getCreatedAt());
        res.setUpdatedAt(student.getUpdatedAt());

        return res;
    }
}