package com.example.springcloudclient.repo;

import com.example.springcloudclient.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {
}
