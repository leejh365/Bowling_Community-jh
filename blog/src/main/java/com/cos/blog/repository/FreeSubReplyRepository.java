package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.model.FreeSubReply;

public interface FreeSubReplyRepository extends JpaRepository<FreeSubReply, Integer>{
	@Modifying
	@Query(value="INSERT INTO freeSubReply(userId, freeBoardId, freeReplyId, freeSubReplyContent, createDate) VALUES(?1, ?2, ?3, ?4, now())", nativeQuery = true)
	int mSave(int userId, int freeBoardId, int freeReplyId, String freeReplyContent); // 업데이트된 행의 개수를 리턴해줌.  
	
}
