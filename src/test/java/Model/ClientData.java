package Model;

public class ClientData {
    private Integer id;
    private String title;
    private String categories;

    private AtributesList atribute;

    public AtributesList getAtribute() {
        return atribute;
    }

    public void setAtribute(AtributesList atribute) {
        this.atribute = atribute;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
