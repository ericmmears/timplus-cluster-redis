package org.directtruststandards.timplus.cluster.cache;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public abstract class SpringBaseTest 
{
	@Autowired 
    protected RedisCacheRepository redisRepo;
	
	@Autowired
	protected ObjectMapper objectMapper;
	
	@BeforeEach
	protected void beforeTest()
	{
		redisRepo.deleteAll();
	}
}
