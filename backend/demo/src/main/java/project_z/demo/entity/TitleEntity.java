package project_z.demo.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name = "img")
    private String img;
    @Enumerated(EnumType.STRING)
    private titleStatus status;
    
    @Column(name = "user_id" )
    private UUID userId;
    private LocalDateTime createdAt;
}

