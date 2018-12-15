package ua.com.database.entities;

public class Product extends Entity {
    private String model;
    private String maker;
    private String type;

    public Product() {
    }

    public Product(String model, String maker, String type) {
        this.model = model;
        this.maker = maker;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return ((Product) o).getModel().equals(product.model) &&
                ((Product) o).getMaker().equals(product.maker) &&
                ((Product) o).type.equals(product.type);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((maker == null) ? 0 : maker.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("model='").append(model).append('\'');
        sb.append(", maker='").append(maker).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
