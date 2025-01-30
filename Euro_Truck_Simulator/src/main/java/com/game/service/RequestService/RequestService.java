package com.game.service.RequestService;

import com.game.model.Driver;
import com.game.model.Request;

import java.io.IOException;
import java.util.List;

public interface RequestService
{
    void save(Request request) ;

    int[] saveRequestsList(List<Request> requests) ;

    void update(Request request) ;

    void delete(Request request) ;

    List<Request> findAll() ;

    void deleteAll() ;

    List<Request> findByProgressFalse();

    List<Request> findByProgressTrue();

    void initializeRequests();
}
