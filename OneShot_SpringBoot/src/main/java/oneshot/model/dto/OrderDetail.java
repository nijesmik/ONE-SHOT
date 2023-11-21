package oneshot.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "주문상세 모델", description = "주문상세 정보")
public class OrderDetail {
    private int OrderDetailId;
    private int orderId;
    private int menuDetailId;
    private String name;
    private int amount;
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
        return "OrderDetail [OrderDetailId=" + OrderDetailId + ", orderId=" + orderId + ", MenuDetailId=" + menuDetailId
                + ", name=" + name + ", amount=" + amount + ", createdTime=" + createdTime + ", updatedTime="
                + updatedTime + "]";
    }

}
