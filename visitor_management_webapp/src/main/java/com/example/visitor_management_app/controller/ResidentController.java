package com.example.visitor_management_app.controller;

import com.example.visitor_management_app.service.ResidentService;
import com.example.visitor_management_app.dto.AllPendingVisitsDTO;
import com.example.visitor_management_app.dto.VisitDto;
import com.example.visitor_management_app.enums.VisitStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resident")
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @PutMapping("actOnVisit/{id}")
    public ResponseEntity<String> actOnVisit(@PathVariable Long id, @RequestParam VisitStatus visitStatus){
        return ResponseEntity.ok(residentService.updateVisit(id,visitStatus));
    }


    @GetMapping("/pendingVisits")
    public ResponseEntity<List<VisitDto>> getPendingVisits(@RequestHeader Long userId){
        return ResponseEntity.ok(residentService.getPendingVisits(userId));
    }


    @GetMapping("/page-pendingVisits")
    public ResponseEntity<AllPendingVisitsDTO> getPagePendingVisits(@RequestHeader Long userId, @RequestParam Integer pageNo, @RequestParam Integer pageSize){
        return ResponseEntity.ok(residentService.getPendingVisitByPage(userId,pageNo,pageSize));
    }
}
