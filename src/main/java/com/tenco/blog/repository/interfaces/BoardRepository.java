package com.tenco.blog.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.blog.repository.model.Board;

@Mapper
public interface BoardRepository {
	public int insert(Board board); // 글쓰기
	public int updateById(Board board); // 글 수정하기
	public int deleteById(Integer id); // 글 삭제하기
	public List<Board> viewBoard(); // 글 목록보기

}
