package oneshot.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "유저 모델", description = "유저 정보")
public class User {
    private int userId;
    private String email;
    private String password;
    private String nickname;
    private int admin;
    private String createdTime;
    private String updatedTime;

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
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
        return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", nickname=" + nickname
                + ", admin=" + admin + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
    }

}
