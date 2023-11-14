package oneshot.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "브랜드 모델", description = "브랜드 정보")
public class Brand {
    private int id;
    private String brandName;
    private String brandUrl;
    private int crawling;
    private int service;
    private String createdTime;
    private String updatedTime;

    public Brand() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandUrl() {
        return brandUrl;
    }

    public void setBrandUrl(String brandUrl) {
        this.brandUrl = brandUrl;
    }

    public int getCrawling() {
        return crawling;
    }

    public void setCrawling(int crawling) {
        this.crawling = crawling;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "Brand [id=" + id + ", brandName=" + brandName + ", brandUrl=" + brandUrl + ", crawling=" + crawling
                + ", service=" + service + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
    }

}
