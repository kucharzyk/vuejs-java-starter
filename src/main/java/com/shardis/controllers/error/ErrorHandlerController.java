package com.shardis.controllers.error;

import com.google.common.collect.Lists;
import com.shardis.dto.error.ServerErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Tomasz Kucharzyk
 */

@Slf4j
@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ServerErrorDTO processConcurencyError(Exception ex) {
        return new ServerErrorDTO(ex.getClass().getCanonicalName(), ex.getMessage(), Lists.newArrayList());
    }


}
