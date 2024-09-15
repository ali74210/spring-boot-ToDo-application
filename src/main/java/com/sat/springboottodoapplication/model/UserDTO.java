package com.sat.springboottodoapplication.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String email;
}
