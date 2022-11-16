package com.knoldus.example.liquibase.poc.repository;

import com.knoldus.example.liquibase.poc.domain.Poc;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ActiveProfiles("integration-test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
@SpringBootTest
public class PocRepositoryTest {

    @Autowired
    private PocRepository repository;

    @Test
    public void loadTheDataInsertedByLiquibaseContextTests() {
        List<Poc> pocs = repository.findAll();

        assertEquals(2, pocs.size());
        for (Poc poc : pocs) {
            assertTrue("Poc Test 1".equals(poc.getName()) || "Poc Test 2".equals(poc.getName()));
        }
    }
}