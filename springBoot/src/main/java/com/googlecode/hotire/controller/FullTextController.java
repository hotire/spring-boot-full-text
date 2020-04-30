package com.googlecode.hotire.controller;

import com.googlecode.hotire.model.BaseMessage;
import com.googlecode.hotire.service.FullTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;


@RequestMapping("/api/v1/fulltext")
@RestController
@RequiredArgsConstructor
public class FullTextController {
	private final FullTextService fullTextService;

	@GetMapping("/{text}")
	public ResponseEntity<BaseMessage> parse(@Validated @NotNull @PathVariable final String text) {
		return ResponseEntity.ok().body(fullTextService.parse(text));
	}
}
