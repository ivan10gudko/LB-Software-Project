package project_z.demo;

import java.util.ArrayList;

import project_z.demo.entity.UserEntity;

public class TestDataUtil {
public static UserEntity createTestUserA(){
return UserEntity.builder()
.Id(1)
.name("Genadiy")
.description("Natural")
.img(52)
.friendsList(new ArrayList<>())
.watchList(
    new ArrayList<>()
).build();
}

}
