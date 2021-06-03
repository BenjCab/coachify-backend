package com.switchfully.youcoach.api.mappers;

import com.switchfully.youcoach.api.DTOs.SessionFeedbackCoachDTO;
import com.switchfully.youcoach.api.DTOs.SessionFeedbackCoacheeDTO;
import com.switchfully.youcoach.domain.Session;
import com.switchfully.youcoach.domain.SessionFeedbackCoach;
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
        return new SessionFeedbackCoacheeDTO()
                .setSessionFeedbackCoacheeId(sessionFeedbackCoachee.getSession_feedback_id())
                .setExplanationRating(sessionFeedbackCoachee.getExplanationRating())
                .setUsefulRating(sessionFeedbackCoachee.getUsefulRating())
                .setComment1(sessionFeedbackCoachee.getComment1())
                .setComment2(sessionFeedbackCoachee.getComment2());
    }

    public SessionFeedbackCoach toFeedBackCoachEntity(SessionFeedbackCoachDTO sessionFeedbackCoach) {
        return new SessionFeedbackCoach().setRating1(sessionFeedbackCoach.getRating1())
                .setRating2(sessionFeedbackCoach.getRating2())
                .setComment1(sessionFeedbackCoach.getComment1())
                .setComment2(sessionFeedbackCoach.getComment2());
    }

    public SessionFeedbackCoachDTO toFeedBackCoachDTO(SessionFeedbackCoach sessionFeedbackCoach) {
        if (sessionFeedbackCoach == null) {
            return new SessionFeedbackCoachDTO();
        }
        return new SessionFeedbackCoachDTO()
                .setSessionFeedbackCoacheeId(sessionFeedbackCoach.getSession_feedback_id())
                .setRating1(sessionFeedbackCoach.getRating1())
                .setRating2(sessionFeedbackCoach.getRating2())
                .setComment1(sessionFeedbackCoach.getComment1())
                .setComment2(sessionFeedbackCoach.getComment2());
    }
}
