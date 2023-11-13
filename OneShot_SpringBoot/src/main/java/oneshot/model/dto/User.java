package oneshot.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "유저 모델", description = "유저 정보")
public class User {
    private int id;
    private String userCode;
    private String userEmail;
    private String password;
    private String nickName;
    private int admin;
    private int service;
    private String createdTime;
    private String updatedTime;

    public User() {
    }

    public User(String userCode, String userEmail, String password, String nickName, int admin, int service) {
        this.userCode = userCode;
        this.userEmail = userEmail;
        this.password = password;
        this.nickName = nickName;
        this.admin = admin;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
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

    @Override
    public String toString() {
        return "User [id=" + id + ", userCode=" + userCode + ", userEmail=" + userEmail + ", password=" + password
                + ", nickName=" + nickName + ", admin=" + admin + ", service=" + service + ", createdTime="
                + createdTime + ", updatedTime=" + updatedTime + "]";
    }

}
