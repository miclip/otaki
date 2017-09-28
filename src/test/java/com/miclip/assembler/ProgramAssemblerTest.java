package com.miclip.assembler;

import com.miclip.entity.Session;
import com.miclip.dto.ProgramDto;
import com.miclip.entity.Instructor;
import com.miclip.entity.Program;
import com.miclip.entity.Schedule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
public class ProgramAssemblerTest {

    private void assertProgramDtoEqualsProgram(ProgramDto programDto, Program program) {
        Assert.assertEquals(programDto.getName(),program.getName());
        Assert.assertEquals(programDto.getCode(),program.getCode());
        Assert.assertEquals(programDto.getStartDate(),program.getStartDate());
        Assert.assertEquals(programDto.getDescription(),program.getDescription());
        Assert.assertEquals(programDto.getDuration(),program.getDuration());
        Assert.assertEquals(programDto.getLocation(),program.getLocation());
        Assert.assertEquals(programDto.getStudentCapacity(),program.getStudentCapacity());
        // lists
        Assert.assertEquals(programDto.getInstructors().size(),program.getInstructors().size());
        Assert.assertEquals(programDto.getSessions().size(),program.getSessions().size());
        Assert.assertEquals(programDto.getSchedules().size(),program.getSchedules().size());
    }

    private Program createProgram() {
        Program program = new Program();
        program.setName("Test Name");
        program.setCode("Code");
        program.setDescription("Description");
        program.setDuration(10);
        program.setLocation("Location");
        program.setStartDate(new Date());
        program.setStudentCapacity(10);
        program.setInstructors(new ArrayList<>(Arrays.asList(new Instructor())));
        program.setSessions(new ArrayList<>(Arrays.asList(new Session())));
        program.setSchedules(new ArrayList<>(Arrays.asList(new Schedule())));
        return program;
    }

    @Test
    public void assemblesInstructorDtoFromInstructor() {
        Program program = createProgram();
        ProgramDto programDto = ProgramAssembler.WriteDto(program);
        assertProgramDtoEqualsProgram(programDto,program);
    }

    @Test
    public void assemblesProgramDtosFromPrograms() {
        Program program1 = createProgram();
        Program program2 = createProgram();
        List<Program> programs = new ArrayList<>(Arrays.asList(program1, program2));
        List<ProgramDto> programsDto = ProgramAssembler.WriteDto(programs);
        Assert.assertEquals(programsDto.size(),programs.size());
        assertProgramDtoEqualsProgram(programsDto.get(0),programs.get(0));
        assertProgramDtoEqualsProgram(programsDto.get(1),programs.get(1));
    }

    @Test
    public void assemblesNullProgramDtoFromNullProgram() {
        Program program = null;
        ProgramDto programDto = ProgramAssembler.WriteDto(program);
        Assert.assertEquals(programDto,null);
    }

    @Test
    public void assemblesNullProgramsDtoFromNullPrograms() {
        List<Program> program = null;
        List<ProgramDto> programDto = ProgramAssembler.WriteDto(program);
        Assert.assertEquals(programDto,null);
    }

}
