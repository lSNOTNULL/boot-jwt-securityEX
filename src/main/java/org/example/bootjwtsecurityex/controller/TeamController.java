package org.example.bootjwtsecurityex.controller;

import lombok.RequiredArgsConstructor;
import org.example.bootjwtsecurityex.model.dto.TeamRequestDTO;
import org.example.bootjwtsecurityex.model.entity.Team;
import org.example.bootjwtsecurityex.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baseball/teams")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<List<Team>> findAllTeams(){
        List<Team> teamList = teamService.findAllTeams();
        return ResponseEntity.ok(teamList);
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody TeamRequestDTO dto) {
        Team team = teamService.saveTeam(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(team);
    }
}
