package it.softwareInside.AnimeQuotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.softwareInside.AnimeQuotes.models.AnimeQ;

public interface AnimeQRepository extends JpaRepository<AnimeQ, Integer> {

}
