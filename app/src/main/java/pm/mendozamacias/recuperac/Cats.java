package pm.mendozamacias.recuperac;

public class Cats {

    String id, created_at, tags;

    public Cats() {
    }

    public Cats(String id, String created_at, String tags) {
        this.id = id;
        this.created_at = created_at;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
