package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vo.UserVO;

import javax.validation.Valid;

/**
 * @author YeYaqiao
 */
@Controller
@RequestMapping("/validator")
public class ValidatorController {

    @GetMapping("/validation")
    @ResponseBody
    public String ValidationUser(@Validated @RequestBody UserVO userVO, BindingResult bindingResult) {
        System.out.println(userVO);
        if (bindingResult.hasErrors()) {
            return "errors";
        }
        return "success";
    }

    @GetMapping("/valid")
    @ResponseBody
    public String ValidatedUser(@Valid @RequestBody UserVO userVO, BindingResult bindingResult) {
        System.out.println(userVO);
        if (bindingResult.hasErrors()) {
            return "errors";
        }
        return "success";
    }
}
