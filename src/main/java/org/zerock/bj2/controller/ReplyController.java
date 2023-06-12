package org.zerock.bj2.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.bj2.dto.ReplyDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor // 서비스 의존성 자동 주입
@RequestMapping("/replies/")
public class ReplyController {
    
    // 어떤 종류의 데이터를 생산해내는지?
    // comsumes 받아들이는 데이터 타입
    // produces 제공하는 데이터 타입
    @GetMapping(value = "{tno}/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReplyDTO> getReplyList(
        @PathVariable("tno") Long tno
    ){

        log.info("TNO : " + tno);

        //1 ~ 10 까지 돌리면서 리스트로 묶어버림
        List<ReplyDTO> result = IntStream.rangeClosed(1, 10).mapToObj(i -> {
            return ReplyDTO.builder()
                    .rno((long)i)
                    .tno(tno)
                    .reply("댓글..." + i)
                    .replyer("user00")
                    .replyDate(LocalDate.now())
                    .build();
                    
        }).collect(Collectors.toList());

        return result;
    }

    @PostMapping("{tno}/new")
    public Map<String, Long> register(
        @PathVariable("tno") Long tno,
        @RequestBody ReplyDTO replyDTO
    ){
        replyDTO.setTno(tno);

        log.info(replyDTO);

        return Map.of("result", 321L);
    }

  

}