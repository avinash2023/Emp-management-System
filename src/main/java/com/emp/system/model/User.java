package com.emp.system.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User {
    private String userId;
    private String userName;
    private String email;
}
