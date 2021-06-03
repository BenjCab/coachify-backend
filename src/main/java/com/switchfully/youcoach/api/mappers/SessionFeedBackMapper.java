package com.switchfully.youcoach.api.mappers;

import com.switchfully.youcoach.api.DTOs.SessionFeedbackCoacheeDTO;
import com.switchfully.youcoach.domain.Session;
import com.switchfully.youcoach.domain.SessionFeedbackCoachee;
import com.switchfully.youcoach.service.SessionService;
import org.springframework.stereotype.Component;

@Component
public class SessionFeedBackMapper {


    public SessionFeedBackMapper() {

    }

    public SessionFeedbackCoachee toFeedBackCoacheeEntity(SessionFeedbackCoacheeDTO sessionFeedbackCoacheeDTO) {
        return new SessionFeedbackCoachee().setExplanationRating(sessionFeedbackCoacheeDTO.getExplanationRating())
                .setUsefulRating(sessionFeedbackCoacheeDTO.getUsefulRating())
                .setComment1(sessionFeedbackCoacheeDTO.getComment1())
                .setComment2(sessionFeedbackCoacheeDTO.getComment2());
    }

    public SessionFeedbackCoacheeDTO toFeedBackCoacheeDTO(SessionFeedbackCoachee sessionFeedbackCoachee) {
        if (sessionFeedbackCoachee == null) {
            return new SessionFeedbackCoacheeDTO();
        }
        return new SessionFeedbackCoacheeDTO().setSessionFeedbackCoacheeId(sessionFeedbackCoachee.getSession_feedback_id())
                .setExplanationRating(sessionFeedbackCoachee.getExplanationRating())
                .setUsefulRating(sessionFeedbackCoachee.getUsefulRating())
                .setComment1(sessionFeedbackCoachee.getComment1())
                .setComment2(sessionFeedbackCoachee.getComment2());
    }
}
