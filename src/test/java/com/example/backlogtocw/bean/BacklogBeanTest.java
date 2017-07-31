package com.example.backlogtocw.bean;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.ResponseList;;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BacklogBeanTest {

	@Autowired
	BacklogBean backlogBean;

	@Test
    public void testBacklogBeanNotNull(){
		// データありき
		ResponseList<Issue> issues = backlogBean.getIssues();
		assertThat(issues).isNotNull();
	}

	@Test
	public void testBacklogBeanIssueUrlNotNull() {
		ResponseList<Issue> issues = backlogBean.getIssues();
		Iterator<Issue> ite = issues.iterator();
		while( ite.hasNext() ) {
			Issue iss = ite.next();
			String url = backlogBean.getIssueUrl(iss);
			assertThat(url).isNotNull();
		}
	}
}