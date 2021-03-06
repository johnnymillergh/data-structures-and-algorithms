package com.jmsoftware.datastructuresandalgorithms.common.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jmsoftware.datastructuresandalgorithms.common.constant.HttpStatus;
import com.jmsoftware.datastructuresandalgorithms.common.constant.IUniversalStatus;
import com.jmsoftware.datastructuresandalgorithms.common.exception.BaseException;
import com.jmsoftware.datastructuresandalgorithms.common.exception.BusinessException;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * <h1>ResponseBodyBean</h1>
 * <p>
 * Response body bean.
 *
 * @param <ResponseBodyDataType> the response body data type
 * @author Johnny Miller (鍾俊), e-mail: johnnysviva@outlook.com
 * @date 2/27/20 9:24 AM
 */
@Value
@Builder
@SuppressWarnings("unused")
public class ResponseBodyBean<ResponseBodyDataType> implements Serializable {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 4645469240048361965L;

    /**
     * The Timestamp.
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date timestamp;
    /**
     * Default status is OK[200]
     */
    Integer status;
    /**
     * The Message.
     */
    String message;
    /**
     * The Data.
     */
    ResponseBodyDataType data;

    /**
     * <p>Respond to client with IUniversalStatus (status may be OK or other).</p>
     * <p><strong>ATTENTION:</strong></p>
     * <p>This method CANNOT be used by controller or service or other class, only provided for Exception controller
     * .</p>
     *
     * @param <ResponseBodyDataType> the type parameter
     * @param status                 IUniversalStatus
     * @return response body for ExceptionControllerAdvice javax.servlet.http.HttpServletResponse, Exception)
     */
    public static <ResponseBodyDataType> ResponseBodyBean<ResponseBodyDataType> ofStatus(@NonNull final IUniversalStatus status) {
        return ResponseBodyBean.<ResponseBodyDataType>builder()
                .timestamp(new Date())
                .status(status.getCode())
                .message(status.getMessage())
                .build();
    }

    /**
     * <p>Respond to client with IUniversalStatus and data.</p>
     * <p><strong>ATTENTION:</strong></p>
     * <p>This method CANNOT be used by controller or service or other class, only provided for Exception controller
     * .</p>
     *
     * @param <ResponseBodyDataType> the response body data type
     * @param status                 IUniversalStatus
     * @param data                   data to be responded to client
     * @return response body for ExceptionControllerAdvice
     */
    public static <ResponseBodyDataType> ResponseBodyBean<ResponseBodyDataType> ofStatus(@NonNull final IUniversalStatus status,
                                                                                                                        @NonNull final ResponseBodyDataType data) {
        return ResponseBodyBean.<ResponseBodyDataType>builder()
                .timestamp(new Date())
                .status(status.getCode())
                .message(status.getMessage())
                .data(data)
                .build();
    }

    /**
     * <p>Highly customizable response. Status might be any HttpStatus&#39; code value.</p>
     * <p><strong>ATTENTION:</strong></p>
     * <p>This method CANNOT be used by controller or service or other class, only provided for Exception controller
     * .</p>
     *
     * @param <ResponseBodyDataType> the response body data type
     * @param status                 status code
     * @param message                message to be responded
     * @param data                   data to be responded
     * @return response body for ExceptionControllerAdvice
     */
    public static <ResponseBodyDataType> ResponseBodyBean<ResponseBodyDataType> ofStatus(@NonNull final Integer status,
                                                                                                                        @NonNull final String message,
                                                                                                                        final ResponseBodyDataType data) {
        return ResponseBodyBean.<ResponseBodyDataType>builder()
                .timestamp(new Date())
                .status(status)
                .message(message)
                .data(data)
                .build();
    }

    /**
     * <p>Highly customizable response. Status might be any HttpStatus&#39; code value. </p>
     * <p><strong>ATTENTION:</strong></p>
     * <p>This method CANNOT be used in ExceptionControllerAdvice.</p>
     *
     * @param <ResponseBodyDataType> the response body data type
     * @param status                 status code
     * @param message                message to be responded
     * @param data                   data to be responded
     * @return response body
     */
    public static <ResponseBodyDataType> ResponseBodyBean<ResponseBodyDataType> setResponse(@NonNull final Integer status,
                                                                                                                           @NonNull final String message,
                                                                                                                           final ResponseBodyDataType data)
            throws BaseException {
        if (!HttpStatus.OK.getCode().equals(status)) {
            throw new BaseException(status, message, data);
        }
        return ResponseBodyBean.<ResponseBodyDataType>builder()
                .timestamp(new Date())
                .status(status)
                .message(message)
                .data(data)
                .build();
    }

    /**
     * Respond null data, and status is OK.
     *
     * @param <ResponseBodyDataType> the response body data type
     * @return response body
     */
    public static <ResponseBodyDataType> ResponseBodyBean<ResponseBodyDataType> ofSuccess() {
        return ResponseBodyBean.<ResponseBodyDataType>builder()
                .timestamp(new Date())
                .status(HttpStatus.OK.getCode())
                .message(HttpStatus.OK.getMessage())
                .build();
    }

    /**
     * Respond data and status is OK.
     *
     * @param <ResponseBodyDataType> the response body data type
     * @param data                   data to be responded to client.
     * @return response body
     */
    public static <ResponseBodyDataType> ResponseBodyBean<ResponseBodyDataType> ofSuccess(final ResponseBodyDataType data) {
        return ResponseBodyBean.<ResponseBodyDataType>builder()
                .timestamp(new Date())
                .status(HttpStatus.OK.getCode())
                .message(HttpStatus.OK.getMessage())
                .data(data)
                .build();
    }

    /**
     * Respond a message and status is OK.
     *
     * @param <ResponseBodyDataType> the response body data type
     * @param message                message to be responded
     * @return response body
     */
    public static <ResponseBodyDataType> ResponseBodyBean<ResponseBodyDataType> ofSuccess(@NonNull final String message) {
        return ResponseBodyBean.<ResponseBodyDataType>builder().timestamp(new Date())
                .status(HttpStatus.OK.getCode())
                .message(message)
                .build();
    }

    /**
     * Respond data, message and status is OK.
     *
     * @param <ResponseBodyDataType> the response body data type
     * @param data                   data to be responded
     * @param message                message to be responded
     * @return response body
     */
    public static <ResponseBodyDataType> ResponseBodyBean<ResponseBodyDataType> ofSuccess(final ResponseBodyDataType data,
                                                                                                                         @NonNull final String message) {
        return ResponseBodyBean.<ResponseBodyDataType>builder().timestamp(new Date())
                .status(HttpStatus.OK.getCode())
                .message(message)
                .data(data)
                .build();
    }

    /**
     * Respond a message and status is FAILURE(464).
     *
     * @param <ResponseBodyDataType> the response body data type
     * @param message                message to be responded.
     * @return response body
     */
    public static <ResponseBodyDataType> ResponseBodyBean<ResponseBodyDataType> ofFailure(@NonNull final String message) throws BusinessException {
        throw new BusinessException(message);
    }

    /**
     * Respond a message and status is FAILURE(464).
     *
     * @param <ResponseBodyDataType> the response body data type
     * @param data                   data to be responded
     * @return response body
     */
    public static <ResponseBodyDataType> ResponseBodyBean<ResponseBodyDataType> ofFailure(final ResponseBodyDataType data) throws BusinessException {
        throw new BusinessException(data);
    }

    /**
     * Respond data and message, and status if FAILURE(464).
     *
     * @param <ResponseBodyDataType> the response body data type
     * @param data                   data to be responded
     * @param message                message to be responded
     * @return response body
     */
    public static <ResponseBodyDataType> ResponseBodyBean<ResponseBodyDataType> ofFailure(final ResponseBodyDataType data,
                                                                                                                         @NonNull final String message) throws BusinessException {
        throw new BusinessException(data, message);
    }

    /**
     * Respond an ERROR(500).
     *
     * @param <ResponseBodyDataType> the response body data type
     * @return response body
     */
    public static <ResponseBodyDataType> ResponseBodyBean<ResponseBodyDataType> ofError() throws BaseException {
        return setResponse(HttpStatus.ERROR.getCode(), HttpStatus.ERROR.getMessage(), null);
    }

    /**
     * Respond a custom error.
     *
     * @param <ResponseBodyDataType> the response body data type
     * @param status                 Error status, not OK(200)
     * @return response body
     */
    public static <ResponseBodyDataType> ResponseBodyBean<ResponseBodyDataType> ofError(@NonNull final IUniversalStatus status)
            throws BaseException {
        return setResponse(status.getCode(), status.getMessage(), null);
    }

    /**
     * Response an exception.
     *
     * @param <ResponseBodyDataType> the response body data type
     * @param <BaseThrowable>        Sub class of {@link BaseException}
     * @param throwable              exception
     * @return the response body bean
     */
    public static <ResponseBodyDataType, BaseThrowable extends BaseException> ResponseBodyBean<ResponseBodyDataType> ofException(@NonNull final BaseThrowable throwable)
            throws BaseException {
        throw throwable;
    }
}
