package com.tenco.blog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.blog.dto.BoardDTO;
import com.tenco.blog.handler.exception.DataDeliveryException;
import com.tenco.blog.repository.model.Board;
import com.tenco.blog.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	
	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	


	// http://localhost:8080/board/main
	// 생성 페이지 요청
    @GetMapping("/main")
    public String mainPage(Model model) {
    	System.out.println("mainPage() 호출 확인");
    	List<Board> boardList = boardService.viewBoard();
    	
    	model.addAttribute("boardList" , boardList);
        return "main";
    }

    // 글 쓰기 화면 페이지 요청
    @GetMapping("/saveForm")
    public String saveForm() {
    	System.out.println("글 쓰기 화면 호출 확인");
        return "board/saveForm";
    }

    // 글 수정 화면 페이지 요청
    @GetMapping("/{id}/updateForm")
    public String updateForm(Model model, @PathVariable(name = "id") int id) {
    	System.out.println("글 수정 화면 호출 확인");
    	
    	model.addAttribute("id", id);
        return "board/updateForm";
    }

    // main으로 이동 처리
    @PostMapping("/board/save")
    public String save(){
        return "redirect:/main";
    }

    @PostMapping("/{id}/update")
    public String update(Board dto, @PathVariable(name = "id") int id){
    	
    	if(dto.getTitle() == null || dto.getTitle().isEmpty()) {
    		throw new DataDeliveryException("제목을 입력해주세요", HttpStatus.BAD_REQUEST);
    	}
    	if(dto.getContent() == null || dto.getContent().isEmpty()) {
    		throw new DataDeliveryException("내용을 입력해주세요", HttpStatus.BAD_REQUEST);
    	}
    	
    	boardService.updateById(dto);
    	
        return "redirect:/board/main";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable(name = "id") int id){
        return "redirect:/board/main";
    }
}
