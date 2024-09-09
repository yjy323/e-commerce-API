package com.project.api.h2db;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TestRepositoryTest {

  @Autowired
  TestRepository testRepository;

  @Test
  public void testSave(){

    TestEntity testEntity = new TestEntity();
    Long savedId = testRepository.save(testEntity).getId();

    TestEntity findEntity = testRepository.findById(savedId).get();
    Assertions.assertEquals(savedId, findEntity.getId());
  }
}