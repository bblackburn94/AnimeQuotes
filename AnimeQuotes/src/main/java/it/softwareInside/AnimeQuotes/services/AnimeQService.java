package it.softwareInside.AnimeQuotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.softwareInside.AnimeQuotes.models.AnimeQ;
import it.softwareInside.AnimeQuotes.repository.AnimeQRepository;

@Service
public class AnimeQService {

	@Autowired
	AnimeQRepository animeQRepository;

	public void findAllNSave(int count) {

		RestTemplate restTemplate = new RestTemplate();
		for (int i = 0; i < count; i++) {
			try {
				ResponseEntity<AnimeQ> response = restTemplate.getForEntity("https://animechan.vercel.app/api/random",
						AnimeQ.class);
				AnimeQ quote = response.getBody();
				if (quote != null) {
					animeQRepository.save(quote);
				}
			} catch (Exception err) {
				err.printStackTrace();
			}
		}
	}

	public AnimeQ removeQuote(int id) {
		AnimeQ animeQ = animeQRepository.findById(id).get();
		animeQRepository.deleteById(id);
		return animeQ;
	}

	public Iterable<AnimeQ> showAll() {
		return animeQRepository.findAll();
	}

	public void removeAll() {
		animeQRepository.deleteAll();
	}

}
