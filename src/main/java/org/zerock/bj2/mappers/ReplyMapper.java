package org.zerock.bj2.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.bj2.dto.PageRequestDTO;
import org.zerock.bj2.dto.ReplyDTO;

public interface ReplyMapper {
    
    // 순수 댓글
    int insert(ReplyDTO replyDTO);

    // SELECT LAST_INSERT_ID()값을 얻고 gno에 update
    int updateGno(Long rno);

    // 대댓글
    int insertChild(ReplyDTO replyDTO);

    // 댓글 페이징
    List<ReplyDTO> selectList(
        
        // MyBatis Parameter를 여러개 받을때 @Param
        @Param("tno") Long tno, 
        @Param("pr") PageRequestDTO pageRequestDTO);


}
