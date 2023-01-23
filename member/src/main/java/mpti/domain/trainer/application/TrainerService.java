package mpti.domain.trainer.application;


import lombok.RequiredArgsConstructor;
import mpti.domain.trainer.dao.TrainerRepository;
import mpti.domain.trainer.entity.Trainer;

import javax.transaction.Transactional;



@RequiredArgsConstructor
@Transactional
public class TrainerService {

    private final TrainerRepository trainerRepository;
    public boolean isEmailDuplicate(String email) {
        if (trainerRepository.existsByEmail(email)) {
            return true;
        }
        return false;
    }

    public Long join(Trainer trainer) {
        trainerRepository.save(trainer);
        return trainer.getId();
    }


}
