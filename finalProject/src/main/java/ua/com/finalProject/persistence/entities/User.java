package ua.com.finalProject.persistence.entities;

import java.math.BigDecimal;

public class User extends Entity {

    private String surname;
    private String name;
    private String login;
    private String password;
    private String email;
    private String phone;
    private int rating;
    private BigDecimal salary;
    private int rolesId;

    public User() {
        super();
    }

    public User(int id, String surname, String name, String login, String password, String email, String phone,
                int rating, BigDecimal salary, int rolesId) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.rating = rating;
        this.salary = salary;
        this.rolesId = rolesId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getRolesId() {
        return rolesId;
    }

    public void setRolesId(int rolesId) {
        this.rolesId = rolesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!super.equals(o))
            return false;
        if (getClass() != o.getClass())
            return false;
        User other = (User) o;
        if (surname == null) {
            if (other.getSurname() != null)
                return false;
        } else if (!surname.equals(other.getSurname()))
            return false;
        if (name == null) {
            if (other.getName() != null)
                return false;
        } else if (!name.equals(other.getName()))
            return false;
        if (login == null) {
            if (other.getLogin() != null)
                return false;
        } else if (!login.equals(other.getLogin()))
            return false;
        if (password == null) {
            if (other.getPassword() != null)
                return false;
        } else if (!password.equals(other.getPassword()))
            return false;
        if (phone == null) {
            if (other.getPassword() != null)
                return false;
        } else if (!phone.equals(other.getPhone()))
            return false;
        if (rating != other.getRating()) {
            return false;
        }
        if (salary == null) {
            if (other.getSalary() != null)
                return false;
        } else if (!salary.equals(other.getSalary())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + rating;
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        result = prime * result + rolesId;
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User[");
        sb.append("id=").append(id).append("\n");
        sb.append("surname=").append(surname).append("\n");
        sb.append("name=").append(name).append("\n");
        sb.append("login=").append(login).append("\n");
        sb.append("password='").append(password).append("\n");
        sb.append("email='").append(email).append("\n");
        sb.append("phone='").append(phone).append("\n");
        sb.append("rating=").append(rating).append("\n");
        sb.append("salary=").append(salary).append("\n");
        sb.append("roles_id=").append(rolesId).append("\n");
        sb.append("]");
        return sb.toString();
    }
}
