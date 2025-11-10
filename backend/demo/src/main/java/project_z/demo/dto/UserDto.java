package project_z.demo.dto;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private UUID userId;
    private String name;
    private String nameTag;
    private String description;
    private int img;
    private LocalDateTime createdAt;
    private List<UserDto> watchList;
}
