package com.burak.teamroster.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PlayerBadRequestException extends RuntimeException implements GraphQLError {

    private String invalidField;

    public PlayerBadRequestException(String message, String invalidField) {
        super(message);
        this.invalidField = invalidField;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }

    //when playerbadrequestexception is thrown, the invalid field that causes the exception will be shown
    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("invalidField", invalidField);
    }
}
