package com.vvinnyk.isbn.exception;

import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 11/30/2016.
 */
public class XmlParserException extends BusinessException {
    /**
     * @param summary  summaty information for user.
     * @param details  detailed information for user.
     * @param metadata detailed information for developers.
     */
    public XmlParserException(String summary, String details, List<String> metadata) {
        super(summary, details, metadata);
    }
}
