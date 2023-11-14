package oneshot.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "주문서 모델", description = "주문서 정보")
public class Order {
    private int id;
    private int userId;
    private String orderUrl;
    private String orderList;
    private int totalPrice;
    private int service;
    private String info;
    private String createdTime;
    private String updatedTime;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderUrl() {
        return orderUrl;
    }

    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }

    public String getOrderList() {
        return orderList;
    }

    public void setOrderList(String orderList) {
        this.orderList = orderList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
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
        return "Order [id=" + id + ", userId=" + userId + ", orderUrl=" + orderUrl + ", orderList=" + orderList
                + ", totalPrice=" + totalPrice + ", service=" + service + ", info=" + info + ", createdTime="
                + createdTime + ", updatedTime=" + updatedTime + "]";
    }

}
