package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class FacultyService {
    private final Map<Long, Faculty> facultyMap = new HashMap<>();
    private Long id = 0L;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++id);
        facultyMap.put(id, faculty);
        return faculty;
    }

    public Faculty findFaculty(Long id) {
        return facultyMap.get(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        if (facultyMap.containsKey(faculty.getId())) {
            facultyMap.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Faculty deleteFaculty(Long id) {
        return facultyMap.remove(id);
    }

    public Collection<Faculty> filterFacultyByColor(String color) {
        List<Faculty> facultyList = new ArrayList<>();
        for (Long key : facultyMap.keySet()) {
            if (facultyMap.get(key).getColor().equals(color)) {
                facultyList.add(facultyMap.get(key));
            }
        }
        return facultyList;
    }
}
