package it.softwareInside.AnimeQuotes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class AnimeQ {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
		
	private String anime;
	
	
	private String character;
	private String quote;


	
	public AnimeQ(String anime, String character, String quote) {
		setAnime(anime);
		setCharacter(character);
		setQuote(quote);

	}

}
