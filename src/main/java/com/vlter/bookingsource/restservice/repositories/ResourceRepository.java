package com.vlter.bookingsource.restservice.repositories;

import com.vlter.bookingsource.restservice.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tereshchenko on 21.02.2021.
 */

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer>{
    Resource findByResourceEquals(String resource);
}
