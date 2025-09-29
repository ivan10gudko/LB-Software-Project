package project_z.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
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
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="user_id_sequence")
    @SequenceGenerator(name="user_id_sequence", sequenceName="user_id_sequence", allocationSize= 1)
    private int Id;
    private String name;
    private String description;
    private int img;
    @ElementCollection
    private List<String> friendsList;
    @OneToMany(cascade = CascadeType.ALL)
    
    private List<TitleEntity> watchList;


}
