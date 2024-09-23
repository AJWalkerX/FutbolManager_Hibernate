package com.ajwalker.dto.request;

import lombok.*;


@Getter
@Setter
@Builder
public class ManagerSaveRequestDTO {
    private String fullname;
    private Integer age;
    private String username;
    private String password;
}