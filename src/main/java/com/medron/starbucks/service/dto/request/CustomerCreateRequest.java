package com.medron.starbucks.service.dto.request;

import com.medron.starbucks.constants.CustomerValidationConstant;
import com.medron.starbucks.service.dto.abstracts.CustomerRequest;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerCreateRequest implements CustomerRequest {

    @NotEmpty(message = CustomerValidationConstant.TC_NOT_BE_EMPTY)
    @NotNull(message = CustomerValidationConstant.TC_NOT_BE_NULL)
    @Max(value = 11,message = CustomerValidationConstant.TC_MUST_BE_VALID)
    @Min(value = 11,message = CustomerValidationConstant.TC_MUST_BE_VALID)
    private String nationalityId;
    @NotNull(message = CustomerValidationConstant.NAME_NOT_BE_NULL)
    @NotEmpty(message = CustomerValidationConstant.NAME_NOT_BE_EMPTY)
    private String firstName;
    @NotNull(message = CustomerValidationConstant.SURNAME_NOT_BE_NULL)
    @NotEmpty(message = CustomerValidationConstant.SURNAME_NOT_BE_EMPTY)
    private String lastName;
    @NotNull(message = CustomerValidationConstant.YEAR_NOT_BE_NULL)
    @NotEmpty(message = CustomerValidationConstant.YEAR_NOT_BE_EMPTY)
    private LocalDate dateOfBirth;
}
