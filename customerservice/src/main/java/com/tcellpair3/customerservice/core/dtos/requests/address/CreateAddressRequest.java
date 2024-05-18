package com.tcellpair3.customerservice.core.dtos.requests.address;

import com.tcellpair3.customerservice.entities.City;
import com.tcellpair3.customerservice.entities.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {


    private City city; //TO DO : TR de citylerin kontrolü için api?

    @NotBlank(message = "This field is required")
    private String district;

    @NotBlank(message = "This field is required")
    private String street;

    @NotBlank(message = "This field is required")
    private String houseFlatNumber;


    @NotBlank(message = "This field is required")
    private String addressDescription;


    private int customerId;
}