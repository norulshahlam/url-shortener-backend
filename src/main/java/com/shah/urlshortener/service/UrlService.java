package com.shah.urlshortener.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.shah.urlshortener.entity.Url;
import com.shah.urlshortener.repository.UrlRepository;
import com.shah.urlshortener.request.UrlCreate;

@Service
public class UrlService {

	private UrlRepository urlRepository;

	@Autowired
	public UrlService(UrlRepository urlRepository) {
		this.urlRepository = urlRepository;
	}

	public ResponseEntity<?> createRedirect(UrlCreate urlCreate) throws MalformedURLException, IOException {

		System.out.println("---- " + urlCreate.getUrl());
		// check if url is empty
		if (urlCreate.getUrl().isEmpty())
			return new ResponseEntity<Object>("Empty URL", HttpStatus.BAD_REQUEST);

		// check if alias is empty
		if (urlCreate.getAlias().isEmpty())
			return new ResponseEntity<Object>("Empty alias", HttpStatus.BAD_REQUEST);

		// check if url is valid
		try {
			new URL(urlCreate.getUrl()).openStream().close();
		} catch (Exception e) {
			return new ResponseEntity<Object>("Invalid URL", HttpStatus.BAD_REQUEST);
		}

		// check if alias already exists
		if (urlRepository.existsByAlias(urlCreate.getAlias())) {
			return new ResponseEntity<Object>("Alias already exists", HttpStatus.CONFLICT);
		}

		// save if validation pass
		Url url = new Url(urlCreate.getAlias(), urlCreate.getUrl());
		Url postSaveRedirect = urlRepository.save(url);
		System.out.println("Url & alias saved: " + postSaveRedirect);

		return new ResponseEntity<Object>("URL shortened!", HttpStatus.OK);
	}

	public ResponseEntity<?> getRedirect(String alias) throws URISyntaxException {
		URI uri;
		Url url = urlRepository.findByAlias(alias);
		try {
			uri = new URI(url.getUrl());
		} catch (Exception e) {
			return new ResponseEntity<Object>("Alias not found", HttpStatus.BAD_REQUEST);
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(uri);
		System.out.println("We're redirecting here!" + url);
		return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
	}

	public ResponseEntity<?> getAllShortenedUrls() {
		return new ResponseEntity<Object>(urlRepository.findAllByOrderByIdDesc(), HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(Long id) {
		System.out.println("deleting.....id: " + id);
		urlRepository.deleteById(id);
		return new ResponseEntity<Object>("Alias Deleted!", HttpStatus.OK);
	}
}
