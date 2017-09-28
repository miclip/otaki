package com.miclip.assembler;

import com.miclip.dto.ScheduleDto;
import com.miclip.entity.Schedule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class ScheduleAssemblerTest {

    private void assertScheduleDtoEqualsSchedule(ScheduleDto scheduleDto, Schedule schedule) {
        Assert.assertEquals(scheduleDto.getDayOfWeek(),schedule.getDayOfWeek());
        Assert.assertEquals(scheduleDto.getMonth(),schedule.getMonth());
        Assert.assertEquals(scheduleDto.getStartTime(),schedule.getStartTime());
        Assert.assertEquals(scheduleDto.getName(),schedule.getName());
        Assert.assertEquals(scheduleDto.getYear(),schedule.getYear());
    }

    private Schedule createSchedule() {
        Schedule schedule = new Schedule();
        schedule.setDayOfWeek(new int[]{1,3});
        schedule.setMonth(new int[]{1,2,3});
        schedule.setYear(new int[]{2017,2018});
        schedule.setName("Name");
        schedule.setStartTime("12:33:22");
        return schedule;
    }

    @Test
    public void assemblesInstructorDtoFromInstructor() {
        Schedule schedule = createSchedule();
        ScheduleDto scheduleDto = ScheduleAssembler.WriteDto(schedule);
        assertScheduleDtoEqualsSchedule(scheduleDto,schedule);
    }

    @Test
    public void assemblesScheduleDtosFromSchedules() {
        Schedule schedule1 = createSchedule();
        Schedule schedule2 = createSchedule();
        List<Schedule> schedules = new ArrayList<>(Arrays.asList(schedule1, schedule2));
        List<ScheduleDto> schedulesDto = ScheduleAssembler.WriteDto(schedules);
        Assert.assertEquals(schedulesDto.size(),schedules.size());
        assertScheduleDtoEqualsSchedule(schedulesDto.get(0),schedules.get(0));
        assertScheduleDtoEqualsSchedule(schedulesDto.get(1),schedules.get(1));
    }

    @Test
    public void assemblesNullScheduleDtoFromNullSchedule() {
        Schedule schedule = null;
        ScheduleDto scheduleDto = ScheduleAssembler.WriteDto(schedule);
        Assert.assertEquals(scheduleDto,null);
    }

    @Test
    public void assemblesNullSchedulesDtoFromNullSchedules() {
        List<Schedule> schedule = null;
        List<ScheduleDto> scheduleDto = ScheduleAssembler.WriteDto(schedule);
        Assert.assertEquals(scheduleDto,null);
    }
}
