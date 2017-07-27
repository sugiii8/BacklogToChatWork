package com.example.backlogtocw.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.backlogtocw.bean.BacklogBean;
import com.example.backlogtocw.bean.BacklogMessageBean;
import com.example.backlogtocw.bean.ChatWorkBean;
import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.ResponseList;

/**
 * Backlogの課題をChatworkへメッセージを通知するController
 */
@ComponentScan("com.example.backlogtocw.*")
@Controller
public class BacklogToChatworkController {

	@Autowired
	BacklogBean backlogBean;

	@Autowired
	BacklogMessageBean backlogMessageBean;

	@Autowired
	ChatWorkBean chatworkBean;

	/**
	 * 処理開始
	 * NOTE: url=`/start` にマッピング
	 */
	@RequestMapping("/start")
	@ResponseBody
	public void start() {
		this.setBacklogMessageBean();

		if (this.backlogMessageBean == null) {
			return;
		}

		this.postChatWorkByBacklogMessage();
	}

	/**
	 * Backlogの情報(Issue)を保持
	 */
	private void setBacklogMessageBean() {
		try {
			// Issue１件ごとにBeanに格納する
			ResponseList<Issue> issues =  backlogBean.getIssues();
			Iterator<Issue> ite = issues.iterator();
			while(ite.hasNext()) {
				Issue issue = ite.next();
				this.backlogMessageBean.addIssue(issue);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println(this.backlogMessageBean);
		}
	}

	/**
	 * ChatWorkへpost
	 */
	private void postChatWorkByBacklogMessage() {
		// Issue１件ごとにpostする
		List<Issue> issues = this.backlogMessageBean.getIssues();
		Iterator<Issue> ite = issues.iterator();
		while(ite.hasNext()) {
			/**
			 * NOTE: postする内容
			 *  - summary
			 *  - url
			 */
			Issue issue = ite.next();
			String summary = issue.getSummary();
			String url = this.backlogBean.getIssueUrl(issue);
			String postMsg = summary.concat("\n").concat(url);
			this.chatworkBean.postMessage(postMsg);
		}
	}

}
