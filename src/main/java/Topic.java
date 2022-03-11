import java.io.Serializable;
import java.util.List;

public class Topic implements Serializable {

    private String name;
    private List<String> variants;

    public String getName() {
        return name;
    }

    public List<String> getVariants() {
        return variants;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setVariants(List<String> variants) {
        this.variants = variants;
    }

    public Topic(String name, List<String> variants) {
        this.name = name;
        this.variants = variants;
    }
}
