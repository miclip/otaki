package com.miclip.assembler;

import com.miclip.dto.InstructorDto;
import com.miclip.entity.Instructor;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
public class InstructorAssemblerTest {

    private void assertInstructorDtoEqualsInstructor(InstructorDto instructorDto, Instructor instructor) {
        Assert.assertEquals(instructorDto.getName(),instructor.getName());
    }

    @Test
    public void assemblesInstructorDtoFromInstructor() {
        Instructor instructor = new Instructor();
        instructor.setName("Test Name");
        InstructorDto instructorDto = InstructorAssembler.WriteDto(instructor);
        assertInstructorDtoEqualsInstructor(instructorDto,instructor);
    }


    @Test
    public void assemblesInstructorDtosFromInstructors() {
        Instructor instructor1 = new Instructor();
        instructor1.setName("Test Name 1");
        Instructor instructor2 = new Instructor();
        instructor2.setName("Test Name 2");
        List<Instructor> instructors = new ArrayList<>(Arrays.asList(instructor1, instructor2));
        List<InstructorDto> instructorsDto = InstructorAssembler.WriteDto(instructors);
        Assert.assertEquals(instructorsDto.size(),instructors.size());
        assertInstructorDtoEqualsInstructor(instructorsDto.get(0),instructors.get(0));
        assertInstructorDtoEqualsInstructor(instructorsDto.get(1),instructors.get(1));
    }

    @Test
    public void assemblesNullInstructorDtoFromNullInstructor() {
        Instructor instructor = null;
        InstructorDto instructorDto = InstructorAssembler.WriteDto(instructor);
        Assert.assertEquals(instructorDto,null);
    }

    @Test
    public void assemblesNullInstructorsDtoFromNullInstructors() {
        List<Instructor> instructor = null;
        List<InstructorDto> instructorDto = InstructorAssembler.WriteDto(instructor);
        Assert.assertEquals(instructorDto,null);
    }

}
