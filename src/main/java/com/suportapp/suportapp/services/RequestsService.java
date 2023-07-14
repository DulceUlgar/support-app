package com.suportapp.suportapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.suportapp.suportapp.models.Requests; // Importa la clase Requests
import com.suportapp.suportapp.repositories.RequestsRepository;

@Service
public class RequestsService {
    @Autowired
    private RequestsRepository requestsRepository;

    public ArrayList<Requests> getRequests() {
        return (ArrayList<Requests>) requestsRepository.findAll();
    }

    public Requests saveRequests(Requests requests) {
        return requestsRepository.save(requests);
    }

    public Optional<Requests> getById(Long id) {
        return requestsRepository.findById(id);
    }

    public Requests updateById(Requests updatedRequest, Long id) {
        if (requestsRepository.existsById(id)) {
            Requests request = requestsRepository.findById(id).get();
            request.setName(updatedRequest.getName());
            request.setDate(updatedRequest.getDate());
            request.setTopic(updatedRequest.getTopic());
            request.setDescription(updatedRequest.getDescription());
            return requestsRepository.save(request);
        } else {
            throw new RuntimeException("Requests not found with id: " + id);
        }
    }

    public boolean deleteRequests(Long id) {
        try {
            requestsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("Error deleting Requests with ID: " + id);
            e.printStackTrace();
            return false;
        }
    }
}
