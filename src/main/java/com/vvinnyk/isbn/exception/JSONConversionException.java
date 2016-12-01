package com.vvinnyk.isbn.exception;

import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 12/1/2016.
 */
public class JSONConversionException extends BusinessException {
    /**
     * @param summary  summaty information for user.
     * @param details  detailed information for user.
     * @param metadata detailed information for developers.
     */
    public JSONConversionException(String summary, String details, List<String> metadata) {
        super(summary, details, metadata);
    }
}
