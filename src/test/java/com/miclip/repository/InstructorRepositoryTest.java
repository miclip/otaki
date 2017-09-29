package com.miclip.repository;

import com.miclip.entity.Instructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class InstructorRepositoryTest {

    Repository<Instructor> repository;

    Instructor entity1;
    Instructor entity2;
    Instructor entity3;

    @Before
    public void setup() {
        repository = new InstructorRepository();
        entity1 = new Instructor("test 1");
        entity2 = new Instructor("test 2");
        entity3 = new Instructor("test 3");
    }

    @Test
    public void testPersist() {
        assertThat(repository.get()).isEmpty();


        repository.persist(entity1);
        assertThat(repository.get()).contains(entity1);


        repository.persist(entity1, entity2);
        assertThat(repository.get()).containsOnly(entity1, entity2);


        List<Instructor> entityList = new ArrayList<>();
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

        List<Instructor> entityList = new ArrayList<>();
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


        final Optional<Instructor> entityOptional = repository.get(entity2.getId());


        assertThat(entityOptional.isPresent()).isTrue();
        assertThat(entityOptional.get()).isEqualTo(entity2);


        final Optional<Instructor> entityOptional2 = repository.get("some other id");
        assertThat(entityOptional2.isPresent()).isFalse();


        final Set<Instructor> entities = repository.get(item -> item.getName().startsWith("test"));

        assertThat(entities).contains(entity1, entity2, entity3);
    }

}
