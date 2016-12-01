package com.vvinnyk.isbn.exception;

import java.util.List;

/**
 * @author Vladyslav_Vinnyk on 11/30/2016.
 */
public class BusinessException extends RuntimeException {
    private final String summary;
    private final String details;
    private final List<?> metadata;

    /**
     * @param summary  summaty information for user.
     * @param details  detailed information for user.
     * @param metadata detailed information for developers.
     */
    public BusinessException(String summary, String details, List<?> metadata) {
        super(summary);
        this.summary = summary;
        this.details = details;
        this.metadata = metadata;
    }

    /**
     * @return summary.
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @return details.
     */
    public String getDetails() {
        return details;
    }

    /**
     * @return metadata.
     */
    public List<?> getMetadata() {
        return metadata;
    }
}
