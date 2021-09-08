package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@ManyToOne(fetch = FetchType.EAGER) // Many = Board, User = One (한명이 여러개의 게시물 가능하다)
	//FetchType.EAGER -> select 할 때 반드시 가져와라
	//FetchType.LAZY -> select 할 때 가져오는 데 필요할 때 사용 가능
	
	// @OneToOne -> 한명이 하나의 게시물만 가능하다
	@JoinColumn(name="userId")
	private User user; // DB는 오브젝트 저장 X, 자바는 오브젝트 저장 가능
								//ORM을 사용하면 오브젝트 저장 가능
	
	@OneToMany(mappedBy = "board",fetch = FetchType.EAGER) // mappedBy -> 연관관계의 주인이 아니다(난 FK가 아니다)
																  // DB에 컬럼을 안 만든다. board를 select 할때 Join으로 값 얻기 위해
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
}
