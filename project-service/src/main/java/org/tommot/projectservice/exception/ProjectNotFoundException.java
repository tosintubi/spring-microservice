package org.tommot.projectservice.exception;

public class ProjectNotFoundException extends  RuntimeException{
    public ProjectNotFoundException(String message) {
        super(message);
    }
}
