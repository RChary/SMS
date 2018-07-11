package com.school.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static Long getDate(String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime dateTime = LocalDateTime.now();
        String s = dateTime.format(formatter);
        return Long.parseLong(s);
    }
}
