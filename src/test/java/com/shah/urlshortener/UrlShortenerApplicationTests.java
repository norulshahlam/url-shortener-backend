package com.shah.urlshortener;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.shah.urlshortener.entity.Url;
import com.shah.urlshortener.repository.UrlRepository;

@SpringBootTest
class UrlShortenerApplicationTests {

	@Autowired
	private UrlRepository urlRepository;

	@Test
	void shortenUrl() {
		Url url = new Url("tutorials", "https://www.youtube.com/watch?v=Geq60OVyBPg&t=1103s");
		Url url2 = urlRepository.save(url);
		boolean expected = urlRepository.existsById(url.getId());
		assertThat(expected).isTrue();
		urlRepository.deleteById(url2.getId());
	}

	@Test
	void contextLoads() {
	}
}
