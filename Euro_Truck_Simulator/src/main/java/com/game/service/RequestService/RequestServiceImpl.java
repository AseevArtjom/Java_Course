package com.game.service.RequestService;

import com.game.dao.RequestRepository;
import com.game.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService
{
    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private RequestRandomizer requestRandomizer;

    @Override
    public void save(Request request) { requestRepository.save(request); }

    @Override
    public int[] saveRequestsList(List<Request> requests) {
        requestRepository.saveAll(requests);
        return new int[0];
    }

    @Override
    public void update(Request request) { requestRepository.save(request); }

    @Override
    public void delete(Request request) { requestRepository.delete(request); }

    @Override
    public void deleteAll() { requestRepository.deleteAll(); }

    @Override
    public List<Request> findAll() { return requestRepository.findAll(); }

    @Override
    public List<Request> findByProgressFalse() {
        return requestRepository.findByProgressFalse();
    }

    @Override
    public List<Request> findByProgressTrue() {
        return requestRepository.findByProgressTrue();
    }

    @Override
    public void initializeRequests(){
        List<Request> requestsInDb = requestRepository.findAll();
        if (requestsInDb.isEmpty()) {
            for (int i = 0; i < 10; i++) {
                Request newRequest = requestRandomizer.generateRandomRequest();
                requestRepository.save(newRequest);
            }
        }
    }
}
