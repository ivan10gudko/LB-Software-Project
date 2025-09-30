package project_z.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class UserEntity {
    @Id
    private int Id;
    private String name;
    private String description;
    private int img;
    @ElementCollection
    private List<String> friendsList;
    @OneToMany(cascade = CascadeType.ALL)
    
    private List<TitleEntity> watchList;


}
