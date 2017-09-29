package com.miclip.repository;

import com.miclip.entity.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class SessionRepositoryTest {

    Repository<Session> repository;

    Session entity1;
    Session entity2;
    Session entity3;

    @Before
    public void setup() {
        repository = new SessionRepository();
        entity1 = new Session("test 1", new Date(), 60, 20, "Denver");
        entity2 = new Session("test 2", new Date(), 60, 20, "Denver");
        entity3 = new Session("test 3", new Date(), 60, 20, "Denver");
    }

    @Test
    public void testPersist() {
        assertThat(repository.get()).isEmpty();


        repository.persist(entity1);
        assertThat(repository.get()).contains(entity1);


        repository.persist(entity1, entity2);
        assertThat(repository.get()).containsOnly(entity1, entity2);


        List<Session> entityList = new ArrayList<>();
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

        List<Session> entityList = new ArrayList<>();
        entityList.add(entity3);

        repository.remove(entityList);
        assertThat(repository.get()).doesNotContain(entity3);



        repository.remove(item -> item.getCode().endsWith("2"));
        assertThat(repository.get()).doesNotContain(entity2).contains(entity1);


        repository.remove(entity1.getId());
        assertThat(repository.get()).isEmpty();
    }


    @Test
    public void testGet() {
        repository.persist(entity1, entity2, entity3);


        assertThat(repository.get()).contains(entity1, entity2, entity3);


        final Optional<Session> entityOptional = repository.get(entity2.getId());


        assertThat(entityOptional.isPresent()).isTrue();
        assertThat(entityOptional.get()).isEqualTo(entity2);


        final Optional<Session> entityOptional2 = repository.get("some other id");
        assertThat(entityOptional2.isPresent()).isFalse();


        final Set<Session> entities = repository.get(item -> item.getCode().startsWith("test"));

        assertThat(entities).contains(entity1, entity2, entity3);
    }

}
