package com.example.validator.vo;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class VLoginReqValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(VLoginReq.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        VLoginReq v = (VLoginReq) target;
        String username = v.getUsername();
    }
}
