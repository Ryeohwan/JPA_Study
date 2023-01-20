package mpti.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BasicResponse<Type> {
    private String message;
    private Type data;

    @Builder
    public BasicResponse(String message, Type data) {
        this.message = message;
        this.data = data;
    }
}
