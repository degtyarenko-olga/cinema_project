package com.noirix.exception;

public class NoSuchEntityException extends RuntimeException {
    private String customMessage;
    private Integer errorCode;
    private String exceptionId;

    public NoSuchEntityException(String customMessage, Integer errorCode, String exceptionId) {
        this.customMessage = customMessage;
        this.errorCode = errorCode;
        this.exceptionId = exceptionId;
    }

    @Override
    public String toString() {
        return "NoSuchEntityException{" +
                "customMessage='" + customMessage + '\'' +
                ", errorCode=" + errorCode +
                ", exceptionId='" + exceptionId + '\'' +
                "} " + super.toString();
    }
}