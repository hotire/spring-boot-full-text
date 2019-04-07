package com.googlecode.hotire.controller;

import com.googlecode.hotire.model.ResponseMessage;
import com.googlecode.hotire.service.FullTextService;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequestMapping("/api/v1/fulltext")
@RestController
public class FullTextController {

	@Autowired
  private FullTextService fullTextService;

	@GetMapping("/{text}")
	public ResponseEntity parse(@Validated @NotNull @PathVariable String text) {
		return ResponseEntity.ok().body(fullTextService.parse(text));
	}
}
