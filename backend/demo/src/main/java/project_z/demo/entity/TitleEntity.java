package project_z.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name="titles")

public class TitleEntity { public enum titleStatus {
    WATCHED,
    FAVOURITE,
    PLANNED
}
    @Id
    private int titleId;
    private String titleName;
    private float titleRating;
    @Enumerated(EnumType.STRING)
    private titleStatus status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id" )
    private UserEntity user;
}

