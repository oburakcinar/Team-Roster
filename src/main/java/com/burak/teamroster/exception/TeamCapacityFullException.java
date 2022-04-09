package com.burak.teamroster.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

//this exception is used for restricting team roster size
public class TeamCapacityFullException extends RuntimeException implements GraphQLError {

    public TeamCapacityFullException(String message) {
        super(message);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }
}
