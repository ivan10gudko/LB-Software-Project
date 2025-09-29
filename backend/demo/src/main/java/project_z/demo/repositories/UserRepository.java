package project_z.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project_z.demo.entity.UserEntity;
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
