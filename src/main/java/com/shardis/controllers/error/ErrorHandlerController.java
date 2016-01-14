package com.shardis.controllers.error;

import com.google.common.collect.Lists;
import com.shardis.dto.error.ServerErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tomasz Kucharzyk
 */

@Slf4j
@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public void procesHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex) {
        log.debug(ex.getMessage(),ex);
    }

    @ExceptionHandler(ClientAbortException.class)
    public void processClientAbortException(ClientAbortException ex) {
        log.debug(ex.getMessage(),ex);
        log.debug("client disconected");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ServerErrorDTO processException(Exception ex) {
        log.error(ex.getMessage(),ex);
        return new ServerErrorDTO(ex.getClass().getCanonicalName(), ex.getMessage(), Lists.newArrayList());
    }

}
