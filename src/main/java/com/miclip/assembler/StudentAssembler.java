package com.miclip.assembler;

import com.miclip.dto.StudentDto;
import com.miclip.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAssembler {
    public static StudentDto WriteDto(Student student){

        if(student == null){
            return null;
        }

        StudentDto studentDto = new StudentDto();
        studentDto.setBirthDate(student.getBirthDate());
        studentDto.setAgreedTerms(student.isAgreedTerms());
        studentDto.setName(student.getName());
        studentDto.setWaived(student.isWaived());
        studentDto.setJoinedDate(student.getJoinedDate());
        return studentDto;
    }

    public static List<StudentDto> WriteDto(List<Student> students) {

        if(students == null){
            return null;
        }

        List<StudentDto> studentDtos = new ArrayList<>();

        for (Student student : students) {
            studentDtos.add(WriteDto(student));
        }

        return studentDtos;
    }
}
