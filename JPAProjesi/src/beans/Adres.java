package beans;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Adres
 *
 */
@Entity
@NamedQuery(name = "findAll", query = "SELECT A FROM Adres A")
public class Adres implements Serializable {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "adresSEQ")
	@SequenceGenerator(name = "adresSEQ", allocationSize = 1, initialValue = 1, sequenceName = "adresSEQ")
	private Long id;

	@Column(nullable = false, length = 1000)
	private String adres_ev;

	@Column(nullable = false, length = 1000)
	private String adres_is;

	@Column(nullable = false, length = 100)
	private String email;

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "FK_EGITMEN_ID")
	private Egitmen egitmen;

	public Adres() {
		super();
	}

	public Egitmen getEgitmen() {
		return egitmen;
	}

	public void setEgitmen(Egitmen egitmen) {
		this.egitmen = egitmen;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdres_ev() {
		return this.adres_ev;
	}

	public void setAdres_ev(String adres_ev) {
		this.adres_ev = adres_ev;
	}

	public String getAdres_is() {
		return this.adres_is;
	}

	public void setAdres_is(String adres_is) {
		this.adres_is = adres_is;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
