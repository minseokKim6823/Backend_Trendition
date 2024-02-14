package Trendithon.SpinOff.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditInformation {
    private String memberId;
    private Long profileId;
    private String introduce;
    private String job;
    private String specificDuty;
    private String link;
    private Set<String> technics;
}
