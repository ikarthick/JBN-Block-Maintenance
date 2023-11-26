package com.jbn.block.maintenance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class BlockMaintenanceGenericException extends RuntimeException {

    public BlockMaintenanceGenericException() {
        super();
    }

    public BlockMaintenanceGenericException(String message) {
        super(message);
    }

    public BlockMaintenanceGenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlockMaintenanceGenericException(Throwable cause) {
        super(cause);
    }
}
