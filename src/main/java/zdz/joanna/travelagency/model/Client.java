package zdz.joanna.travelagency.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "clients")
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String surname;

	@Column(nullable = false)
	private String passportNr;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
	private List<Reservation> reservations;

	public Client(String name, String surname, String passportNr) {
		super();
		this.name = name;
		this.surname = surname;
		this.passportNr = passportNr;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassportNr() {
		return passportNr;
	}

	public void setPassportNr(String passportNr) {
		this.passportNr = passportNr;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Client() {
		super();
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", surname=" + surname + ", passportNr=" + passportNr
				+ ", reservations=" + reservations + "]";
	}
	
	
}
