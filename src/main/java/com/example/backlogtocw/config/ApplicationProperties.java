package com.example.backlogtocw.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 設定値の管理クラス
 * `application.yml` をbindします
 */
@ConfigurationProperties("application")
public class ApplicationProperties {

	private Backlog backlog;
	private ChatWork chatWork;

    public static class Backlog {
        private String space;
        private String apiKey;
        private String projId;
		public String getSpace() {
			return space;
		}
		public void setSpace(String space) {
			this.space = space;
		}
		public String getApiKey() {
			return apiKey;
		}
		public void setApiKey(String apiKey) {
			this.apiKey = apiKey;
		}
		public String getProjId() {
			return projId;
		}
		public void setProjId(String projId) {
			this.projId = projId;
		}
	}

	public static class ChatWork {
		private String apiKey;
		private String roomId;
		public String getApiKey() {
			return apiKey;
		}
		public void setApiKey(String apiKey) {
			this.apiKey = apiKey;
		}
		public String getRoomId() {
			return roomId;
		}
		public void setRoomId(String roomId) {
			this.roomId = roomId;
		}
	}

	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}

	public ChatWork getChatWork() {
		return chatWork;
	}

	public void setChatWork(ChatWork chatWork) {
		this.chatWork = chatWork;
	}

}