package com.example.backlogtocw.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nulabinc.backlog4j.Issue;

@Component
public class BacklogMessageBean {

	private List<Issue> issues = new ArrayList<Issue>();

	/**
	 * Issueをリストに追加
	 * @param issue Issue
	 */
	public void addIssue(Issue issue) {
		this.issues.add(issue);
	}

	/**
	 * Issueリストを取得
	 * @return issues List<Issue>
	 */
	public List<Issue> getIssues() {
		return this.issues;
	}

}
