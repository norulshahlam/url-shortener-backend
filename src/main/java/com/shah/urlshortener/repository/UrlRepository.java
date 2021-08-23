package com.shah.urlshortener.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shah.urlshortener.entity.Url;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

	Url findByAlias(String alias);

	Boolean existsByAlias(String alias);

	void deleteById(Long id);
	
	List<Url> findAllByOrderByIdDesc();
} 