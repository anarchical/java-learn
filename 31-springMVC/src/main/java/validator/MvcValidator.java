package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vo.UserVO;

/**
 * @author YeYaqiao
 */
public class MvcValidator implements Validator {
    //判断数据类型是否匹配
    @Override
    public boolean supports(Class<?> aClass) {
        if (aClass== UserVO.class){
            System.out.println("UserVO Class");
            return true;
        }else {
            return false;
        }
    }
    //进行数据校验
    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors,"id","id is empty");
        ValidationUtils.rejectIfEmpty(errors,"name","name is empty");

    }
}
