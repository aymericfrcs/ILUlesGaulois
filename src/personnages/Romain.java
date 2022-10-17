package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipements equipements[];
	private int nbEquipement = 0;
	
	
	public Romain(String nom, int force) {
		super();
		assert force > 0;
		this.nom = nom;
		this.force = force;
		equipements = new Equipements [2];
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force > 0; //la force d'un romain est positive
		int forceAvant = force;
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			parler("J'abandonne...");
		}
		assert forceAvant > force; //la force du romain a diminu�e
	}
	
	public void sEquiper(Equipements equip) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.nom + " est d�j� bien prot�g�!");
			break;
		case 1:
			if (equip == equipements[0]) {
				System.out.println("Le soldat" + this.nom + " a d�j� un " + equip.toString());
			} 
			else {
				sEquiperPossible(equip);				
			}
			break;
		default:
			sEquiperPossible(equip);
		}
	}

	private void sEquiperPossible(Equipements equip) {
		equipements[nbEquipement] = equip;
		nbEquipement += 1;
		System.out.println("Le soldat" + this.nom + "s'�quipe avec un "+equip.toString());
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		
		minus.prendreParole();
		minus.parler("Je parle !");
		minus.recevoirCoup(5);
		
		minus.sEquiper(Equipements.CASQUE);
		minus.sEquiper(Equipements.CASQUE);
		minus.sEquiper(Equipements.BOUCLIER);
		minus.sEquiper(Equipements.BOUCLIER);
		
		
	}
}
