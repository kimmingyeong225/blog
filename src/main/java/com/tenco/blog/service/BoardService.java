package com.tenco.blog.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tenco.blog.handler.exception.DataDeliveryException;
import com.tenco.blog.repository.interfaces.BoardRepository;
import com.tenco.blog.repository.model.Board;

@Service
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	// 글 생성 기능
	public void creatBoard(Board dto) {
		int result = 0;
		
		try {
			result = boardRepository.insert(dto);
		} catch (DataAccessException e) {
			throw new DataDeliveryException("잘못된 요청입니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(result == 0) {
			throw new DataDeliveryException("정상 처리 되지 않았습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 글 목록
	public List<Board> viewBoard(){
		List<Board> boardlist = null;
		boardlist = boardRepository.viewBoard();
		System.out.println(boardlist + "boardList15414141414");
		return boardlist;
	}
	
	// 글 수정하기
	public void updateById(Board dto) {
		int result = 0;
		try {
			result = boardRepository.updateById(dto);
		} catch (DataAccessException e) {
			throw new DataDeliveryException("다시 확인해주세요", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(result == 0) {
			throw new DataDeliveryException("정상 처리 되지 않았습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 글 삭제하기
	public void deleteById(Integer id) {
		boardRepository.deleteById(id);
	}
}
