package com.suportapp.suportapp.repositories;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jakarta.persistence.*;
import com.suportapp.suportapp.models.Requests;

@Repository
public interface RequestsRepository extends JpaRepository<Requests, Long> {
}
