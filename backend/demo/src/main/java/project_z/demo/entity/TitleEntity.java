package project_z.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name="titles")
@JsonIgnoreProperties(ignoreUnknown=true)
public class TitleEntity { 
    public enum titleStatus {
    WATCHED,
    FAVOURITE,
    PLANNED
}
    @Id
    private Integer titleId;
    private int apiTitleId;
    private String titleName;
    private float titleRating;
    @Enumerated(EnumType.STRING)
    private titleStatus status;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @CreatedDate
    @Column(nullable=false, updatable=false)
    private LocalDateTime createdAt;
}

