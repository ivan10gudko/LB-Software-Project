package project_z.demo.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project_z.demo.entity.TitleEntity.titleStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TitleDto {
 @Id
    private Integer titleId;
    private int apiTitleId;
    private String titleName;
    private float titleRating;
    private titleStatus status;
    private LocalDateTime createdAt;
}
