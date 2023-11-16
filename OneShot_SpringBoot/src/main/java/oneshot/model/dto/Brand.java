package oneshot.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "브랜드 모델", description = "브랜드 정보")
public class Brand {
    private int brandId;
    private String brandName;
    private String logo;
    private String brandUrl;
    private String createdTime;
    private String updatedTime;

    public Brand() {
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBrandUrl() {
        return brandUrl;
    }

    public void setBrandUrl(String brandUrl) {
        this.brandUrl = brandUrl;
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
        return "Brand [brandId=" + brandId + ", brandName=" + brandName + ", logo=" + logo + ", brandUrl=" + brandUrl
                + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
    }

}
