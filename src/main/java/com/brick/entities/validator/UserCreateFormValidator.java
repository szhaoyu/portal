package com.brick.entities.validator;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.brick.entities.UserCreateForm;
import com.brick.service.UserService;
import com.brick.util.RegexValidator;

@Component
@Slf4j
public class UserCreateFormValidator implements Validator {

    private final UserService userService;

    @Resource(name="mobileValidator")
    RegexValidator   mobileValidator;
    
    @Resource(name="emailValidator")
    RegexValidator   emailValidator;

    @Autowired
    public UserCreateFormValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        log.debug("Validating: " + target);
        UserCreateForm form = (UserCreateForm) target;
        validatePasswords(errors, form);
        validateEmail(errors, form);
    }

    private void validatePasswords(Errors errors, UserCreateForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    //通过邮件注册
    private void validateEmail(Errors errors, UserCreateForm form) {
    	String dataString=form.getEmail();
    	//check if phone number: 11位
    	if( emailValidator.validate(dataString) == false ) 
    		errors.reject("email.invalid","email address invalid");
    	
        if (userService.getUserByEmail(form.getEmail()).isPresent()) {
            errors.reject("email.exists", "User with this email already exists");
        }
    }

}
