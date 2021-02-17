package zdz.joanna.travelagency.dto;

public class ClientDto {

	
		private Long id;
	    private String name;
	    private String surname;
	    private String passportNr;
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
		public ClientDto(String name, String surname, String passportNr) {
			super();
			this.name = name;
			this.surname = surname;
			this.passportNr = passportNr;
		}
		
		public ClientDto(Long id, String name, String surname, String passportNr) {
			super();
			this.id = id;
			this.name = name;
			this.surname = surname;
			this.passportNr = passportNr;
		}
		public ClientDto() {
			super();
		}
		@Override
		public String toString() {
			return "ClientDto [id=" + id + ", name=" + name + ", surname=" + surname + ", passportNr=" + passportNr
					+ "]";
		}
		public ClientDto(Long id) {
			super();
			this.id = id;
		}
		
		
	
		
	    
	    
}
