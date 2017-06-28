package com.skill.India.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.India.dao.CommentDao;
import com.skill.India.dto.CommentDto;

@Service
public class CommentService {
		
		
		@Autowired
		private CommentDao commentDao;
		
		public boolean setComments(CommentDto commentDto){
			int status;
			status =commentDao.insertComment(commentDto);
			if(status == 0)
				return false;
			else
				return true;
			
		}
		

	}
