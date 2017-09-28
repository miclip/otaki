package com.miclip.assembler;

import com.miclip.dto.StudentDto;
import com.miclip.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
public class StudentAssemblerTest {

    private void assertStudentDtoEqualsStudent(StudentDto studentDto, Student student) {
        Assert.assertEquals(studentDto.getName(),student.getName());
        Assert.assertEquals(studentDto.getBirthDate(),student.getBirthDate());
        Assert.assertEquals(studentDto.getJoinedDate(),student.getJoinedDate());
        Assert.assertEquals(studentDto.isAgreedTerms(),student.isAgreedTerms());
        Assert.assertEquals(studentDto.isWaived(),student.isWaived());
    }

    private Student createStudent() {
        Student student = new Student();
        student.setName("Name");
        student.setAgreedTerms(true);
        student.setBirthDate(new Date());
        student.setJoinedDate(new Date());
        student.setWaived(true);
        return student;
    }

    @Test
    public void assemblesInstructorDtoFromInstructor() {
        Student student = createStudent();
        StudentDto studentDto = StudentAssembler.WriteDto(student);
        assertStudentDtoEqualsStudent(studentDto,student);
    }

    @Test
    public void assemblesStudentDtosFromStudents() {
        Student student1 = createStudent();
        Student student2 = createStudent();
        List<Student> students = new ArrayList<>(Arrays.asList(student1, student2));
        List<StudentDto> studentsDto = StudentAssembler.WriteDto(students);
        Assert.assertEquals(studentsDto.size(),students.size());
        assertStudentDtoEqualsStudent(studentsDto.get(0),students.get(0));
        assertStudentDtoEqualsStudent(studentsDto.get(1),students.get(1));
    }

    @Test
    public void assemblesNullStudentDtoFromNullStudent() {
        Student student = null;
        StudentDto studentDto = StudentAssembler.WriteDto(student);
        Assert.assertEquals(studentDto,null);
    }

    @Test
    public void assemblesNullStudentsDtoFromNullStudents() {
        List<Student> student = null;
        List<StudentDto> studentDto = StudentAssembler.WriteDto(student);
        Assert.assertEquals(studentDto,null);
    }
}
