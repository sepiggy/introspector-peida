package cn.sepiggy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private long userId;
    private String userName;
    private int age;
    private String emailAddress;

    private Date birthday = new Date();

}
