package com.example.validator;

import com.example.validator.vo.VLoginReq;
import com.example.validator.vo.VLoginReqValidator;
import com.example.validator.vo.VUserReq;
import com.example.validator.vo.VUserReqValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope
public class UserController {
    @Autowired
    private VLoginReqValidator vLoginReqValidator;

    @Autowired
    private VUserReqValidator vUserReqValidator;

    /**
     * 狗日，同时绑定两个校验器，报错。不知道啥子原因。
     * @param vUserReq
     * @return
     */
//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.addValidators(vLoginReqValidator,vUserReqValidator);
//    }

    @PostMapping("/save")
    public Long save(@RequestBody @Valid  VUserReq vUserReq, BindingResult bindingResult) {
        vUserReqValidator.validate(vUserReq, bindingResult);
        log.debug(">>>>vUserReq:" + vUserReq.toString());

        return 0L;
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid VLoginReq vLoginReq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ddddd";
        }
        vLoginReqValidator.validate(vLoginReq, bindingResult);
        log.debug(">>>>vLoginReq:" + vLoginReq.toString());

        return "abc";
    }


}
