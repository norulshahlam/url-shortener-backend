package com.shah.urlshortener.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shah.urlshortener.request.UrlCreate;
import com.shah.urlshortener.service.UrlService;

@RestController@CrossOrigin(origins = "http://localhost:3000")
public class UrlRedirect {

	private UrlService urlService;

	@Autowired
	public UrlRedirect(UrlService urlService) {
		this.urlService = urlService;
	}

	@GetMapping("/{alias}")
	public ResponseEntity<?> getRedirect(@PathVariable String alias) throws URISyntaxException {
		return urlService.getRedirect(alias);
	}

	@PostMapping("/")
	public ResponseEntity<?> createRedirect(@Valid @RequestBody UrlCreate urlCreate)
			throws MalformedURLException, IOException {
		return urlService.createRedirect(urlCreate);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllShortenedUrls() {
		return urlService.getAllShortenedUrls();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteByAlias(@PathVariable Long id) {
		return urlService.deleteById(id);
	}
}
