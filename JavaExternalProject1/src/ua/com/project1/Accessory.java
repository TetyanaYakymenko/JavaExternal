package ua.com.project1;

import java.math.BigDecimal;

import ua.com.project1.enums.AccessoryType;

public class Accessory extends Component {
	private AccessoryType type;

	public Accessory(String name, BigDecimal price, AccessoryType type) {
		super(name, price);
		this.setType(type);

	}

	public void setName(String name) {
		if (name == null) {
			throw new NullPointerException("Name of accessory cannot be null.");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name of accessory cannot be empty.");

		}
		this.name = name;
	}

	public AccessoryType getType() {
		return type;
	}

	public void setType(AccessoryType type) {
		if (type == null) {
			throw new NullPointerException("Type of accessory cannot be null.");
		}
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accessory other = (Accessory) obj;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Accessory [name=" + name + ", price=" + price + ", type=" + type + "]";
	}

}
