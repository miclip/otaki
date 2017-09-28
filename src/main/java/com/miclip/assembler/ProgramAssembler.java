package com.miclip.assembler;

import com.miclip.dto.ProgramDto;
import com.miclip.entity.Program;

import java.util.*;

public class ProgramAssembler {
    public static ProgramDto WriteDto(Program program) {

        if (program == null) {
            return null;
        }

        ProgramDto programDto = new ProgramDto();
        programDto.setName(program.getName());
        programDto.setCode(program.getCode());
        programDto.setStartDate(program.getStartDate());
        programDto.setDuration(program.getDuration());
        programDto.setStudentCapacity(program.getStudentCapacity());
        programDto.setLocation(program.getLocation());
        programDto.setDescription(program.getDescription());

        programDto.setInstructors(InstructorAssembler.WriteDto(program.getInstructors()));
        programDto.setSessions(SessionAssembler.WriteDto(program.getSessions()));
        programDto.setSchedules(ScheduleAssembler.WriteDto(program.getSchedules()));
        return programDto;
    }
    
    public static List<ProgramDto> WriteDto(List<Program> programs) {

        if (programs == null) {
            return null;
        }

        List<ProgramDto> programDtos = new ArrayList<>();

        for (Program program : programs) {
            programDtos.add(WriteDto(program));
        }

        return programDtos;
    }
}
