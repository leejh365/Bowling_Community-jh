package com.cos.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.model.FreeBoard;



public interface FreeBoardRepository extends JpaRepository<FreeBoard, Integer>{

	@Modifying
	@Query(value="update FreeBoard f set f.freeBoardCount = f.freeBoardCount + 1 where f.id = :id", nativeQuery = true)
	int CountUp(int id); // 업데이트된 행의 개수를 리턴해줌.  
	
	// 검색 메서드
	Page<FreeBoard> findByFreeBoardTitleContaining(String searchText, Pageable pageable);
	 
   // Page<FreeBoard> findByFreeBoard_titleContainigOrFreeBoard_contentContainig(String freeBoard_title, String freeBoard_content, Pageable pageable);
	
	
}
