package com.example.validator.vo;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class VUserReqValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(VUserReq.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        VUserReq vUserReq = (VUserReq) target;
        String pwd = vUserReq.getPassword();
        if ("".equals(pwd)) {
            System.out.println(">>>>>pwd:");
        }
    }
}
