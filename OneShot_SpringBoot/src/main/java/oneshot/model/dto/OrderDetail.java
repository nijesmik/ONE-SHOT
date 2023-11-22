package oneshot.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "주문상세 모델", description = "주문상세 정보")
public class OrderDetail {
    private int OrderDetailId;
    private int orderId;
    private int menuDetailId;
    private String name;
    private int amount;
    private String menuName;
    private String img;
    private int unitPrice;
    private String size;
    private String sizeName;
    private String temperature;
    private String createdTime;
    private String updatedTime;

    public OrderDetail() {
    }

    public int getOrderDetailId() {
        return OrderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        OrderDetailId = orderDetailId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMenuDetailId() {
        return menuDetailId;
    }

    public void setMenuDetailId(int menuDetailId) {
        this.menuDetailId = menuDetailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
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
        return "OrderDetail [OrderDetailId=" + OrderDetailId + ", orderId=" + orderId + ", menuDetailId=" + menuDetailId
                + ", name=" + name + ", amount=" + amount + ", menuName=" + menuName + ", img=" + img + ", unitPrice="
                + unitPrice + ", size=" + size + ", sizeName=" + sizeName + ", temperature=" + temperature
                + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
    }

}
