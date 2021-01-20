package com.shunyi.ddd.core.gateway.ohs;


import com.shunyi.ddd.core.exceptions.ApplicationInfrastructureException;
import com.shunyi.ddd.core.exceptions.ApplicationValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author zhang
 * @create 2021-01-13 16:39
 */
public class Resources {
    private static Logger logger = Logger.getLogger(Resources.class.getName());

    private String requestType;
    private HttpStatus successfulStatus;
    private HttpStatus errorStatus;
    private HttpStatus failedStatus;

    private Resources(String requestType) {
        this.requestType = requestType;
    }

    public static Resources with(String requestType) {
        return new Resources(requestType);
    }

    public Resources onSuccess(HttpStatus status) {
        this.successfulStatus = status;
        return this;
    }

    public Resources onError(HttpStatus status) {
        this.errorStatus = status;
        return this;
    }

    public Resources onFailed(HttpStatus status) {
        this.failedStatus = status;
        return this;
    }

    public <T> ResponseEntity<T> execute(Supplier<T> supplier) {
        try {
            T entity = supplier.get();
            return new ResponseEntity<>(entity, successfulStatus);
        } catch (ApplicationValidationException ex) {
            logger.log(Level.WARNING, String.format("The request of %s is invalid", requestType));
            return new ResponseEntity<>(errorStatus);
        } catch (ApplicationDomainException ex) {
            logger.log(Level.WARNING, String.format("Exception raised %s REST Call", requestType));
            return new ResponseEntity<>(failedStatus);
        } catch (ApplicationInfrastructureException ex) {
            logger.log(Level.SEVERE, String.format("Fatal exception raised %s REST Call", requestType));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> execute(Runnable runnable) {
        try {
            runnable.run();
            return new ResponseEntity<>(successfulStatus);
        } catch (ApplicationValidationException ex) {
            logger.log(Level.WARNING, String.format("The request of %s is invalid", requestType));
            return new ResponseEntity<>(errorStatus);
        } catch (ApplicationDomainException ex) {
            logger.log(Level.WARNING, String.format("Exception raised %s REST Call", requestType));
            return new ResponseEntity<>(failedStatus);
        } catch (ApplicationInfrastructureException ex) {
            logger.log(Level.SEVERE, String.format("Fatal exception raised %s REST Call", requestType));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}