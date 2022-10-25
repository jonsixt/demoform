package com.jonsix.demoform.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SavedRequestRepository extends JpaRepository<SavedRequest, Long> {

    List<SavedRequest> findTop10ByCreatedNotNullOrderByCreatedDesc();

}
