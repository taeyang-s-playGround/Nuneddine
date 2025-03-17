package project.software.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    //회원가입시 이미 존재함
    ACCOUNT_ID_ALREADY_EXISTS(409,"accountId already exists"),
    NICKNAME_ALREADY_EXISTS(409,"nickname already exists"),
    BAD_REQUEST(400, "Bad request"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    USER_NOT_FOUND(404, "User Not Found"),
    USER_ALREADY_EXISTS(409,"User already exists"),
    PASSWORD_MISMATCH(401, "Password Mismatch"),

    POST_NOT_FOUND(404, "Post Not Found"),
    CANNOT_MODIFY_POST(403, "Cannot Modify Post"),
    EMPTY_FILE_EXCEPTION(400, "Empty File"),
    IMAGE_NOT_FOUND_EXCEPTION(400, "Not File "),
    INVALID_FILE_EXTENTION(400, "Invalid File Extension"),

    // S3 업로드 관련 예외
    IO_EXCEPTION_ON_IMAGE_UPLOAD(500, "IO Exception on Image Upload"),
    PUT_OBJECT_EXCEPTION(500, "Failed to Upload Object to S3"),
    WRONG_IMAGE(400, "Wrong Image"),

    // S3 삭제 관련 예외
    IO_EXCEPTION_ON_IMAGE_DELETE(500, "IO Exception on Image Delete"),

    // 이미지 목록 조회 예외
    EXCEPTION_ON_LIST_IMAGES(500, "Failed to Retrieve Image List"),

    EXPIRED_TOKEN(403, "Expired token"),
    INVALID_TOKEN(403, "Invalid token"),

    JwtSigningException(403,"JWT Signing Exception");

    private final int status;
    private final String message;
}