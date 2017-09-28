package com.miclip.assembler;

import com.miclip.dto.SessionDto;
import com.miclip.entity.Session;

import java.util.ArrayList;
import java.util.List;

public class SessionAssembler {
    public static SessionDto WriteDto(Session session){

        if(session == null){
            return null;
        }

        SessionDto sessionDto = new SessionDto();
        sessionDto.setCode(session.getCode());
        sessionDto.setDuration(session.getDuration());
        sessionDto.setLocation(session.getLocation());
        sessionDto.setStartDateTime(session.getStartDateTime());
        sessionDto.setStudentCapacity(session.getStudentCapacity());
        sessionDto.setInstructors(InstructorAssembler.WriteDto(session.getInstructors()));
        sessionDto.setStudents(StudentAssembler.WriteDto(session.getStudents()));
        return sessionDto;
    }

    public static List<SessionDto> WriteDto(List<Session> sessions) {

        if(sessions == null){
            return null;
        }

        List<SessionDto> sessionDtos = new ArrayList<>();

        for (Session session : sessions) {
            sessionDtos.add(WriteDto(session));
        }

        return sessionDtos;
    }
}
