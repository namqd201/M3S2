package com.bt.m3s2.repositories;

import com.bt.m3s2.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepo extends JpaRepository<Task, Integer> {
}
