package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;


//Xác định thành phố: lấy theo name trong thẻ input

//xác định múi giờ:
//xác định thời gian cụ thể của 1 thành phố cụ thể
//tính thời gian của thành phố muốn lấy
@Controller
public class TimeOfCity {

    @RequestMapping(value = "/Time", method = RequestMethod.GET)
    public String getTimeOfCity(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "/timezone";
    }


}
