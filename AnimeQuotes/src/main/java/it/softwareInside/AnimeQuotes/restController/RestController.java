package it.softwareInside.AnimeQuotes.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.softwareInside.AnimeQuotes.models.AnimeQ;
import it.softwareInside.AnimeQuotes.services.AnimeQService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	AnimeQService animeQService;

	/**
	 * realizzo una chiamata ad una funzione che mi scrive tante citazioni in base
	 * al numero dato in input
	 */

	@GetMapping("/genera")
	public String findAllNSave(@RequestParam int count) {
		animeQService.findAllNSave(count);
		return "ho salvato " + (count - 1) + " citazioni";
	}

	@DeleteMapping("/del")
	public AnimeQ delete(@RequestParam("id") int id) {
		return animeQService.removeQuote(id);

	}

	@GetMapping("/API/Mostratutti")
	public Iterable<AnimeQ> showAll() {
		return animeQService.showAll();
	}

	@GetMapping("/DelALL")
	public String deleteAll() {
		try {
			animeQService.removeAll();
			return "Ho eliminato tutte le citazioni";
		} catch (Exception err) {
			err.printStackTrace();
			return "ERRORE DURANTE L'AZZERAMENTO DEL DB";
		}
	}
}
