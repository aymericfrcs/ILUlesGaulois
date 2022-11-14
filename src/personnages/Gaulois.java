package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipements[] trophees = new Equipements[100];
	
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}

	

	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la " +
"mâchoire de " + romain.getNom());
		Equipements[] nvTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; nvTrophees != null && i < nvTrophees.length; i++,
nbTrophees++) {
			this.trophees[nbTrophees] = nvTrophees[i];
		}
	}

	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est "
				+ effetPotion + " fois décuplée");
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",8);
		
		asterix.boirePotion(3);
		
	}
}
