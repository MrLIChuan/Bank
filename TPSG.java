import java.util.ArrayList;
import java.math.*;

public class TPSG {
	public static void main(String[] args)
	{
		Banque B1 = new Banque("BNP");
		
		
		Compte_numerote T1 = new Compte_numerote(100, "LI", "Chuan");
		B1.ajouter_compte(T1);
	
		//T1.affiche_compte();
		//System.out.println(T1);
		//System.out.println("MOO");
		
		Compte_numerote T2 = new Compte_numerote(200, "Felix", "Chuan");
		B1.ajouter_compte(T2);
		
		Compte_numerote T3 = new Compte_numerote(50, "Felix", "Chuan");
		B1.ajouter_compte(T3);
		
		Compte_numerote T4 = new Compte_numerote(500, "Felix", "Chuan");
		B1.ajouter_compte(T4);
		
		Compte_numerote T5 = new Compte_numerote(30, "Felix", "Chuan");
		B1.ajouter_compte(T5);
		
		
		//B1.affiche_liste_compte("Numerote");
		System.out.println("-----------------------------");
		B1.tri_par_selection();
		/*
		Compte C = B1.recherche_compte(2);
		C.affiche_compte();
		
		int size = B1.nombre_de_compte();
		System.out.println("la taille est de :" +size);
		//T2.affiche_compte();
		//System.out.println(T2);
		
		System.out.println("-----------------------------");
		B1.affiche_liste_compte(Compte_numerote.class);
		String Name = B1.nom_de_classe(0);
		System.out.println("nom classe : " + Name);
		
		System.out.println("-----------------------------");
		T2.virement(1, B1, 33);
		T2.affiche_compte();
		System.out.println("-----------------------------");
		T1.affiche_compte();*/
		
		
	}

}


class Banque 
{
    ArrayList<Compte> Comptes_Clients;
	String Nom_Banque;
	
	Banque(String nom)
	{
		Nom_Banque=nom;
		Comptes_Clients = new ArrayList<Compte>();
	}
	
	void modifie_decouvert(Compte_personne p, double nouveau_decouvert)
	{
		p.modifie_decouvert(nouveau_decouvert);
	}
	
	void ajouter_compte(Compte nouveau_compte)
	{
		Comptes_Clients.add(nouveau_compte);
	}
	
	Compte recherche_compte(int numero_de_compte_recherche)
	{
		int i=0;
		Compte C = Comptes_Clients.get(i);
		while (C.Get_numero_de_compte() != numero_de_compte_recherche)
		{
			i++;
			C = Comptes_Clients.get(i);
		}
		//affiche_banque();
		return C;
	}
	
	void suppression_compte(int numero_de_compte_recherche)
	{
		int i=0;
		Compte C = Comptes_Clients.get(i);
		while (C.Get_numero_de_compte() != numero_de_compte_recherche)
		{
			i++;
			C = Comptes_Clients.get(i);
		}
		 Comptes_Clients.remove(i);
	}
	
	Compte ieme_compte(int i)
	{
		Compte C = Comptes_Clients.get(i);
		return C;
	}
	
	int numero_du_ieme_compte(int i)
	{
		Compte C = Comptes_Clients.get(i);
		return C.Get_numero_de_compte();
	}
	
	void affiche_banque()
	{
		System.out.println("Nom de la banque : " +Nom_Banque);
	}
	
	int nombre_de_compte()
	{
	  return Comptes_Clients.size();
	}
	
	void affiche_liste_compte()
	{
		int i=0;
		Compte C;
		
		while(i <= Comptes_Clients.size())
		{
			C = Comptes_Clients.get(i);
			C.affiche_compte();
		}
	}
	
	void affiche_liste_compte(Class type_de_compte)
	{
			int i=0;	
			Compte C;
		
				while(i < Comptes_Clients.size())
				{
					C=Comptes_Clients.get(i);
					
					if ( C.getClass() == type_de_compte)
					{
						System.out.println(C);
					}
					
					i++;
				}
			Comptes_Clients.remove(1);
	}
	
	void affiche_liste_compte(String type_de_compte)
	{
		String E = "Entreprise";
		String N = "Numerote";
		String P = "Personne";
		
		if (type_de_compte == E )
		{
			affiche_liste_compte(Compte_entreprise.class);
		}
		
		if (type_de_compte == N)
		{
			affiche_liste_compte(Compte_numerote.class);
		}
		
		if (type_de_compte == P)
		{
			affiche_liste_compte(Compte_personne.class);
		}
	}
	
	String nom_de_classe(int i)
	{
		Compte C;
		C = Comptes_Clients.get(i);
		return C.getClass().getName();
	}
	
	void tri_par_selection()
	{
		ArrayList<Compte> Comptes_Clients_trie;
		ArrayList<Compte> Comptes_Clients_temp;
		Comptes_Clients_trie = new ArrayList<Compte>();
		Comptes_Clients_temp = new ArrayList<Compte>();
		Comptes_Clients_temp = Comptes_Clients;
		
		Compte C1;
		Compte C2;
		int i=0;
	    

		
		while(Comptes_Clients_temp.size() !=1)
		{
			C1 = Comptes_Clients_temp.get(i);
			while (i<Comptes_Clients_temp.size()-1)
			{
				C2 = Comptes_Clients_temp.get(i+1);
				if (C2.Get_solde()>C1.Get_solde())
				{
					C1 = C2;
				}
			    i++;
			}
			i=0;
			Comptes_Clients_trie.add(C1);
			suppression_compte(C1.Get_numero_de_compte());	
	   }
	   C1 = Comptes_Clients_temp.get(0);
	   Comptes_Clients_trie.add(C1);
		
		int h=0;
		Compte C;
		
		while(h < Comptes_Clients_trie.size())
		{
			C = Comptes_Clients_trie.get(h);
			C.affiche_compte();
			h++;
		}
	
	}

}


class Compte
{
	private static int numero = 0;
	private int numero_de_compte;
	private double solde;
	private double decouvert;
	
	
	public Compte(double depot_initial)
	{
		solde=depot_initial;
		decouvert=(-depot_initial);
		numero_de_compte=numero+1;
		numero++;
	}
	
	public void debit(double montant)
	{
		if (test_debit(montant) == true)
		{
		solde=solde-montant;
		System.out.println("Le solde sur votre compte est bon");
		}
		
		else
		{
		System.out.println("Le solde sur votre compte est insuffisant");
		}
	}
	
	public boolean test_debit(double montant)
	{
		if ((solde-montant)>(decouvert))
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	 public void credit(double depot)
	 {
		 solde = solde + depot;
	 }
	 
	 public void virement(int numero_de_compte, Banque bq, double demande)
	 {
		 Compte credite;
		 int i=0;
		 while (i<bq.nombre_de_compte())
		 {
			 credite = bq.Comptes_Clients.get(i);
			 if(credite.Get_numero_de_compte()==numero_de_compte)
			 {
				 debit(demande);
				 credite.credit(demande);
			 }
			 i++;
		 }
	 }
	 
	 public void affiche_compte()
	 {
		 System.out.println("Le num�ro de compte est : " +numero_de_compte);
		 System.out.println("Le solde est de : " +solde);
	 }
	 
	 public void Set_decouvert(double nouveau_decouvert)
	 {
		 decouvert=nouveau_decouvert;
	 }
	
	 public double Get_decouvert()
	 {
		 return decouvert;
	 }
	 
	 public int Get_numero_de_compte()
	 {
		 return numero_de_compte;
	 }
	 
	 public double Get_solde()
	 {
		 return solde;
	 }
	 
	 public boolean est_crediteur()
	 {
		 return true;
	 }
	 
	 public String toString()
	 {
		 return "Num�ro de compte :" +numero_de_compte + "\n" +  "Le solde est :" +solde + "\n";
	 }
	
}

class Compte_entreprise extends Compte
{
	public String nom_entreprise;
	
	public Compte_entreprise(double depot, String nom) 
	{
		super(depot);
		nom_entreprise=nom;
	}
	
	public String toString() 
	{
	  return super.toString() + "nom_entreprise=" + nom_entreprise + "\n";
    }
}

class Compte_personne extends Compte
{
	private String nom;
	private String prenom;
	
	public Compte_personne(double depot, String nom_p, String prenom_p) 
	{
		super(depot);
		nom=nom_p;
		prenom=prenom_p;		
	}
	
	public void modifie_decouvert(double nouveau_decouvert)
	{
		Set_decouvert(nouveau_decouvert);
	}
	
    public String toString ()
    {
    	return super.toString() + "nom=" + nom +"prenom="+ prenom + "\n";
    }
}

class Compte_numerote extends Compte_personne
{
	public Compte_numerote(double depot, String nom_p, String prenom_p) 
	{
		super(depot, nom_p, prenom_p);
	}
	
	public String toString()
	{
		return "Numero de compte = " + super.Get_numero_de_compte();
	}
}


