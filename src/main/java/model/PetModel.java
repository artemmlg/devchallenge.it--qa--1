package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class PetModel {

    @JsonProperty("photoUrls")
    private List<String> photoUrls;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private int id;

    @JsonProperty("category")
    private Category category;

    @JsonProperty("tags")
    private List<TagsItem> tags;

    @JsonProperty("status")
    private String status;

    public PetModel() {
    }

    public PetModel(List<String> photoUrls, String name, int id, Category category, List<TagsItem> tags, String status) {
        this.photoUrls = photoUrls;
        this.name = name;
        this.id = id;
        this.category = category;
        this.tags = tags;
        this.status = status;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setTags(List<TagsItem> tags) {
        this.tags = tags;
    }

    public List<TagsItem> getTags() {
        return tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PetModel petModel = (PetModel) o;

        if (id != petModel.id) return false;
        if (photoUrls != null ? !photoUrls.equals(petModel.photoUrls) : petModel.photoUrls != null) return false;
        if (name != null ? !name.equals(petModel.name) : petModel.name != null) return false;
        if (category != null ? !category.equals(petModel.category) : petModel.category != null) return false;
        if (tags != null ? !tags.equals(petModel.tags) : petModel.tags != null) return false;
        if (status != null ? !status.equals(petModel.status) : petModel.status != null) return false;

        return true;
    }
}