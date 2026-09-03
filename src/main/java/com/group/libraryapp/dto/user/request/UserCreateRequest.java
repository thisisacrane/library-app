package com.group.libraryapp.dto.user.request;

import lombok.Getter;

@Getter
public class UserCreateRequest { //유저의 요청 정보를 받는 클래스입니다.
    private String name;
    private Integer age;
}
