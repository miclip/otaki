package com.miclip.assembler;

import com.miclip.dto.InstructorDto;
import com.miclip.entity.Instructor;

import java.util.ArrayList;
import java.util.List;

public  class  InstructorAssembler {
    public static InstructorDto WriteDto(Instructor instructor){

        if(instructor == null){
            return null;
        }

        InstructorDto instructorDto = new InstructorDto();
        instructorDto.setName(instructor.getName());
        return instructorDto;
    }

    public static List<InstructorDto> WriteDto(List<Instructor> instructors) {

        if(instructors == null){
            return null;
        }

        List<InstructorDto> instructorDtos = new ArrayList<>();

        for (Instructor instructor : instructors) {
            instructorDtos.add(WriteDto(instructor));
        }

        return instructorDtos;
    }
}
