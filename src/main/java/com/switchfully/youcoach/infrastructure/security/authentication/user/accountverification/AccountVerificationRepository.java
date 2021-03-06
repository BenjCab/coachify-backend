package com.switchfully.youcoach.infrastructure.security.authentication.user.accountverification;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountVerificationRepository extends CrudRepository<AccountVerification, Long> {
    void deleteAccountVerificationByProfileId(Long profileId);

    Optional<AccountVerification> findAccountVerificationByProfileId(Long profileId);
}
