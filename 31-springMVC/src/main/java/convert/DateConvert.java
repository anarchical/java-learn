package convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author YeYaqiao
 * 自定义日期转换器
 * 在 springxml 进行配置
 */
public class DateConvert implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        System.out.println(s);
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
