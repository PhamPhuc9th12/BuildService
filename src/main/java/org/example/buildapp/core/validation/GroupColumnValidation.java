package org.example.buildapp.core.validation;

import org.example.buildapp.core.domain.constant.ErrorCode;

import java.util.regex.Pattern;

public class GroupColumnValidation {

    public static void checkSpecialCharacter(String checkString){
        String regexCheck = "[^a-zA-Z0-9 ]";
        if(Boolean.TRUE.equals(Pattern.matches(regexCheck,checkString))){
            throw new RuntimeException(ErrorCode.IS_SPECIAL_CHARACTER);
        }
    }
}
