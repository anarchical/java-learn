package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author YeYaqiao
 */
@Controller
public class MvcController {

    //配置视图解析器对应的地址（纯视图）
    //当有返回值时，以返回值拼接成的视图名为主
    //没有返回值则以 @RequestMapping 中的值拼接的视图名为主
    @RequestMapping("/view")
    public String view() {
        System.out.println("执行了 view 方法");
        return  "view";
    }

    //配置视图解析器对应的地址（视图和数据）
    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        //设置对应的视图名称，通过配置文件补齐后缀
        modelAndView.setViewName("modelAndView");
        //设置数据模型
        modelAndView.addObject("model", "modelValue");
        return modelAndView;
    }

    @RequestMapping("/model")
    //配置数据模型解析器（纯数据）tomcat7 及以下不支持
    @ResponseBody
    public String model() {
        return "model";
    }

}
