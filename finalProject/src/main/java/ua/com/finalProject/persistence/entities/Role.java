package ua.com.finalProject.persistence.entities;

import ua.com.finalProject.RoleEnum;

public class Role extends Entity {
    private String role_name;

    public Role() {
        super();
    }

    public Role(int id, String role_name) {
        this.id = id;
        this.role_name = role_name;
    }

    public String getRoleName() {
        return role_name;
    }

    public void setRoleName(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Role[");
        sb.append("id=").append(id).append('\n');
        sb.append("role_name=").append(role_name).append('\n');
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!super.equals(o))
            return false;
        if (getClass() != o.getClass())
            return false;
        Role other = (Role) o;
        if (role_name != other.getRoleName())
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((role_name == null) ? 0 : role_name.hashCode());
        return result;
    }
}
