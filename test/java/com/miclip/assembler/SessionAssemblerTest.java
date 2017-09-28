package com.miclip.assembler;

import com.miclip.dto.SessionDto;
import com.miclip.entity.Instructor;
import com.miclip.entity.Session;
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
public class SessionAssemblerTest {

    private void assertSessionDtoEqualsSession(SessionDto sessionDto, Session session) {
        Assert.assertEquals(sessionDto.getCode(),session.getCode());
        Assert.assertEquals(sessionDto.getDuration(),session.getDuration());
        Assert.assertEquals(sessionDto.getLocation(),session.getLocation());
        Assert.assertEquals(sessionDto.getStartDateTime(),session.getStartDateTime());
        Assert.assertEquals(sessionDto.getStudentCapacity(),session.getStudentCapacity());
        Assert.assertEquals(sessionDto.getInstructorDtos().size(),session.getInstructors().size());
        Assert.assertEquals(sessionDto.getStudents().size(),session.getStudents().size());
    }

    private Session createSession() {
        Session session = new Session();
        session.setCode("Code");
        session.setDuration(10);
        session.setLocation("Location");
        session.setStartDateTime(new Date());
        session.setStudentCapacity(10);
        session.setInstructors(new ArrayList<>(Arrays.asList(new Instructor())));
        session.setStudents(new ArrayList<>(Arrays.asList(new Student())));
        return session;
    }

    @Test
    public void assemblesInstructorDtoFromInstructor() {
        Session session = createSession();
        SessionDto sessionDto = SessionAssembler.WriteDto(session);
        assertSessionDtoEqualsSession(sessionDto,session);
    }

    @Test
    public void assemblesSessionDtosFromSessions() {
        Session session1 = createSession();
        Session session2 = createSession();
        List<Session> sessions = new ArrayList<>(Arrays.asList(session1, session2));
        List<SessionDto> sessionsDto = SessionAssembler.WriteDto(sessions);
        Assert.assertEquals(sessionsDto.size(),sessions.size());
        assertSessionDtoEqualsSession(sessionsDto.get(0),sessions.get(0));
        assertSessionDtoEqualsSession(sessionsDto.get(1),sessions.get(1));
    }

    @Test
    public void assemblesNullSessionDtoFromNullSession() {
        Session session = null;
        SessionDto sessionDto = SessionAssembler.WriteDto(session);
        Assert.assertEquals(sessionDto,null);
    }

    @Test
    public void assemblesNullSessionsDtoFromNullSessions() {
        List<Session> session = null;
        List<SessionDto> sessionDto = SessionAssembler.WriteDto(session);
        Assert.assertEquals(sessionDto,null);
    }
}
