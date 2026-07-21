package com.soham.demo.StudentServer.Service;


import com.soham.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.soham.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.soham.demo.StudentServer.Entity.Student;
import com.soham.demo.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO createStudentRequestDTO) {

        Student student = mapToStudent(createStudentRequestDTO);

        studentRepository.save(student);

        return mapToResponseDTO(student);
    }

    public Student getStudentById(int id) {
        Optional<Student> student =  studentRepository.findById(id);
        return student.get();
    }

    public Student studentUpdate(int id, Student student) {

        Student result = studentRepository.findById(id).orElse(null);

        if (result == null) {
            return null;
        }

        result.setName(student.getName());
        result.setAge(student.getAge());
        result.setDepartment(student.getDepartment());

        // Agar Entity me @UpdateTimestamp use kar rahe ho,
        // to ye line hata bhi sakte ho.
        result.setUpdatedAt(LocalDateTime.now());

        return studentRepository.save(result);
    }

    public Student deleteStudent(int id) {

        Student result = studentRepository.findById(id).orElse(null);

        if (result == null) {
            return null;
        }

        studentRepository.delete(result);

        return result;
    }

    private Student mapToStudent(CreateStudentRequestDTO createStudentRequestDTO) {

        Student student = new Student();

        student.setName(createStudentRequestDTO.getName());
        student.setAge(createStudentRequestDTO.getAge());
        student.setDepartment(createStudentRequestDTO.getDepartment());

        // Agar @CreationTimestamp aur @UpdateTimestamp use kar rahe ho
        // to ye dono lines hata sakte ho.
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private CreateStudentResponseDTO mapToResponseDTO(Student student) {

        CreateStudentResponseDTO createStudentResponseDTO =
                new CreateStudentResponseDTO();

        createStudentResponseDTO.setId(student.getId());
        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setDepartment(student.getDepartment());

        return createStudentResponseDTO;
    }
}