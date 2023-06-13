package org.zerock.bj2.service;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.bj2.dto.PageRequestDTO;
import org.zerock.bj2.dto.PageResponseDTO;
import org.zerock.bj2.dto.ReplyDTO;

//interface / class / Method 걸 수 있다.
// Method > class > interface 순으로 찾아간다.
@Transactional
public interface ReplyService {

    // 댓글 등록
    Long register(ReplyDTO replyDTO);

    // 댓글 리스트 보기 (어떤 게시물의)
    PageResponseDTO<ReplyDTO> getList(Long tno, PageRequestDTO pageRequestDTO ); // pageRequestDTO => page, size 

    ReplyDTO getOne(Long tno);
    
}
