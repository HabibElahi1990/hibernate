package model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class HabibEmbeddableTestPK implements Serializable {
    private Integer id;
    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "HabibEmbeddableTestPK{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
