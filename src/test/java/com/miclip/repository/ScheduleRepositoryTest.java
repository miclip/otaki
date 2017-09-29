package com.miclip.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.miclip.entity.Schedule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
public class ScheduleRepositoryTest {

    Repository<Schedule> repository;

    Schedule entity1;
    Schedule entity2;
    Schedule entity3;

    @Before
    public void setup() {
        repository = new ScheduleRepository();
        entity1 = new Schedule("test 1", "09:30", new int[]{2,3,4,5}, new int[]{1,2,3,4,5,6,7,8,9,10,11,12}, new int[]{2017});
        entity2 = new Schedule("test 2", "09:30", new int[]{2,3,4,5}, new int[]{1,2,3,4,5,6,7,8,9,10,11,12}, new int[]{2017});
        entity3 = new Schedule("test 3", "09:30", new int[]{2,3,4,5}, new int[]{1,2,3,4,5,6,7,8,9,10,11,12}, new int[]{2017});
    }

    @Test
    public void testPersist() {
        assertThat(repository.get()).isEmpty();


        repository.persist(entity1);
        assertThat(repository.get()).contains(entity1);


        repository.persist(entity1, entity2);
        assertThat(repository.get()).containsOnly(entity1, entity2);


        List<Schedule> entityList = new ArrayList<>();
        entityList.add(entity3);


        repository.persist(entityList);
        assertThat(repository.get()).containsOnly(entity1, entity2, entity3);
    }

    @Test
    public void testRemove() {
        repository.persist(entity1, entity2, entity3);


        repository.remove(entity1);

        assertThat(repository.get()).doesNotContain(entity1);


        repository.remove(entity2, entity3);
        assertThat(repository.get()).isEmpty();



        repository.persist(entity1, entity2, entity3);

        List<Schedule> entityList = new ArrayList<>();
        entityList.add(entity3);

        repository.remove(entityList);
        assertThat(repository.get()).doesNotContain(entity3);



        repository.remove(item -> item.getName().endsWith("2"));
        assertThat(repository.get()).doesNotContain(entity2).contains(entity1);


        repository.remove(entity1.getId());
        assertThat(repository.get()).isEmpty();
    }


    @Test
    public void testGet() {
        repository.persist(entity1, entity2, entity3);


        assertThat(repository.get()).contains(entity1, entity2, entity3);


        final Optional<Schedule> entityOptional = repository.get(entity2.getId());


        assertThat(entityOptional.isPresent()).isTrue();
        assertThat(entityOptional.get()).isEqualTo(entity2);


        final Optional<Schedule> entityOptional2 = repository.get("some other id");
        assertThat(entityOptional2.isPresent()).isFalse();


        final Set<Schedule> entities = repository.get(item -> item.getName().startsWith("test"));

        assertThat(entities).contains(entity1, entity2, entity3);
    }

}
