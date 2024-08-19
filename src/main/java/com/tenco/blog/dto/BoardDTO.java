package com.tenco.blog.dto;

import com.tenco.blog.repository.model.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BoardDTO {
	private int id;
	private String title;
	private String content;
	private String user;
	


}
