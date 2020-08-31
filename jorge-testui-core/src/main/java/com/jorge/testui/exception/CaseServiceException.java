/**
 * jorge-testui-parent
 * <p>
 * Copyright 2019 Acooly.cn, Inc. All rights reserved.
 *
 * @author zhike
 * @date 2019-07-19 10:07
 */
package com.jorge.testui.exception;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author zhike
 * @date 2019-07-19 10:07
 */
@Slf4j
public class CaseServiceException extends RuntimeException{

    /** UID */
    private static final long serialVersionUID = 788548256305224364L;

    public CaseServiceException() {
        super();
    }

    /**
     * @param message
     * @param cause
     */
    public CaseServiceException(String message, Throwable cause) {
        super(message, cause);
    }


    /**
     * @param message
     */
    public CaseServiceException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public CaseServiceException(Throwable cause) {
        super(cause);
    }
}
