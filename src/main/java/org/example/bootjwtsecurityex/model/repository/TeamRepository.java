package org.example.bootjwtsecurityex.model.repository;

import org.example.bootjwtsecurityex.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {
}
