package oneshot.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "주문상세 모델", description = "주문상세 정보")
public class OrderDetail {
    private int id;
    private int orderId;
    private int menuId;
    private String orderUser;
    private int amount;
    private int sumPrice;
    private int service;
    private String info;
    private String createdTime;
    private String updatedTime;

    public OrderDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
        return "OrderDetail [id=" + id + ", orderId=" + orderId + ", menuId=" + menuId + ", orderUser=" + orderUser
                + ", amount=" + amount + ", sumPrice=" + sumPrice + ", service=" + service + ", info=" + info
                + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
    }

}
