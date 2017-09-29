package com.miclip.repository;

import com.miclip.entity.Program;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class ProgramRepositoryTest {

    Repository<Program> repository;

    Program entity1;
    Program entity2;
    Program entity3;

    @Before
    public void setup() {
        repository = new ProgramRepository();
        entity1 = new Program("test 1","Code", new Date(),60,10,"Denver","A description");
        entity2 = new Program("test 2","Code", new Date(),60,10,"Denver","A description");
        entity3 = new Program("test 3","Code", new Date(),60,10,"Denver","A description");
    }

    @Test
    public void testPersist() {
        assertThat(repository.get()).isEmpty();


        repository.persist(entity1);
        assertThat(repository.get()).contains(entity1);


        repository.persist(entity1, entity2);
        assertThat(repository.get()).containsOnly(entity1, entity2);


        List<Program> entityList = new ArrayList<>();
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

        List<Program> entityList = new ArrayList<>();
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


        final Optional<Program> entityOptional = repository.get(entity2.getId());


        assertThat(entityOptional.isPresent()).isTrue();
        assertThat(entityOptional.get()).isEqualTo(entity2);


        final Optional<Program> entityOptional2 = repository.get("some other id");
        assertThat(entityOptional2.isPresent()).isFalse();


        final Set<Program> entities = repository.get(item -> item.getName().startsWith("test"));

        assertThat(entities).contains(entity1, entity2, entity3);
    }

}
