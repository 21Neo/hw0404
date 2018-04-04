package com.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


// 基于SpringRunner（Junit） 单元测试类
@RunWith(SpringRunner.class)
// 说明是springBoot 的测试类
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void hello(){
        ResponseEntity<String> entity = restTemplate.getForEntity("/hello",String.class);
        System.out.println(entity.getBody());

        //通过 assertThat 进行断言判断
        System.out.println(assertThat(entity.getBody()));
        System.out.println(assertThat(entity.getStatusCodeValue()).isEqualTo(200));
    }

    /**
     * 加载上下文
     */
    @Test
	public void contextLoads() {

	}

}
