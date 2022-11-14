package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipements[] equipements;
	private int nbEquipement = 0;
	
	
	public Romain(String nom, int force) {
		super();
		if (force < 0) {
			throw new IllegalArgumentException("Force invalide" + force);
		}
		this.nom = nom;
		this.force = force;
		equipements = new Equipements [2];
	}

	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	

	
	public void sEquiper(Equipements equip) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé");
			break;
		case 1:
			if (equip == equipements[0]) {
				System.out.println("Le soldat" + this.nom + " a déjà un " + equip.toString());
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
		System.out.println("Le soldat" + this.nom + "s'équipe avec un "+equip.toString());
	}
	
	public Equipements[] recevoirCoup(int forceCoup) {
		Equipements[] equipementEjecte = null;
		// precondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force==0) {
			parler("Aie");
		}
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
			// post condition la force à diminué
			assert force < oldForce;
			return equipementEjecte;
			}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + 
", et la force du coup est de " + forceCoup + 
"\nMais heureusement, grâce a mon équipement sa force est diminué de ";
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null &&
equipements[i].equals(Equipements.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	
	private Equipements[] ejecterEquipement() {
		Equipements[] equipementEjecte = new Equipements[nbEquipement];
		System.out.println("L'equipement de " + nom +
"s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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
