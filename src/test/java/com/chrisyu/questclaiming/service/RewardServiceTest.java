package com.chrisyu.questclaiming.service;
import com.chrisyu.questclaiming.exceptions.RewardAlreadyClaimedException;
import com.chrisyu.questclaiming.exceptions.RewardAlreadyExistException;
import com.chrisyu.questclaiming.model.ClaimedReward;
import com.chrisyu.questclaiming.model.ClaimedRewardId;
import com.chrisyu.questclaiming.model.Reward;
import com.chrisyu.questclaiming.repository.ClaimedRewardRepository;
import com.chrisyu.questclaiming.repository.RewardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RewardServiceTest {
    @Autowired
    private RewardService rewardService;
    @Autowired
    private RewardRepository rewardRepository;
    @Autowired
    private ClaimedRewardRepository claimedRewardRepository;

    @Test
    @DisplayName("Test Should Pass When RewardService Context Successfully Load")
    public void shouldLoadContext() throws Exception {
        // we test that our RewardService is not null
        assertThat(rewardService).isNotNull();
    }

    @Test
    @DisplayName("Test Should Pass When Add New Reward")
    public void shouldPassWhenAddNewReward() {
        Reward reward = new Reward(null, 0.0, false);
        Reward rewardToTest = rewardService.addReward(reward);
        assertEquals(reward.getId(), rewardToTest.getId());
    }

    @Test
    @DisplayName("Test Should Pass When Add New ClaimedReward")
    public void shouldPassWhenAddNewClaimedReward() {
        String rewardId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();
        rewardRepository.save(new Reward(rewardId, 0.0, false));
        ClaimedReward reward = new ClaimedReward(new ClaimedRewardId(rewardId, userId), Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        ClaimedReward rewardToTest = rewardService.addClaimedReward(reward);
        assertEquals(reward.getId(), rewardToTest.getId());
    }

    @Test
    @DisplayName("Test Should Throws Exception When Add A Exist ClaimedReward")
    public void shouldThrowsExceptionWhenClaimedRewardExist(){
        ClaimedReward reward = new ClaimedReward(new ClaimedRewardId(UUID.randomUUID().toString(), UUID.randomUUID().toString()), Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        claimedRewardRepository.save(reward);
        assertThrows(RewardAlreadyClaimedException.class, ()->{
            rewardService.addClaimedReward(reward);
        });
    }

    @Test
    @DisplayName("Test Should Set Reward isClaimed To True After Add To ClaimedReward Collection")
    public void shouldSetRewardIsClaimed(){
        String rewardId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();
        rewardRepository.save(new Reward(rewardId, 0.0, false));
        ClaimedReward claimedReward = new ClaimedReward(new ClaimedRewardId(rewardId, userId), Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        rewardService.addClaimedReward(claimedReward);
        assertTrue(rewardService.getReward(rewardId).isClaim());
    }
}
