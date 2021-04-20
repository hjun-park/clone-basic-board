package com.clone.board.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // 테이블로 매핑하지 않고 자식 클래스에게 매핑정보 상속 위함
@EntityListeners(AuditingEntityListener.class)  // JPA에게 해당 Entity는 Auditing 기능 활성 알림
public abstract class TimeEntity {
    @CreatedDate            // 엔티티가 처음 저장되는 생성일 주입 어노테이션
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate       // 수정일자를 주입하는 어노테이션
    private LocalDateTime modifiedDate;
}
