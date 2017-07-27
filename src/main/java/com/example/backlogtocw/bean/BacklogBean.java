package com.example.backlogtocw.bean;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backlogtocw.config.ApplicationProperties;
import com.nulabinc.backlog4j.BacklogClient;
import com.nulabinc.backlog4j.BacklogClientFactory;
import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.api.option.GetIssuesParams;
import com.nulabinc.backlog4j.conf.BacklogConfigure;
import com.nulabinc.backlog4j.conf.BacklogJpConfigure;

@Component
public class BacklogBean {

    private final ApplicationProperties props;

    private BacklogClient cli = null;

    /**
     * Backlog APIへのアクセスを管理するBean
     * BacklogClientは外部に渡さず、本クラスを経由して必要な情報のみ返却する
     * @param ApplicationProperties 設定値の管理クラス
     */
    @Autowired
    public BacklogBean(ApplicationProperties applicationProps)  {
    	this.props = applicationProps;

    	try {
            // 設定を元にクライアント生成し、保持する
            String s = this.props.getBacklog().getSpace();
            String k = this.props.getBacklog().getApiKey();
            BacklogConfigure configure;
            configure = new BacklogJpConfigure(s).apiKey(k);
            BacklogClient backlog = new BacklogClientFactory(configure).newClient();
            this.cli = backlog;
        } catch (MalformedURLException e) {
            System.out.println(e);
        } finally {
            System.out.println("cli finished.");
        }
    }

    /**
     * Open状態のIssueを取得
     * @return ResponseList<Issue> Issueリスト
     */
    public ResponseList<Issue> getIssues() {
        GetIssuesParams issueParams = this.getIssueParams();

        List<Issue.StatusType> statuses = this.getOpenStatuses();
        issueParams.statuses(statuses);

        ResponseList<Issue> issues =  this.cli.getIssues(issueParams);
        return issues;
    }

    /**
     * IssueのURLを取得
     * @param issue Issue
     * @return Issue URL
     */
    public String getIssueUrl(Issue issue) {
        return this.cli.getIssueUrl(issue);
    }

    private GetIssuesParams getIssueParams() {
        List<Integer> projectIds = new ArrayList<Integer>();
        projectIds.add(Integer.parseInt(this.props.getBacklog().getProjId()));
        GetIssuesParams issueParams = new GetIssuesParams(projectIds);
        return issueParams;
    }

    private List<Issue.StatusType> getOpenStatuses() {
        List<Issue.StatusType> statuses = new ArrayList<Issue.StatusType>();
        statuses.add(Issue.StatusType.Open);
        return statuses;
    }
}