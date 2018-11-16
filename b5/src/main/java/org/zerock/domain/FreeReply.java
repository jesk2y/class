package org.zerock.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.description.field.FieldDescription.InDefinedShape;

@Getter
@Setter
@Entity
@ToString(exclude="board")
@Table(indexes = {@Index(unique=false, columnList="board_bno")})
public class FreeReply {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rno;
	
	private String reply;
	private String replyer;
	
	@CreationTimestamp
	private LocalDateTime replyDate;
	
	@UpdateTimestamp
	private LocalDateTime replyUpdate;
	
	@JsonIgnore
	//연결고리 끊기
	@ManyToOne(fetch=FetchType.LAZY)
	//lazy로 걸어두면 쿼리 한번만 날라감
	private FreeBoard board;
}
