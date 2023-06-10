package controller;

import domain.dto.ReviewDto;
import service.ReviewService;

import java.util.List;

public class ReviewController {
    private static ReviewController controller;

    public static ReviewController getController() {
        if(controller == null) controller = new ReviewController();
        return controller;
    }
    public void insertReview() {
        // 먼저 내가 본 영화를 조회 한다.
        ReviewService.getService().myWatchedMovies();
    }

    public void myReviewList() {
        ReviewService.getService().myReviewList();
    }
}
