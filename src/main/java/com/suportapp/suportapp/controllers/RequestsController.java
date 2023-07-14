package com.suportapp.suportapp.controllers;

import com.suportapp.suportapp.models.Requests;
import com.suportapp.suportapp.services.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requests")
public class RequestsController {

    @Autowired
    private RequestsService requestsService;

    @GetMapping
    public List<Requests> getRequests() {
        return this.requestsService.getRequests();
    }

    @PostMapping
    public Requests saveRequests(@RequestBody Requests requests) {
        return this.requestsService.saveRequests(requests);
    }

    @GetMapping(path = "/{id}")
    public Optional<Requests> getRequestsById(@PathVariable Long id) {
        return this.requestsService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Requests updateRequestsById(@RequestBody Requests request, @PathVariable("id") Long id) {
        return this.requestsService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean deleted = this.requestsService.deleteRequests(id);

        if (deleted) {
            return "Requests with id " + id + " deleted";
        } else {
            return "Error deleting Requests with id " + id;
        }
    }
}