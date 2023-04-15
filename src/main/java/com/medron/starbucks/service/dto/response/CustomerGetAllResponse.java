package com.medron.starbucks.service.dto.response;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerGetAllResponse {
    private Long id;
    private String nationalityId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
