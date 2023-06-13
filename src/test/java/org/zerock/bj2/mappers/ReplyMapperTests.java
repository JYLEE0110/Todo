package org.zerock.bj2.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.bj2.dto.ReplyDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyMapperTests {

    @Autowired(required = false)
    private ReplyMapper replyMapper;

    @Test
    // test코드는 기본 rollback => @commit
    @Transactional
    @Commit
    public void testInsert(){

        ReplyDTO replyDTO  = ReplyDTO.builder()
                                .tno(100L)
                                .reply("댓글 테스트")
                                .replyer("replyer00")
                                .build(); 

        int insertCount = replyMapper.insert(replyDTO);

        Assertions.assertEquals(insertCount, 1);

        if(insertCount != 1){
            throw new RuntimeException("INSERT FAIL");
        }


        Long rno = replyDTO.getRno();

        log.info("RNO : " + rno);

        replyMapper.updateGno(rno);

    }
    
}
