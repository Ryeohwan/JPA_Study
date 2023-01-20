package mpti.common;

import mpti.domain.member.dto.BasicResponse;
import org.springframework.stereotype.Component;

@Component
public class MakeBasicResponse {
    public <T> BasicResponse<T> makeBasicResponse(String message, T data) {
        return BasicResponse.<T>builder()
                .message(message)
                .data(data)
                .build();
    }
}
