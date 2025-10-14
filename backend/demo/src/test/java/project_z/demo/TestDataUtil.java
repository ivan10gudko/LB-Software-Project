package project_z.demo;

import java.util.ArrayList;
import java.util.UUID;

import project_z.demo.entity.TitleEntity;
import project_z.demo.entity.UserEntity;

public class TestDataUtil {
public static UserEntity createTestUserA(){
    UUID uuid1 = UUID.fromString("c91438ea-8288-4584-898b-c8a6c33a8e07");
return UserEntity.builder()
.id(uuid1)
.name("Genadiy")
.description("Natural")
.img(52)
.friendsList(new ArrayList<>()
).build();
}


public static TitleEntity createTestTitleA(final UserEntity user){
     
    return TitleEntity.builder()
    .titleId(1)
    .apiTitleId(1)
    .titleName("AOT")
    .titleRating(9)
    .status(TitleEntity.titleStatus.WATCHED)
    .userId(user.getId())
    .build();
}
}