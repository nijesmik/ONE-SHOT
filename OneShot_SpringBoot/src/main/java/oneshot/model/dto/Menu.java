package oneshot.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "메뉴 모델", description = "메뉴 정보")
public class Menu {
    private int id;
    private String menuCode;
    private int brandId;
    private String menuName;
    private int price;
    private String size;
    private String type;
    private String createdTime;
    private String updatedTime;

    public Menu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getPrice() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "Menu [id=" + id + ", menuCode=" + menuCode + ", brandId=" + brandId + ", menuName=" + menuName
                + ", price=" + price + ", size=" + size + ", type=" + type + ", createdTime=" + createdTime
                + ", updatedTime=" + updatedTime + "]";
    }

}
