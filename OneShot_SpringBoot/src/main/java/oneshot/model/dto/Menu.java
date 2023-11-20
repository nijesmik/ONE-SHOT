package oneshot.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "메뉴 모델", description = "메뉴 정보")
public class Menu {
    private int menuId;
    private int brandId;
    private String menuName;
    private String img;
    private String type;
    private String createdTime;
    private String updatedTime;

    public Menu() {
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void update(int menuId, Menu oldMenu) {
        this.menuId = menuId;
        if (this.menuName == null) {
            this.menuName = oldMenu.menuName;
        }
        if (this.img == null) {
            this.img = oldMenu.img;
        }
        if (this.type == null) {
            this.type = oldMenu.type;
        }
    }

    @Override
    public String toString() {
        return "Menu [menuId=" + menuId + ", brandId=" + brandId + ", menuName=" + menuName + ", img=" + img + ", type="
                + type + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
    }

}
