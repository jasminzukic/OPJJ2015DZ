package hr.fer.zemris.java.tecaj.hw1;


/**
 * Osnovni program koji radi sa listama. Sadrži metode za ispis veličine liste, za sortiranje,
 * za dodavanje čvorova na početak liste i ispis.
 * @author saaffa
 *
 */
class ProgramListe {
	
	/**
	 * Objekt koji predstavlja čvor u listi. Ima referencu na sljedeći cvor te sadržajni podatak
	 * @author saaffa
	 *
	 */
	static class CvorListe {
		CvorListe sljedeci;
		String podatak;
	}
	
	/**
	 * Glavni program koji izvršava jedan primjer liste.
	 * @param args ne korisiti se
	 */
	public static void main(String[] args) {
		CvorListe cvor = null;
		
		cvor = ubaci(cvor, "Jasna");
		cvor = ubaci(cvor, "Basna");
		cvor = ubaci(cvor, "Glasna");
		cvor = ubaci(cvor, "Krasna");
		cvor = ubaci(cvor, "Ana");
		cvor = ubaci(cvor, "Ivana");
		
		System.out.println("Ispisujem listu uz originalni poredak:");
		ispisiListu(cvor);
		
		cvor = sortirajListu(cvor);
		
		System.out.println("Ispisujem listu nakon sortiranja:");
		ispisiListu(cvor);
		
		int vel = velicinaListe(cvor);
		System.out.println("Lista sadrzi elemenata: " + vel);
	}
	
	/**
	 * Metoda koja ispisuje veličinu zadane liste 
	 * @param cvor prvi čvor u listi
	 * @return veličina liste
	 */
	static int velicinaListe(CvorListe cvor) {
		int velicina = 0;
		while(cvor != null) {
			velicina++;
			cvor = cvor.sljedeci;
		}
		return velicina;
	}
	
	/**
	 * Metoda koja ubacuje novi cvor na pocetak liste
	 * @param prvi početni čvor liste
	 * @param podatak podatak novog čvora
	 * @return početni čvor liste
	 */
	static CvorListe ubaci(CvorListe prvi, String podatak) {
		CvorListe novi = new CvorListe();
		novi.podatak = podatak;
		novi.sljedeci = prvi;
		return novi;
	}
	
	/**
	 * Metoda koja ispisuje sve podatke u listi 
	 * @param cvor prvi čvor u listi
	 */
	static void ispisiListu(CvorListe cvor) {
		while(cvor != null) {
			System.out.print(cvor.podatak + ", ");
			cvor = cvor.sljedeci;
		}
		System.out.println("\n");
	}
	
	/**
	 * Metoda koja sortira zadanu listu
	 * @param cvor prvi čvor u listi
	 * @return prvi čvor u listi nakon sortiranja
	 */
	static CvorListe sortirajListu(CvorListe cvor) {
		if(cvor == null) {
			return cvor;
		}
		CvorListe privremeniCvor = new CvorListe();
		CvorListe treciUZamjeni = new CvorListe();
		boolean biloZamjene = true;
		
		while(biloZamjene) {
			privremeniCvor = cvor;
			biloZamjene = false;
			while(privremeniCvor.sljedeci != null) {
				if(privremeniCvor.podatak.compareTo(privremeniCvor.sljedeci.podatak) > 0) {
					
					treciUZamjeni.podatak = privremeniCvor.podatak;
					privremeniCvor.podatak = privremeniCvor.sljedeci.podatak;
					privremeniCvor.sljedeci.podatak = treciUZamjeni.podatak;
					
					biloZamjene = true;
				}
				privremeniCvor = privremeniCvor.sljedeci;
			}
		}	
		return cvor;
	}
}
