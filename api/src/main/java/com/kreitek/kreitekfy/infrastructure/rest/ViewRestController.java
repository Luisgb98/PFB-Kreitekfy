package com.kreitek.kreitekfy.infrastructure.rest;

import com.kreitek.kreitekfy.application.dto.ViewDTO;
import com.kreitek.kreitekfy.application.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ViewRestController {

    private final ViewService viewService;

    @Autowired
    public ViewRestController(ViewService viewService) {
        this.viewService = viewService;
    }

    @CrossOrigin
    @GetMapping(value = "/views", produces = "application/json")
    ResponseEntity<List<ViewDTO>> getAllViews() {
        List<ViewDTO> viewDTOS = this.viewService.getAllViews();
        return new ResponseEntity<>(viewDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/song/{songId}/views", produces = "application/json")
    ResponseEntity<List<ViewDTO>> getViewsBySongId(@PathVariable Long songId) {
        List<ViewDTO> viewDTOS = this.viewService.getViewsBySongId(songId);
        return new ResponseEntity<>(viewDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/views", produces = "application/json", consumes = "application/json")
    ResponseEntity<ViewDTO> saveView(@RequestBody ViewDTO viewDTO) {
        ViewDTO viewSaved = this.viewService.saveView(viewDTO);
        return new ResponseEntity<>(viewSaved, HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping(value = "/view/{viewId}")
    ResponseEntity<?> deleteView(@PathVariable Long viewId) {
        this.viewService.deleteView(viewId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
