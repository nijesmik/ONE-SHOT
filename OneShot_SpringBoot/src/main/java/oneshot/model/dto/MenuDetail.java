package oneshot.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "메뉴 모델", description = "메뉴 정보")
public class MenuDetail {
    private int menuDetailId;
    private int menuId;
    private Integer price;
    private String size;
    private String sizeName;
    private String temperature;
    private String createdTime;
    private String updatedTime;

    public MenuDetail() {
    }

    public int getMenuDetailId() {
        return menuDetailId;
    }

    public void setMenuDetailId(int menuDetailId) {
        this.menuDetailId = menuDetailId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
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
        return "MenuDetail [menuDetailId=" + menuDetailId + ", menuId=" + menuId + ", price=" + price + ", size=" + size
                + ", sizeName=" + sizeName + ", temperature=" + temperature + ", createdTime=" + createdTime
                + ", updatedTime=" + updatedTime + "]";
    }

}
