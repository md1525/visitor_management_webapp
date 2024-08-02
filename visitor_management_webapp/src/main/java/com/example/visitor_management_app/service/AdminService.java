package com.example.visitor_management_app.service;

import com.example.visitor_management_app.dto.AddressDto;
import com.example.visitor_management_app.dto.UserDto;
import com.example.visitor_management_app.entity.Address;
import com.example.visitor_management_app.entity.Flat;
import com.example.visitor_management_app.entity.User;
import com.example.visitor_management_app.enums.UserStatus;
import com.example.visitor_management_app.repo.FlatRepo;
import com.example.visitor_management_app.repo.UserRepo;
import com.example.visitor_management_app.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FlatRepo flatRepo;

    @Autowired
    private CommonUtil commonUtil;


    public Long createUser(UserDto userDto){

        AddressDto addressDto = userDto.getAddress();
        Address address = commonUtil.convertAddressDTOT(addressDto);
        Flat flat = null;
        if(userDto.getFlatNo() != null){
            flat = flatRepo.findByNumber(userDto.getFlatNo());
        }
        User user = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .role(userDto.getRole())
                .idNumber(userDto.getIdNumber())
                .phone(userDto.getPhone())
                .flat(flat)
                .address(address)
                .status(UserStatus.ACTIVE)
                .build();
        user = userRepo.save(user);
        return user.getId();
    }

}
