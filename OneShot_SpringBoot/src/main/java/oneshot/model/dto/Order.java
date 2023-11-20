package oneshot.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "주문서 모델", description = "주문서 정보")
public class Order {
    private int orderId;
    private int brandId;
    private int userId;
    private String orderCode;
    private int service;
    private String createdTime;
    private String updatedTime;

    public Order() {
    }

    public Order(int brandId, int userId, String orderCode) {
        this.brandId = brandId;
        this.userId = userId;
        this.orderCode = orderCode;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", brandId=" + brandId +
                ", userId=" + userId +
                ", orderCode='" + orderCode + '\'' +
                ", service=" + service +
                ", createdTime='" + createdTime + '\'' +
                ", updatedTime='" + updatedTime + '\'' +
                '}';
    }
}
