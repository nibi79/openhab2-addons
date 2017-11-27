package org.openhab.binding.synologysurveillancestation.internal.webapi;

import java.util.HashMap;
import java.util.Map;

public enum WebApiErrorCodes {

    UNKNOWN_ERROR(100, "Unknown error"),
    INVALID_PARAMETER(101, "Invalid parameters"),
    API_NOT_EXIST(102, "API does not exist"),
    METHOD_NOT_EXIST(103, "Method does not exist"),
    API_VERSION_NOT_SUPPORTED(104, "This API version is not supported"),
    AUTH_ERROR(105, "Insufficient user privilege"),
    CONNECT_TIMEOUT(106, "Connection time out"),
    MULTIPLE_LOGIN(107, "Multiple login detected"),
    EXECUTION_FAILED(400, "Execution failed."),
    PARAM_INVALID(401, "Parameter invalid."),
    CAEA_DISABLED(402, "Camera disabled."),
    LICENCE_ERROR(403, "Insufficient license."),
    CODE_ACTICATION_ERROR(404, "Codec acitvation failed"),
    CMS_SERVER_CONMNECT_FAILED(405, "CMS server connection failed."),
    CMS_CLOSED(407, "CMS closed."),
    MISSING_LICENSE(412, "Need to add license."),
    PLATFORM_MAX_REACHED(413, "Reach the maximum of platform."),
    EVENT_NOT_EXIST(414, "Some events not exist."),
    MESSAGE_CONNECT_ERROR(415, "message connect failed"),
    TEST_CONNETCION_ERROR(417, "Test Connection Error."),
    VISUAL_NAME_REPITITION(419, "Visualstation name repetition."),
    TOO_MANY_ITEMS(439, "Too many items selected.");

    private final int code;
    private final String msg;

    WebApiErrorCodes(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    static Map<Integer, WebApiErrorCodes> map = new HashMap<>();

    static {
        for (WebApiErrorCodes catalog : WebApiErrorCodes.values()) {
            map.put(catalog.code, catalog);
        }
    }

    public static WebApiErrorCodes getByCode(int code) {

        return map.get(code);
    }

}
