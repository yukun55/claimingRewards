package com.chrisyu.questclaiming.service;
import com.chrisyu.questclaiming.exceptions.RewardAlreadyClaimedException;
import com.chrisyu.questclaiming.model.ClaimedRewards;
import com.chrisyu.questclaiming.model.ClaimedRewardsId;
import com.chrisyu.questclaiming.repository.ClaimedRewardsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ClaimedRewardsServiceTest {
    @Autowired
    private ClaimedRewardsService claimedRewardsService;
    @Autowired
    private ClaimedRewardsRepository claimedRewardsRepository;

    @Test
    public void addClaimedRewardsThrowsException(){
        ClaimedRewards rewards = new ClaimedRewards(new ClaimedRewardsId("1", "1"), Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        claimedRewardsRepository.save(rewards);
        assertThrows(RewardAlreadyClaimedException.class, ()->{
            claimedRewardsService.addClaimReward(rewards);
        });
    }

    @Test
    public void addNewClaimedRewardsToCollection() {
        ClaimedRewards rewards = new ClaimedRewards(new ClaimedRewardsId("2", "1"), Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        claimedRewardsRepository.save(rewards);
        ClaimedRewards rewardsToTest = new ClaimedRewards(new ClaimedRewardsId("2", "2"), Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        claimedRewardsService.addClaimReward(rewardsToTest);
        assertTrue(claimedRewardsRepository.existsById(new ClaimedRewardsId("2", "2")));
    }
}
