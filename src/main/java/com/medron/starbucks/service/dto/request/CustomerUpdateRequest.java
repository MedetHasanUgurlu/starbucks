package com.medron.starbucks.service.dto.request;

import com.medron.starbucks.service.dto.abstracts.CustomerRequest;
import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerUpdateRequest implements CustomerRequest {
    private String nationalityId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

}
