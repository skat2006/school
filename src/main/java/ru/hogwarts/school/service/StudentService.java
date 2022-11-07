package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class StudentService {
    private final Map<Long, Student> studentMap = new HashMap<>();
    private Long id = 0L;

    public Student createStudent(Student student) {
        student.setId(++id);
        studentMap.put(id, student);
        return student;
    }

    public Student findStudent(Long id) {
        return studentMap.get(id);
    }

    public Student editStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent(Long id) {
        return studentMap.remove(id);
    }

    public Collection<Student> filterStudentsByAge(int age) {
        List<Student> studentList = new ArrayList<>();
        for (Long key : studentMap.keySet()) {
            if (studentMap.get(key).getAge() > age) {
                studentList.add(studentMap.get(key));
            }
        }
        return studentList;
    }
}
