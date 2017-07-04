package com.skill.India.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skill.India.common.AbstractTransactionalDao;
import com.skill.India.config.CommentConfigSql;
import com.skill.India.dto.CommentDto;

	@Repository
	public class CommentDao extends AbstractTransactionalDao{

		@Autowired
		public CommentConfigSql config;
		
			public int insertComment(CommentDto comment) {
			Map<String, Object> parameters = new HashMap<>();			
			parameters.put("comment",comment.getComment());
			parameters.put("applicationID",comment.getApplicationID());
			parameters.put("flag",comment.isFlag());
			return insert(config.getInsertSql(), parameters, "ID");
			}
			
		
		}
	



