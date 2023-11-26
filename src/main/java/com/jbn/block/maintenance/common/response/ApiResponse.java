package com.jbn.block.maintenance.common.response;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private String status;
    private String message;
    private T data;

    public ApiResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiResponse() {

    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>("Success", message, data);
    }

    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<>("Success", message, null);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>("Error", message, null);
    }

    // Additional methods if needed
}
