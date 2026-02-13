package de.o.le.termite.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.13
 */
public class TimeUtils {

    /**
     * Returns the current timestamp in format {@code yyyy-MM-dd HH:mm:ss}.
     *
     * @return
     */
    public static String getCurrentTimeStamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
