package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois villageois[];
	private int nbVillageois = 0;
	
	
	

	public Village(String nom, int nbVillageoisMax) {
		super();
		this.nom = nom;
		villageois = new Gaulois [nbVillageoisMax];
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois += 1;
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + this.chef.getNom() +
				" vivent les légendaires gaulois :");
		
		int i = 0;
		while (villageois[i] != null) {
			System.out.println("- " + villageois[i].getNom());
			i+=1;
			
		}
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}



	public String getNom() {
		return nom;
	}

	public static void main(String[] args) {
		Village village = new Village("Village des irréductibles", 30);
		
		/* Gaulois gaulois = village.trouverHabitant(30);
		 * 
		 * >>Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 30
				at personnages.Village.trouverHabitant(Village.java:24)
				at personnages.Village.main(Village.java:39)
		 * 
		 * Le tableau est de taille 30, il est donc impossible d'accéder
		 * à la case n°30, elles vont seulement de 0 à 29 !
		 * 
		 */
		
		Gaulois asterix = new Gaulois("Asterix",8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		
		Chef abraracourcix = new Chef("Abraracourcix",6,1,village);
		
		/* Gaulois gaulois = village.trouverHabitant(1);
		* System.out.println(gaulois);
		* 
		* >> null
		* 
		* On accède à la case n°1 (donc la deuxième case), elle est donc vide,
		* car la méthode ajouterHabitant a placée asterix à la case n°0.
		*/
		village.setChef(abraracourcix);
		village.afficherVillageois();
		
	}
	
	
}
