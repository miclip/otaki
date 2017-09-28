package com.miclip.assembler;

import com.miclip.dto.ScheduleDto;
import com.miclip.entity.Schedule;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAssembler {
    public static ScheduleDto WriteDto(Schedule schedule){

        if(schedule == null){
            return null;
        }

        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setDayOfWeek(schedule.getDayOfWeek());
        scheduleDto.setMonth(schedule.getMonth());
        scheduleDto.setName(schedule.getName());
        scheduleDto.setStartTime(schedule.getStartTime());
        scheduleDto.setYear(schedule.getYear());
        return scheduleDto;
    }

    public static List<ScheduleDto> WriteDto(List<Schedule> schedules) {

        if(schedules == null){
            return null;
        }

        List<ScheduleDto> scheduleDtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            scheduleDtos.add(WriteDto(schedule));
        }

        return scheduleDtos;
    }
    
}
