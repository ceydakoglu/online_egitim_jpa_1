package beans;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import static javax.persistence.CascadeType.PERSIST;

/**
 * Entity implementation class for Entity: Egitmen
 *
 */
@Entity
@Table(name = "Egitmen")
public class Egitmen implements Serializable {

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "egitmenSeq", sequenceName = "egitmenSeq")
	@GeneratedValue(generator = "egitmenSeq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(length = 200, nullable = false)
	private String isim;

	private String tc;
	private String tel;

	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy = "egitmen")
	private Adres adres;

	public Egitmen() {
		super();
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsim() {
		return this.isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getTc() {
		return this.tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
