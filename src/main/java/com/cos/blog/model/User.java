package com.cos.blog.model;

import java. sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.print.event.PrintJobAttributeEvent;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// ORM -> Java(혹은 다른언어 포함) Object -> 테이블로 매핑


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //User클래스가 MySQL에 테이블이 생성되게 하는
public class User {

	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에 연결된 DB의 넘버링 전략 따라함
	// Oracle = 시퀀스 , MySQL = Auto_Increasement
	private int id;
	
	@Column(nullable = false, length = 30)
	private String username; //아이디
	
	@Column(nullable = false, length = 100) //암호화 할거니까 넉넉히
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	  
	@ColumnDefault("'user'")
	private String role; // admin, user, manager 등등
									  // Enum으로 도메인 설정하는 게 더 좋다.
	
	@CreationTimestamp //시간이 자동입력
	private Timestamp createDate;
	
}
