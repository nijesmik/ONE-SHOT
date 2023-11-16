package oneshot.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "주문상세 모델", description = "주문상세 정보")
public class OrderDetail {
    private int OrderDetailId;
    private int orderId;
    private int menuId;
    private String orderUser;
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

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser;
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
        return "OrderDetail [OrderDetailId=" + OrderDetailId + ", orderId=" + orderId + ", menuId=" + menuId
                + ", orderUser=" + orderUser + ", amount=" + amount + ", createdTime=" + createdTime + ", updatedTime="
                + updatedTime + "]";
    }

}
