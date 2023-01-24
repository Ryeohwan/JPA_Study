package mpti.backend.domain.trainer.application;


import lombok.RequiredArgsConstructor;
import mpti.backend.domain.trainer.dao.TrainerRepository;
import mpti.backend.domain.trainer.entity.Trainer;

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
