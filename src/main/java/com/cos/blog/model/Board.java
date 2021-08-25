package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터
	private String content;
	
	@ColumnDefault("0")
	private int count; // 조회수
	
	@ManyToOne // Many = Board, User = One (한명이 여러개의 게시물 가능하다)
	// @OneToOne -> 한명이 하나의 게시물만 가능하다
	@JoinColumn(name="userId")
	private User user; // DB는 오브젝트 저장 X, 자바는 오브젝트 저장 가능
								//ORM을 사용하면 오브젝트 저장 가능
	
	@CreationTimestamp
	private Timestamp createDate;
}
