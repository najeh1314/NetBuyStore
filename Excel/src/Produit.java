
public class Produit {
	private String nom;
	private double prix;
	private int quantite;
	public String getNom() {
		return nom;
	}
	public void setNom(String type) {
		this.nom = type;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Produit(String type, double prix, int quantite) {
		super();
		this.nom = type;
		this.prix = prix;
		this.quantite = quantite;
	}
	

}
