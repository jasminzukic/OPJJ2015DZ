package hr.fer.zemris.java.tecaj.hw1;

/**
 * Ovaj razred predstavlja binarno stablo. Sadrži metode za ubacivanje u stablo,
 * ispis svih podataka inorder, ispis veličine stabla te provjeru sadržaja stabla.
 * @author saaffa
 *
 */
class ProgramStabla {
	
	/**
	 * Ovaj razred predstavlja jedan čvor u stablu. Ima dvije reference, na lijevo i desno
	 * dijete cvora, te sadrži podatak.
	 * @author saaffa
	 *
	 */
	static class CvorStabla {
		CvorStabla lijevi;
		CvorStabla desni;
		String podatak;
	}
	
	/**
	 * Glavni program koji provjerava ispravnost cijelog koda ProgramStabla
	 * @param args ne koristi se
	 */
	public static void main(String[] args) {
		CvorStabla cvor = null;
		
		cvor = ubaci(cvor, "Jasna");
		cvor = ubaci(cvor, "Ana");
		cvor = ubaci(cvor, "Ivana");
		cvor = ubaci(cvor, "Anamarija");
		cvor = ubaci(cvor, "Vesna");
		cvor = ubaci(cvor, "Kristina");

		System.out.println("Ispisujem stablo inorder:");
		ispisiStablo(cvor);
		
		int vel = velicinaStabla(cvor);
		System.out.println("Stablo sadrzi elemenata: " + vel);
		
		boolean pronaden = sadrziPodatak(cvor, "Ivana");
		System.out.println("Trazeni podatak je pronaden: " + pronaden);
	}
	
	/**
	 * Metoda koja provjerava sadrži li stablo traženi podatak
	 * @param korijen korijen stabla
	 * @param podatak podatak koji se traži
	 * @return istina ako sadrži, ne u suprotnom.
	 */
	static boolean sadrziPodatak(CvorStabla korijen, String podatak) {
		if(korijen == null) {
			return false;
		} else if(korijen.podatak == podatak) {
			return true;
		} else if(korijen.podatak.compareTo(podatak) < 0) {
			return sadrziPodatak(korijen.desni, podatak);
		} else {
			return sadrziPodatak(korijen.lijevi, podatak);
		}
	}
	
	/**
	 * Metoda za provjeru veličine stabla (koliko čvorova ima unutra). Rekurzija
	 * @param cvor trenutni čvor u stablu
	 * @return veličina stabla
	 */
	static int velicinaStabla(CvorStabla cvor) {
		if(cvor == null) {
			return 0;
		} else if(cvor.lijevi == null && cvor.desni == null) {
			return 1;
		} else {
			return velicinaStabla(cvor.lijevi) + 1 + velicinaStabla(cvor.desni);
		}
		
	}
	
	/**
	 * Metoda koja ubacuje novi čvor u stablo po abecedi.
	 * @param korijen korijen stabla
	 * @param podatak podatak novog čvora
	 * @return korijen stabla
	 */
	static CvorStabla ubaci(CvorStabla korijen, String podatak) {
		if(korijen == null) {
			korijen = new CvorStabla();
			korijen.podatak = podatak;
			return korijen;
		}
		CvorStabla cvor = korijen;
		while(cvor != null) {
			if(cvor.podatak.compareTo(podatak) == 0) {
				System.out.println("Stablo već ima ovaj podatak.");
				return korijen;
			} else if(cvor.podatak.compareTo(podatak) > 0) {
				if(cvor.lijevi == null) {
					cvor.lijevi = new CvorStabla();
					cvor.lijevi.podatak = podatak;
					break;
				}	
				cvor = cvor.lijevi;
			} else {
				if(cvor.desni == null) {
					cvor.desni = new CvorStabla();
					cvor.desni.podatak = podatak;
					break;
				}	
				cvor = cvor.desni;
			}
		}
		return korijen;
	}
	
	/**
	 * Metoda koja ispisuje podatke stabla inorder/abecedno
	 * @param cvor trenutni čvor koji se ispisuje
	 */
	static void ispisiStablo(CvorStabla cvor) {
		if(cvor == null) return;
		ispisiStablo(cvor.lijevi);
		System.out.println(cvor.podatak);
		ispisiStablo(cvor.desni);
	}
}