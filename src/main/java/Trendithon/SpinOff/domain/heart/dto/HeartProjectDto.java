package Trendithon.SpinOff.domain.heart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class HeartProjectDto {
    private Long memberId;
    private Long bno;
}
