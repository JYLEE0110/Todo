package org.zerock.bj2.mappers;

import org.zerock.bj2.dto.ReplyDTO;

public interface ReplyMapper {
    
    // 순수 댓글
    int insert(ReplyDTO replyDTO);

    // SELECT LAST_INSERT_ID()값을 얻고 gno에 update
    int updateGno(Long rno);

    // 대댓글
    int insertChild(ReplyDTO replyDTO);


}
