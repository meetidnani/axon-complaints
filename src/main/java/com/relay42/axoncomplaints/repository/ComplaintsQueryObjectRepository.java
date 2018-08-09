package com.relay42.axoncomplaints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relay42.axoncomplaints.domain.ComplaintsQueryObject;

@Repository
public interface ComplaintsQueryObjectRepository extends JpaRepository<ComplaintsQueryObject, String>{

}
