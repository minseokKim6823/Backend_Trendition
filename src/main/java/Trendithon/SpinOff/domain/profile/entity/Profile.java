package Trendithon.SpinOff.domain.profile.entity;

import Trendithon.SpinOff.domain.member.dto.EditInformation;
import Trendithon.SpinOff.domain.member.dto.Information;

import Trendithon.SpinOff.domain.member.dto.ProfileInformation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String introduce;
    private String job;
    private String specificDuty;
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProfileTechnic> profileTechnics = new HashSet<>();
    private String link;

    public void add(Information information) {
        this.introduce = information.getIntroduce();
        this.job = information.getJob();
        this.specificDuty = information.getSpecificDuty();
        this.link = information.getLink();
    }

    public boolean edit(EditInformation editInformation) {
        if (editInformation.getIntroduce() != null && !editInformation.getIntroduce().isEmpty()) {
            this.introduce = editInformation.getIntroduce();
        }
        if (editInformation.getJob() != null && !editInformation.getJob().isEmpty()) {
            this.job = editInformation.getJob();
        }
        if (editInformation.getSpecificDuty() != null && !editInformation.getSpecificDuty().isEmpty()) {
            this.specificDuty = editInformation.getSpecificDuty();
        }
        if (editInformation.getLink() != null && !editInformation.getLink().isEmpty()) {
            this.link = editInformation.getLink();
        }
        return true;
    }

    public ProfileInformation toDto() {
        return ProfileInformation.builder()
                .introduce(introduce)
                .job(job)
                .specificDuty(specificDuty)
                .likeCount(likeCount)
                .link(link)
                .build();
    }
}