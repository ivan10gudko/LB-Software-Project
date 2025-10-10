package project_z.demo.services;

import java.util.Optional;
import java.util.UUID;

import project_z.demo.entity.UserEntity;

public interface UserService {
    public UserEntity createUser(UserEntity user);
    Optional<UserEntity> findOne(UUID id);
}
