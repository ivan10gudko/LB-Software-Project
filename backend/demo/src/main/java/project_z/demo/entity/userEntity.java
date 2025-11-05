package project_z.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserEntity {
    @Id
    private UUID userId;
    private String name;
    private String description;
    private String img;
    @ManyToMany(mappedBy = "members")
    private List<RoomEntity> rooms = new ArrayList<>();
    private LocalDateTime createdAt;
}
