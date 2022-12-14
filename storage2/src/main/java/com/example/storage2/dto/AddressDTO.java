package com.example.storage2.dto;

import com.example.storage2.model.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {
    private String location;

    public AddressDTO(Address address) {
        this.location = address.getLocation();
    }
}