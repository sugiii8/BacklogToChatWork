package com.example.backlogtocw.bean;

import org.springframework.stereotype.Component;

import com.example.backlogtocw.config.ApplicationProperties;
import com.masahirosaito.chatwork4j.ChatWork4j;

/**
 * ChatWork APIクライアントを管理します
 * BacklogBeanと同様にChatWork4jは外部に渡さず、本クラスを経由して必要な操作を行います
 * @see BacklogBean
 */
@Component
public class ChatWorkBean {

    private final ApplicationProperties props;

    private ChatWork4j chatWorkClient;

    public ChatWorkBean(ApplicationProperties applicationProps) {
        // コンストラクタでChatWorkClientを生成し保持する
        this.props = applicationProps;
        this.chatWorkClient = new ChatWork4j(this.props.getChatWork().getApiKey());
    }

    /**
     * ChatWorkにpostする
     * @param msg String
     */
    public void postMessage(String msg) {
        int roomId = Integer.parseInt(this.props.getChatWork().getRoomId());
        this.chatWorkClient.postMessage(roomId, msg);
    }

}