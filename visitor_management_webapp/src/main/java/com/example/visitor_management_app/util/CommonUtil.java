package com.example.visitor_management_app.util;

import com.example.visitor_management_app.entity.Address;
import com.example.visitor_management_app.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

    public Address convertAddressDTOT(AddressDto addressDto){
        Address address = Address.builder()
                .line1(addressDto.getLine1())
                .line2(addressDto.getLine2())
                .city(addressDto.getCity())
                .pincode(addressDto.getPincode())
                .build();
        return address;
    }
}
