package metier;



/**
 * Classe ligne 
 * @generated
 */
 
@javax.persistence.Entity 
public class Ligne
{
	/**
	 * ID de la ligne
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected Long id;

	/**
	 * Quantité de produit dans la ligne
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected int quantite;

	/**
	 * Produit concerné par la ligne 
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Produit produit;

	/**
	 * Commande concernée par la ligne 
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Commande commande;

	/**
	 * Constructeur par défaut de la ligne
	 * @generated
	 */
	public Ligne(){
		super();
	}

	/**
	 * Ajout basique d'un produit
	 * @generated
	 * @ordered
	 */
	public void basicSetProduit(Produit myProduit) {
		if (this.produit != myProduit) {
			if (myProduit != null){
				if (this.produit != myProduit) {
					Produit oldproduit = this.produit;
					this.produit = myProduit;
					if (oldproduit != null)
						oldproduit.removeLigne(this);
				}
			}
		}
	}

	/**
	 * Ajout d'une commande à la ligne
	 * @generated
	 * @ordered
	 */
	public void basicSetCommande(Commande myCommande) {
		if (this.commande != myCommande) {
			if (myCommande != null){
				if (this.commande != myCommande) {
					Commande oldcommande = this.commande;
					this.commande = myCommande;
					if (oldcommande != null)
						oldcommande.removeLigne(this);
				}
			}
		}
	}

	/**
	 * Récupère l'ID de la ligne
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Récupère la quantité de produit de la ligne
	 * @generated
	 * @ordered
	 */
	private int getQuantite() {
		return this.quantite;
	}

	/**
	 * Récupère le produit de la ligne
	 * @generated
	 * @ordered
	 */
	public Produit getProduit() {
		return this.produit;
	}

	/**
	 * Récupère la commande liée à la ligne
	 * @generated
	 * @ordered
	 */
	public Commande getCommande() {
		return this.commande;
	}

	/**
	 * Définit l'ID de la ligne
	 * @generated
	 * @ordered
	 */
	public void setId(long myId) {
		this.id = myId;
	}

	/**
	 * Définit la quantité de produit dans la ligne
	 * @generated
	 * @ordered
	 */
	private void setQuantite(int myQuantite) {
		this.quantite = myQuantite;
	}

	/**
	 * Définit un produit donné dans la ligne
	 * @generated
	 * @ordered
	 */
	public void setProduit(Produit myProduit) {
		this.basicSetProduit(myProduit);
		myProduit.addLigne(this);
	}

	/**
	 * Définit une commande donnée dans la ligne
	 * @generated
	 * @ordered
	 */
	public void setCommande(Commande myCommande) {
		this.basicSetCommande(myCommande);
		myCommande.addLigne(this);
	}

	/**
	 * Retire l'ID de la ligne
	 * @generated
	 * @ordered
	 */
	public void unsetId() {
		this.id = 0L;
	}

	/**
	 * Retire la quantité dans la ligne
	 * @generated
	 * @ordered
	 */
	private void unsetQuantite() {
		this.quantite = 0;
	}

	/**
	 * Retire le produit lié à la ligne
	 * @generated
	 * @ordered
	 */
	public void unsetProduit() {
		if (this.produit == null)
			return;
		Produit oldproduit = this.produit;
		this.produit = null;
		oldproduit.removeLigne(this);
	}

	/**
	 * Retire la commande liée à la ligne
	 * @generated
	 * @ordered
	 */
	public void unsetCommande() {
		if (this.commande == null)
			return;
		Commande oldcommande = this.commande;
		this.commande = null;
		oldcommande.removeLigne(this);
	}

	
}

