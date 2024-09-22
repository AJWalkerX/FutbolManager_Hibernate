package com.ajwalker.dto.response;

import lombok.*;

@Data
@Builder
public class ManagerResponseDTO {
    private String fullname;
    private Integer age;
    private String username;
}
