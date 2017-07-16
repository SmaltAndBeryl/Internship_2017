package com.skill.India.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="approveReject",locations="classpath:sql/approveReject.yml")
public class ApproveRejectTableConfigSql {
	private String selectSql;
	private String insertSql;
	private String updateSqlApplication;
	private String updateSQLComment;
	private String commentExistSql;
	private String updateSqlAction;
	
	/**
	 * @return the updateSqlAction
	 */
	public String getUpdateSqlAction() {
		return updateSqlAction;
	}
	/**
	 * @param updateSqlAction the updateSqlAction to set
	 */
	public void setUpdateSqlAction(String updateSqlAction) {
		this.updateSqlAction = updateSqlAction;
	}
	/**
	 * @return the commentExistSql
	 */
	public String getCommentExistSql() {
		return commentExistSql;
	}
	/**
	 * @param commentExistSql the commentExistSql to set
	 */
	public void setCommentExistSql(String commentExistSql) {
		this.commentExistSql = commentExistSql;
	}
	/**
	 * @return the selectSql
	 */
	public String getSelectSql() {
		return selectSql;
	}
	/**
	 * @param selectSql the selectSql to set
	 */
	public void setSelectSql(String selectSql) {
		this.selectSql = selectSql;
	}
	/**
	 * @return the insertSql
	 */
	public String getInsertSql() {
		return insertSql;
	}
	/**
	 * @param insertSql the insertSql to set
	 */
	public void setInsertSql(String insertSql) {
		this.insertSql = insertSql;
	}
	/**
	 * @return the updateSqlApplication
	 */
	public String getUpdateSqlApplication() {
		return updateSqlApplication;
	}
	/**
	 * @param updateSqlApplication the updateSqlApplication to set
	 */
	public void setUpdateSqlApplication(String updateSqlApplication) {
		this.updateSqlApplication = updateSqlApplication;
	}
	/**
	 * @return the updateSQLComment
	 */
	public String getUpdateSQLComment() {
		return updateSQLComment;
	}
	/**
	 * @param updateSQLComment the updateSQLComment to set
	 */
	public void setUpdateSQLComment(String updateSQLComment) {
		this.updateSQLComment = updateSQLComment;
	}
	
	
	
}
